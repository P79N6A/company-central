package com.ihappy.store.application.process.write.ordercompanyjournal;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.service.outside.trade.PayJournalWriteOutService;
import com.ihappy.communal.infrastructure.service.outside.user.SysPerosnInfoOutSideService;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.PayPlatformCodeEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.CancelOrderCompanyJournalBO;
import com.ihappy.company.domain.bo.OrderCompanyJournalByCompIdBO;
import com.ihappy.company.domain.bo.OrderCompanyJournalByIdBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyExtendServiceJournal;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyExtendService;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.trade.domain.dto.request.pay.AddPayJournalReqDTO;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.request.sys.AddSysInviteGoldDetailReqDTO;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import com.ihappy.user.domain.dto.response.sys.SysPersonRespDTO;
import com.ihappy.user.domain.query.sys.SysUserBasicInfoByPersonIdQuery;
import com.ihappy.user.service.sys.SysCenterInsideRpcWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 审核通过
 * Created by liuhc on 2018/7/8.
 */
public class PassReviewOrderCompanyJournalProcess  extends DefaultProcess<PassOrFailReviewOrderCompanyJournalReqDTO, PassOrFailReviewOrderCompanyJournalRespDTO> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Autowired
    private CompanyExtendService companyExtendService;

    @Autowired
    private PayJournalWriteOutService payJournalWriteOutService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private SysPerosnInfoOutSideService sysPerosnInfoOutSideService;

    @Autowired
    private SysCenterInsideRpcWriteService sysCenterInsideRpcWriteServiceClient;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<PassOrFailReviewOrderCompanyJournalReqDTO, PassOrFailReviewOrderCompanyJournalRespDTO> context) {

        PassOrFailReviewOrderCompanyJournalReqDTO passReviewOrderCompanyJournalReqDTO = context.getParam();

        OrderCompanyJournalByIdBO orderCompanyJournalByIdBO = new OrderCompanyJournalByIdBO();
        orderCompanyJournalByIdBO.setOrderId(passReviewOrderCompanyJournalReqDTO.getOrderId());

        OrderCompanyJournalModel orderCompanyJournalModel = orderCompanyJournalService.getOrderCompanyJournalDetailById(orderCompanyJournalByIdBO);
        if (orderCompanyJournalModel == null) {
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
        //获取公司信息
        CompanyInfoWithoutLoginQueryReqDTO companyInfo = new CompanyInfoWithoutLoginQueryReqDTO();
        companyInfo.setCompId(Integer.parseInt(orderCompanyJournalModel.getCompId()+""));
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoWithoutLoginQueryReqDTOTOBaseinfoCompany(companyInfo));
        if(baseinfoCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ISEXIST);
        }
        CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
        companyStoreModel.getDO().setCompId(orderCompanyJournalModel.getCompId().intValue());
        companyStoreModel.getDO().setStoreId(orderCompanyJournalModel.getDO().getStoreId());
        //查询门店详情
        CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
        //如果门店为空，则不存在
        if (storeInfo == null) {
            throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
        }

        Long expireDate = 0L;
        Long startExpireDate = 0L;
        //获取服务到期时间
        if(storeInfo.getDO().getExpireDate() != null && storeInfo.getDO().getExpireDate() != 0L
                && DateUtil.compareDate(DateUtil.parseDateYMD(storeInfo.getDO().getExpireDate()+""),new Date()) >= 0) {
            Date date = DateUtil.subOrAddYear(DateUtil.parseDateYMD(storeInfo.getDO().getExpireDate()+""),1);
            expireDate = CompanyDateUtil.getDate14Long(date);
            startExpireDate = storeInfo.getDO().getExpireDate();
        }else {//当前时间加1年
            Date nowDate = new Date();
            Date date = DateUtil.subOrAddYear(nowDate,1);
            expireDate = CompanyDateUtil.getDate14Long(date);
            startExpireDate = CompanyDateUtil.getDate14Long(nowDate);
        }
        //新增缴费记录流水
        BaseinfoCompanyExtendServiceJournal companyExtendServiceJournal = OrderCompanyJournalFactory.toBaseinfoCompanyExtend(orderCompanyJournalModel);
        companyExtendServiceJournal.setUpdatedPersonId(passReviewOrderCompanyJournalReqDTO.getLoginPersonId());
        companyExtendServiceJournal.setCreatedPersonId(passReviewOrderCompanyJournalReqDTO.getLoginPersonId());
        //查用户名称
        SysUserBasicInfoByPersonIdQuery sysUserBasicInfoByPersonIdQuery = new SysUserBasicInfoByPersonIdQuery();
        sysUserBasicInfoByPersonIdQuery.setDeletedFlag(0);
        sysUserBasicInfoByPersonIdQuery.setCompId(passReviewOrderCompanyJournalReqDTO.getLoginCompId());
        sysUserBasicInfoByPersonIdQuery.setPersonId(passReviewOrderCompanyJournalReqDTO.getLoginPersonId());
        SysPersonRespDTO sysPersonRespDTO = sysPerosnInfoOutSideService.querySysPerson(sysUserBasicInfoByPersonIdQuery,true);

        CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO = getCancelOrderCompanyJournalBO(passReviewOrderCompanyJournalReqDTO);
        if (sysPersonRespDTO != null){
            cancelOrderCompanyJournalBO.setAuditorName(sysPersonRespDTO.getPersonName());
            if (StringUtil.isBlank(cancelOrderCompanyJournalBO.getAuditorName())){
                cancelOrderCompanyJournalBO.setAuditorName(sysPersonRespDTO.getMobile());
            }
        }
        cancelOrderCompanyJournalBO.setIsCancel(2);//审核通过
        cancelOrderCompanyJournalBO.setServiceDueTime(expireDate);//开始时间
        cancelOrderCompanyJournalBO.setServiceStartTime(startExpireDate);//结束时间
        int row = companyTransactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                //更新标识 单据标识
               int row = orderCompanyJournalService.cancelOrderCompanyJournalById(cancelOrderCompanyJournalBO);
               if(row == 0){
                   throw new CompanyException(CompanyErrorCodeEnum.OPERATE_ERROR);
               }
               Long journalId  = companyExtendService.addCompanyExtendServiceJournal(new CompanyExtendServiceJournalModel(companyExtendServiceJournal));
               if(journalId == null || journalId <= 0L){
                    throw new CompanyException(CompanyErrorCodeEnum.ORDER_COMPANY_JOURNAL_OPERATE_ERROR);
               }
                return 1;
            }
        });

        //新增交易中心流水记录
        insertPayJournal(orderCompanyJournalModel.getDO(), storeInfo);

        //判断是否是第一次缴费
        OrderCompanyJournalByCompIdBO orderCompanyJournalByCompIdBO = new OrderCompanyJournalByCompIdBO();
        orderCompanyJournalByCompIdBO.setCompId(orderCompanyJournalModel.getCompId());
        orderCompanyJournalByCompIdBO.setIsCancel(2);
        List<OrderCompanyJournalModel> checkList = orderCompanyJournalService.getOrderCompanyJournalDetailByCompId(orderCompanyJournalByCompIdBO);
        if(!CollectionUtil.isEmpty(checkList) && checkList.size() == 1){
            OrderCompanyJournalModel invitePerson = checkList.get(0);
            if(invitePerson.getInvitePersonId() != null && invitePerson.getInvitePersonId() > 0L){
                //sendGold(invitePerson);
            }
        }

        PassOrFailReviewOrderCompanyJournalRespDTO respDTO = new PassOrFailReviewOrderCompanyJournalRespDTO();
        respDTO.setMessage("操作成功");
        context.getResult().setModule(respDTO);
    }

    //发送红包
    private void sendGold(OrderCompanyJournalModel orderCompanyJournalModel) {
        OrderCompanyJournal orderCompanyJournal = orderCompanyJournalModel.getDO();
        BaseinfoPersonRespDTO baseinfoPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(orderCompanyJournal.getInvitePersonId(), ConfigCenterUtil.ENV);
        AddSysInviteGoldDetailReqDTO addSysInviteGoldDetailReqDTO = new AddSysInviteGoldDetailReqDTO();
        addSysInviteGoldDetailReqDTO.setCreatedPersonId(orderCompanyJournal.getUpdatedPersonId());
        addSysInviteGoldDetailReqDTO.setGold(orderCompanyJournal.getPayMoney());
        addSysInviteGoldDetailReqDTO.setGoldPayNo(orderCompanyJournal.getSourceOrderNo());
        addSysInviteGoldDetailReqDTO.setGoldPayTime(orderCompanyJournal.getPayTime());
        addSysInviteGoldDetailReqDTO.setGoldPayType(1);
        if(baseinfoPersonRespDTO != null && baseinfoPersonRespDTO.getCurCompId() > 0L){
            addSysInviteGoldDetailReqDTO.setInviteCompId(baseinfoPersonRespDTO.getCurCompId());
        }
        addSysInviteGoldDetailReqDTO.setInvitePersonId(orderCompanyJournal.getInvitePersonId());
        addSysInviteGoldDetailReqDTO.setInvitePersonMobile(orderCompanyJournal.getInvitePersonMobile());
        addSysInviteGoldDetailReqDTO.setIsGoldSend(0);
        addSysInviteGoldDetailReqDTO.setIsMessageSend(1);
        addSysInviteGoldDetailReqDTO.setPayTime(orderCompanyJournal.getPayTime());
        addSysInviteGoldDetailReqDTO.setRegisterCompId(orderCompanyJournal.getCompId());
        addSysInviteGoldDetailReqDTO.setRegisterPersonId(orderCompanyJournal.getRegisterPersonId());
        addSysInviteGoldDetailReqDTO.setRegisterPersonMobile(orderCompanyJournal.getRegisterPersonMobile());
        addSysInviteGoldDetailReqDTO.setRegisterTime(orderCompanyJournal.getRegisterTime());
        sysCenterInsideRpcWriteServiceClient.addGoldDetail(addSysInviteGoldDetailReqDTO);
    }

    public CancelOrderCompanyJournalBO getCancelOrderCompanyJournalBO(PassOrFailReviewOrderCompanyJournalReqDTO passReviewOrderCompanyJournalReqDTO){
        CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO = new CancelOrderCompanyJournalBO();
        cancelOrderCompanyJournalBO.setOrderId(passReviewOrderCompanyJournalReqDTO.getOrderId());
        cancelOrderCompanyJournalBO.setUpdatedPersonId(passReviewOrderCompanyJournalReqDTO.getLoginPersonId());
        cancelOrderCompanyJournalBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        cancelOrderCompanyJournalBO.setVersion(passReviewOrderCompanyJournalReqDTO.getVersion());
        return cancelOrderCompanyJournalBO;
    }

    void insertPayJournal(OrderCompanyJournal orderCompanyJournal,CompanyStoreModel storeInfo){
        AddPayJournalReqDTO orderCompanyJournalReqDTO = new AddPayJournalReqDTO();
        orderCompanyJournalReqDTO.setLoginPersonId(orderCompanyJournal.getCreatedPersonId());
        orderCompanyJournalReqDTO.setFundStatus(1);//资金状态 1-支付，2-收入
        orderCompanyJournalReqDTO.setOperateType(201);//操作类型 201-购买服务
        orderCompanyJournalReqDTO.setOperatorCompId(orderCompanyJournal.getCompId());
        orderCompanyJournalReqDTO.setOperatorId(orderCompanyJournal.getRegisterPersonId());
        orderCompanyJournalReqDTO.setOperatorName(orderCompanyJournal.getRegisterPersonMobile());
        orderCompanyJournalReqDTO.setOrderId(orderCompanyJournal.getOrderId());
        orderCompanyJournalReqDTO.setOrderNo(orderCompanyJournal.getOrderNo());
        orderCompanyJournalReqDTO.setOrderType(201);//操作类型 201-购买服务
        orderCompanyJournalReqDTO.setPayAmount(orderCompanyJournal.getPayMoney());
        orderCompanyJournalReqDTO.setPayJournalNo(orderCompanyJournal.getOrderNo());
        orderCompanyJournalReqDTO.setPayTime(orderCompanyJournal.getPayTime());
        orderCompanyJournalReqDTO.setPayType(-1);
        orderCompanyJournalReqDTO.setPayTypes(PayPlatformCodeEnum.getTradeCode(orderCompanyJournal.getPayType()+""));
        orderCompanyJournalReqDTO.setTitle("购买服务");
        orderCompanyJournalReqDTO.setStoreId(storeInfo.getStoreId());
        orderCompanyJournalReqDTO.setStoreName(storeInfo.getDO().getStoreName());
        List<Integer> compIds = new ArrayList<>();
        compIds.add(Integer.parseInt(orderCompanyJournal.getCompId()+""));
        Map<String,CompanyModel> map = companyInfoService.getCompNameById(compIds);
        CompanyModel companyModel = map.get(orderCompanyJournal.getCompId()+"");
        if(companyModel != null){
            orderCompanyJournalReqDTO.setOperatorCompName(companyModel.getDO().getCompShortName());
        }
        payJournalWriteOutService.addPayJourna(orderCompanyJournalReqDTO);
    }


}
