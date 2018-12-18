package com.ihappy.store.application.process.write.ordercompanyjournal;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.OrderCompanyJournalByCompIdBO;
import com.ihappy.company.domain.bo.OrderCompanyJournalByIdBO;
import com.ihappy.company.domain.bo.UpdateOrderCompanyJournalBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.UpdateOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.UpdateOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新单据
 * Created by liuhc on 2018/6/30.
 */
public class UpdateOrderCompanyJournalProcess extends DefaultProcess<UpdateOrderCompanyJournalReqDTO, UpdateOrderCompanyJournalRespDTO> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<UpdateOrderCompanyJournalReqDTO, UpdateOrderCompanyJournalRespDTO> context) {

        UpdateOrderCompanyJournalReqDTO updateOrderCompanyJournalReqDTO = context.getParam();

        OrderCompanyJournalByIdBO orderCompanyJournalByIdBO = new OrderCompanyJournalByIdBO();
        orderCompanyJournalByIdBO.setOrderId(updateOrderCompanyJournalReqDTO.getOrderId());

        OrderCompanyJournalModel orderCompanyJournalModel = orderCompanyJournalService.getOrderCompanyJournalDetailById(orderCompanyJournalByIdBO);
        if(orderCompanyJournalModel == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_NOT_ISEXIST.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_NOT_ISEXIST.getErrMsg());
        }
        //1.作废
        if (orderCompanyJournalModel.getCancelFlag() == 1) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_USE_CANCEL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_USE_CANCEL.getErrMsg());
        }
        //是否已经被审核通过 2审核通过
        if (orderCompanyJournalModel.getCancelFlag() == 2) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_USE_PASS.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_USE_PASS.getErrMsg());
        }
        //判断外部订单号是否重复
        if(!StringUtil.isBlank(updateOrderCompanyJournalReqDTO.getSourceOrderNo())){
            //作废过的单子，外部订单号还可以继续使用
            List<Integer> cancelList = new ArrayList<>();
            OrderCompanyJournalByCompIdBO orderCompanyJournalByCompIdBO = new OrderCompanyJournalByCompIdBO();
            orderCompanyJournalByCompIdBO.setSourceOrderNo(updateOrderCompanyJournalReqDTO.getSourceOrderNo());
            cancelList.add(2);
            cancelList.add(0);
            orderCompanyJournalByCompIdBO.setCancelList(cancelList);
            List<OrderCompanyJournalModel> checkList = orderCompanyJournalService.getOrderCompanyJournalDetailByCompId(orderCompanyJournalByCompIdBO);
            if(!CollectionUtil.isEmpty(checkList) && checkList.get(0).getDO().getOrderId().longValue()
                    != updateOrderCompanyJournalReqDTO.getOrderId().longValue()){//单号不能促发
                throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_SOURCE_NO_ERROR);
            }
        }
        UpdateOrderCompanyJournalBO updateOrderCompanyJournalBO = OrderCompanyJournalFactory.toUpdateOrderCompanyJournalBO(updateOrderCompanyJournalReqDTO);
        //更换公司
        if(updateOrderCompanyJournalBO.getCompId().longValue() != orderCompanyJournalModel.getCompId().longValue()){
            //获取公司信息
            CompanyInfoWithoutLoginQueryReqDTO companyInfo = new CompanyInfoWithoutLoginQueryReqDTO();
            companyInfo.setCompId(Integer.parseInt(updateOrderCompanyJournalBO.getCompId()+""));
            BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoWithoutLoginQueryReqDTOTOBaseinfoCompany(companyInfo));
            if(baseinfoCompany == null){
                throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ISEXIST);
            }
            CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
            companyStoreModel.getDO().setCompId(updateOrderCompanyJournalReqDTO.getCompId().intValue());
            companyStoreModel.getDO().setStoreId(updateOrderCompanyJournalReqDTO.getStoreId());
            //查询门店详情
            CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
            //如果门店为空，则不存在
            if (storeInfo == null) {
                throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
            }

            updateOrderCompanyJournalBO.setRegisterPersonId(baseinfoCompany.getAdminPersonId());
            updateOrderCompanyJournalBO.setRegisterPersonMobile(baseinfoCompany.getAdminPersonMobile());
            updateOrderCompanyJournalBO.setCtId(Integer.parseInt(baseinfoCompany.getCtIds()));
            updateOrderCompanyJournalBO.setRegisterTime(baseinfoCompany.getCreatedAt());
            //调用户中心接口 获取老板信息
            BaseinfoPersonRespDTO baseinfoPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(baseinfoCompany.getAdminPersonId(), ConfigCenterUtil.ENV);
            if(baseinfoPersonRespDTO != null){
                updateOrderCompanyJournalBO.setRegisterPersonId(baseinfoPersonRespDTO.getPersonId());//注册人id
                updateOrderCompanyJournalBO.setRegisterPersonMobile(baseinfoPersonRespDTO.getMobile());//注册人手机号
                //获取邀请人信息
                if(baseinfoPersonRespDTO.getpPersonId() !=0L){
                    BaseinfoPersonRespDTO invitePerson = SysAndPersonRedisUtil.getUserInfoKey(baseinfoPersonRespDTO.getpPersonId(), ConfigCenterUtil.ENV);
                    if(invitePerson != null){
                        updateOrderCompanyJournalBO.setInvitePersonMobile(invitePerson.getMobile());//邀请人手机号
                        updateOrderCompanyJournalBO.setInvitePersonId(invitePerson.getPersonId());//邀请人id
                    }else {
                        updateOrderCompanyJournalBO.setInvitePersonMobile("");//邀请人手机号
                        updateOrderCompanyJournalBO.setInvitePersonId(0L);//邀请人id
                    }
                }else {
                    updateOrderCompanyJournalBO.setInvitePersonMobile("");//邀请人手机号
                    updateOrderCompanyJournalBO.setInvitePersonId(0L);//邀请人id
                }
            }else {
                updateOrderCompanyJournalBO.setRegisterPersonId(0L);//注册人id
                updateOrderCompanyJournalBO.setRegisterPersonMobile("");//注册人手机号
                updateOrderCompanyJournalBO.setInvitePersonMobile("");//邀请人手机号
                updateOrderCompanyJournalBO.setInvitePersonId(0L);//邀请人id
            }
        }
        //获取运营人员信息
        updateOrderCompanyJournalBO.setMemoPersonId(updateOrderCompanyJournalReqDTO.getLoginPersonId());
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKeySys(-1,updateOrderCompanyJournalReqDTO.getLoginPersonId(), ConfigCenterUtil.ENV);
        if(orgRespDTO != null) {
            if (StringUtil.isBlank(orgRespDTO.getPersonName())) {
                BaseinfoPersonRespDTO sysPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(updateOrderCompanyJournalReqDTO.getLoginPersonId(), ConfigCenterUtil.ENV);
                if (sysPersonRespDTO != null) {
                    updateOrderCompanyJournalBO.setMemoPersonName(sysPersonRespDTO.getPersonName());
                }
            } else {
                updateOrderCompanyJournalBO.setMemoPersonName(orgRespDTO.getPersonName());
            }
        }else {
            updateOrderCompanyJournalBO.setMemoPersonName("");
        }
        int row = orderCompanyJournalService.updateOrderCompanyJournalById(updateOrderCompanyJournalBO);
        if(row == 0){
            throw new CompanyException(CompanyErrorCodeEnum.OPERATE_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.OPERATE_ERROR.getErrMsg());
        }
        UpdateOrderCompanyJournalRespDTO updateOrderCompanyJournalRespDTO = new UpdateOrderCompanyJournalRespDTO();
        updateOrderCompanyJournalRespDTO.setMessage("修改成功");
        context.getResult().setModule(updateOrderCompanyJournalRespDTO);
    }
}
