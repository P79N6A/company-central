package com.ihappy.store.application.process.write.ordercompanyjournal;

import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.service.outside.user.SysPerosnInfoOutSideService;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.CancelOrderCompanyJournalBO;
import com.ihappy.company.domain.bo.OrderCompanyJournalByIdBO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.CancelOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.CancelOrderCompanyJournalRespDTO;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.user.domain.dto.response.sys.SysPersonRespDTO;
import com.ihappy.user.domain.query.sys.SysUserBasicInfoByPersonIdQuery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuhc on 2018/6/30.
 */
public class CancelOrderCompanyJournalProcess extends DefaultProcess<CancelOrderCompanyJournalReqDTO, CancelOrderCompanyJournalRespDTO> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private SysPerosnInfoOutSideService sysPerosnInfoOutSideService;

    @Override
    public void process(Context<CancelOrderCompanyJournalReqDTO, CancelOrderCompanyJournalRespDTO> context) {

        CancelOrderCompanyJournalReqDTO cancelOrderCompanyJournalReqDTO = context.getParam();

        OrderCompanyJournalByIdBO orderCompanyJournalByIdBO = new OrderCompanyJournalByIdBO();
        orderCompanyJournalByIdBO.setOrderId(cancelOrderCompanyJournalReqDTO.getOrderId());

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

        //查用户名称
        SysUserBasicInfoByPersonIdQuery sysUserBasicInfoByPersonIdQuery = new SysUserBasicInfoByPersonIdQuery();
        sysUserBasicInfoByPersonIdQuery.setDeletedFlag(0);
        sysUserBasicInfoByPersonIdQuery.setCompId(cancelOrderCompanyJournalReqDTO.getLoginCompId());
        sysUserBasicInfoByPersonIdQuery.setPersonId(cancelOrderCompanyJournalReqDTO.getLoginPersonId());
        SysPersonRespDTO sysPersonRespDTO = sysPerosnInfoOutSideService.querySysPerson(sysUserBasicInfoByPersonIdQuery,true);

        CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO = OrderCompanyJournalFactory.toCancelOrderCompanyJournalBO(cancelOrderCompanyJournalReqDTO);
        cancelOrderCompanyJournalBO.setVersion(orderCompanyJournalModel.getVersion());
        cancelOrderCompanyJournalBO.setIsCancel(1);
        if (sysPersonRespDTO != null){
            cancelOrderCompanyJournalBO.setAuditorName(sysPersonRespDTO.getPersonName());
            if (StringUtil.isBlank(cancelOrderCompanyJournalBO.getAuditorName())){
                cancelOrderCompanyJournalBO.setAuditorName(sysPersonRespDTO.getMobile());
            }
        }
        int row = orderCompanyJournalService.cancelOrderCompanyJournalById(cancelOrderCompanyJournalBO);
        if (row == 0) {//操作失败
            throw new CompanyException(CompanyErrorCodeEnum.OPERATE_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.OPERATE_ERROR.getErrMsg());
        }
        CancelOrderCompanyJournalRespDTO cancelOrderCompanyJournalRespDTO = new CancelOrderCompanyJournalRespDTO();
        cancelOrderCompanyJournalRespDTO.setMessage("操作成功");
        context.getResult().setModule(cancelOrderCompanyJournalRespDTO);
    }


}
