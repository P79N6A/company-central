package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.constans.MessInfoConstants;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.message.common.enumtype.MessageChannelEnum;
import com.ihappy.message.common.enumtype.MessageSourceEnum;
import com.ihappy.message.common.enumtype.MessageTypeEnum;
import com.ihappy.message.domain.dto.Receiver;
import com.ihappy.message.domain.dto.Sender;
import com.ihappy.message.domain.dto.request.SysMessageReqDTO;
import com.ihappy.message.infrastructure.service.MessageWriteRpcService;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dto.request.partner.AddInvateRegisterPartnerReqDTO;
import com.ihappy.partner.domain.dto.response.partner.AddInvateRegisterPartnerRespDTO;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/12.
 */
public class AddPartnerByInvateRegisterProcess extends DefaultProcess<AddInvateRegisterPartnerReqDTO, AddInvateRegisterPartnerRespDTO> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private MessageWriteRpcService messageWriteRpcServiceClient;
    @Override
    public void process(Context<AddInvateRegisterPartnerReqDTO, AddInvateRegisterPartnerRespDTO> context) {
        AddInvateRegisterPartnerReqDTO reqDTO = context.getParam();
        BaseinfoCompanyPartner resPartner = new BaseinfoCompanyPartner();

        Integer compId = Integer.valueOf(reqDTO.getCompId().toString());
        Integer partnerCompId = Integer.valueOf(reqDTO.getPartnerCompId().toString());
        Integer partnerType = reqDTO.getPartnerType();
        String registerCompanyMobile = reqDTO.getRegisterCompanyMobile();
        Long receiveUserId = reqDTO.getReceiveUserId();
        String partnerName = reqDTO.getPartnerName();

        //邀请公司-发起邀请的公司
        BaseinfoCompany invateCompany = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if(invateCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        //注册公司-被邀请注册公司
        BaseinfoCompany registerCompany = baseinfoCompanyMapper.selectByPrimaryKey(partnerCompId);
        if(registerCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    REGISTER_COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.REGISTER_COMPANY_IS_EMPTY.getErrMsg());
        }
        BaseinfoCompanyPartner partnerParam = new BaseinfoCompanyPartner();
        partnerParam.setCompId(compId);
        partnerParam.setPartnerType(partnerType);
        partnerParam.setMobile(registerCompanyMobile);
        List<BaseinfoCompanyPartner> oldPartners = baseinfoCompanyPartnerMapper.selectSelective(partnerParam);
        BaseinfoCompanyPartner updatePartner = null;
        Boolean needAddPartner = true;
        if (CollectionUtils.isEmpty(oldPartners)){
            needAddPartner = true;
        }else {
            //未关联公司的Partner
            for (BaseinfoCompanyPartner obj : oldPartners){
                //已经存在直接返回
                if (partnerCompId.equals(obj.getPartnerCompId())){
                    AddInvateRegisterPartnerRespDTO respDTO = new AddInvateRegisterPartnerRespDTO();
                    respDTO.setPartnerId(obj.getPartnerId());
                    context.getResult().setModule(respDTO);
                    return;
                }
                if (obj.getPartnerCompId() == null || obj.getPartnerCompId() == 0){
                    updatePartner = obj;
                    needAddPartner = false;
                }
            }
        }
        if (needAddPartner){
            BaseinfoCompanyPartner addPartnerParam = new BaseinfoCompanyPartner();
            addPartnerParam.setCompId(compId);
            addPartnerParam.setPartnerCompId(partnerCompId);
            addPartnerParam.setMobile(registerCompanyMobile);
            addPartnerParam.setPartnerType(partnerType);
            addPartnerParam.setCompName(invateCompany.getCompShortName());
            addPartnerParam.setPartnerName(partnerName);
            addPartnerParam.setPartnerLinkman(partnerName);
            addPartnerParam.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
            addPartnerParam.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));

            CompanyPartnerModel partnerModel = companyPartnerService.addPartner(new CompanyPartnerModel(addPartnerParam));
            resPartner = partnerModel.getDO();
            //发送消息
            sendInvitePartnerMessage(partnerType,Long.valueOf(compId),receiveUserId,registerCompanyMobile,partnerName,reqDTO.getRegistType());

            //添加被邀请公司的 Partner
            addPartnerParam.setCompId(partnerCompId);
            addPartnerParam.setPartnerCompId(compId);
            addPartnerParam.setMobile(invateCompany.getAdminPersonMobile());
            if (CompanyPartnerTypeEnum.CUSTOMER.getKey().equals(partnerType)){
                addPartnerParam.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
            }else if (CompanyPartnerTypeEnum.PROVIDER.getKey().equals(partnerType)){
                addPartnerParam.setPartnerType(CompanyPartnerTypeEnum.CUSTOMER.getKey());
            }
            addPartnerParam.setCompName(registerCompany.getCompShortName());
            addPartnerParam.setPartnerName(invateCompany.getCompShortName());
            addPartnerParam.setPartnerLinkman(invateCompany.getAdminPersonName());
            addPartnerParam.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
            addPartnerParam.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
            partnerModel = companyPartnerService.addPartner(new CompanyPartnerModel(addPartnerParam));

        }else {
            updatePartner.setPartnerCompId(partnerCompId);
            Integer res = companyPartnerService.updateProvider(updatePartner);
            if (res != 1){
                throw new CompanyException(PartnerErrorCodeEnum.
                        UPDATE_PARTNER_ERROR.getErrCode(),
                        PartnerErrorCodeEnum.UPDATE_PARTNER_ERROR.getErrMsg());
            }
            resPartner = updatePartner;
        }
        AddInvateRegisterPartnerRespDTO respDTO = new AddInvateRegisterPartnerRespDTO();
        respDTO.setPartnerId(resPartner.getPartnerId());
        context.getResult().setModule(respDTO);
    }

    /**
     * 发送消息
     * @param partnerType
     * @param compId         邀请人公司id
     * @param personId      邀请人用户id
     * @param mobile        被邀请人手机号
     * @param partnerName  被邀请人姓名
     */
    public void sendInvitePartnerMessage(Integer partnerType,Long compId,Long personId,String mobile,String partnerName,Integer registType){
        if(partnerType != null && partnerType == 1){//客户
            SysMessageReqDTO customer = new SysMessageReqDTO();
            String msgContent = "";
            String msgTitle = "";
            if (1 == registType){
                msgContent = MessInfoConstants.CUSTOMER_INVITE_CONTENT;
                msgTitle = MessInfoConstants.CUSTOMER_INVITE_TITLE;
            }else if (2 == registType){
                msgContent = MessInfoConstants.CUSTOMER_REGISTER_CONTENT;
                msgTitle = MessInfoConstants.CUSTOMER_REGISTER_TITLE;
            }
            customer.setContent(String.format(msgContent,partnerName,mobile));
            customer.setTitle(msgTitle);
            customer.setDetailUrl(MessInfoConstants.CUSTOMER_URL);
            Sender senderCustomer = new Sender();
            senderCustomer.setIdentity(MessageSourceEnum.SYS.name());
            senderCustomer.setChannel(MessageChannelEnum.MAIL.name());

            customer.setSenderObj(senderCustomer);

            Receiver receiverCustomer = new Receiver();
            receiverCustomer.setUserId(personId);
            receiverCustomer.setCompId(compId);
            receiverCustomer.setChannel(MessageChannelEnum.MAIL.name());
            List<Receiver> listCustomer = new ArrayList<Receiver>();
            listCustomer.add(receiverCustomer);
            customer.setReceiversList(listCustomer);
            customer.setType(MessageTypeEnum.PLATFORM_ACCOUNT.getCode());
            messageWriteRpcServiceClient.sendSysMessage(customer);
        }else if(partnerType != null && partnerType == 0){//供应商
            SysMessageReqDTO supper = new SysMessageReqDTO();
            String msgContent = "";
            String msgTitle = "";
            if (1 == registType){
                msgContent = MessInfoConstants.SUPLY_INVITE_CONTENT;
                msgTitle = MessInfoConstants.SUPLY_INVITE_TITLE;
            }else if (2 == registType){
                msgContent = MessInfoConstants.SUPLY_REGISTER_CONTENT;
                msgTitle = MessInfoConstants.SUPLY_REGISTER_TITLE;
            }
            supper.setDetailUrl(MessInfoConstants.SUPLY_URL);
            supper.setContent(String.format(msgContent,partnerName,mobile));
            supper.setTitle(msgTitle);

            Sender senderSupper = new Sender();
            senderSupper.setIdentity(MessageSourceEnum.SYS.name());
            senderSupper.setChannel(MessageChannelEnum.MAIL.name());

            supper.setSenderObj(senderSupper);

            Receiver receiverSupper = new Receiver();
            receiverSupper.setUserId(personId);
            receiverSupper.setCompId(compId);
            receiverSupper.setChannel(MessageChannelEnum.MAIL.name());
            List<Receiver> listSupper = new ArrayList<Receiver>();
            listSupper.add(receiverSupper);
            supper.setReceiversList(listSupper);
            supper.setType(MessageTypeEnum.PLATFORM_ACCOUNT.getCode());
            messageWriteRpcServiceClient.sendSysMessage(supper);
        }
    }
}
