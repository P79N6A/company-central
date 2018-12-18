package com.ihappy.company.application.process.write.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.CompanyExpireStatusBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyExtendServiceJournal;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusUpdateReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyExtendService;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.exception.StoreException;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.UUID;

/**
 * Created by liuhc on 2018/7/12.
 */
public class UpdateCompanyExpireStatusProcess extends DefaultProcess<CompanyExpireStatusUpdateReqDTO, Void> {

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private TransactionTemplate companyTransactionTemplate;
    @Autowired
    private CompanyExtendService companyExtendService;

    @Override
    public void process(Context<CompanyExpireStatusUpdateReqDTO, Void> context) {

        CompanyExpireStatusUpdateReqDTO companyExpireStatusUpdateReqDTO = context.getParam();

        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(companyExpireStatusUpdateReqDTO.getCompId());
        CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        if (companyModel == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_NOT_EXIT.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT.getErrMsg());
        }
        companyTransactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                if(companyExpireStatusUpdateReqDTO.getStoreId() != null){
                    CompanyStoreModel companyStoreModel = companyStoreService.findStoreById(companyExpireStatusUpdateReqDTO.getStoreId());
                    if (companyStoreModel == null){
                        throw new StoreException(StoreErrorCodeEnum.
                                NO_STORE_FIND.getErrCode(),
                                StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
                    }
                    Long expireDate = null;
                    if (companyExpireStatusUpdateReqDTO.getExperienceDate() != null && companyExpireStatusUpdateReqDTO.getExperienceDate() != 0L){
                        //获取服务到期时间
                        if (companyStoreModel.getDO().getExpireDate() != null && companyStoreModel.getDO().getExpireDate() != 0L
                                && DateUtil.compareDate(DateUtil.parseDateYMD(companyStoreModel.getDO().getExpireDate() + ""), new Date()) >= 0) {
                            expireDate = CompanyDateUtil.addDateToLong(companyStoreModel.getDO().getExpireDate(), companyExpireStatusUpdateReqDTO.getExperienceDate());
                        } else {
                            Date nowDate = new Date();
                            expireDate = CompanyDateUtil.addDateToLong(CompanyDateUtil.getDate14Long(nowDate), companyExpireStatusUpdateReqDTO.getExperienceDate());
                        }
                        BaseinfoCompanyExtendServiceJournal companyExtendServiceJournal = new BaseinfoCompanyExtendServiceJournal();
                        companyExtendServiceJournal.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
                        companyExtendServiceJournal.setOrderType("updateByBackend");
                        companyExtendServiceJournal.setSourceType(2);
                        companyExtendServiceJournal.setTime(companyExpireStatusUpdateReqDTO.getExperienceDate());
                        companyExtendServiceJournal.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                        companyExtendServiceJournal.setUpdatedPersonId(companyExpireStatusUpdateReqDTO.getLoginPersonId());
                        companyExtendServiceJournal.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
                        companyExtendServiceJournal.setCreatedPersonId(companyExpireStatusUpdateReqDTO.getLoginPersonId());
                        companyExtendServiceJournal.setCompId(companyExpireStatusUpdateReqDTO.getCompId());
                        companyExtendServiceJournal.setStoreId(companyExpireStatusUpdateReqDTO.getStoreId());
                        Long journalId  = companyExtendService.addCompanyExtendServiceJournal(new CompanyExtendServiceJournalModel(companyExtendServiceJournal));
                        if(journalId == null || journalId <= 0L){
                            throw new CompanyException(CompanyErrorCodeEnum.ORDER_COMPANY_JOURNAL_OPERATE_ERROR);
                        }
                    }
                }

                CompanyExpireStatusBO companyExpireStatusBO = new CompanyExpireStatusBO();
                companyExpireStatusBO.setCompId(companyExpireStatusUpdateReqDTO.getCompId());
                companyExpireStatusBO.setMemo(companyExpireStatusUpdateReqDTO.getMemo());
                companyExpireStatusBO.setStatus(companyExpireStatusUpdateReqDTO.getStatus());
                companyExpireStatusBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                companyExpireStatusBO.setUpdatedPersonId(companyExpireStatusUpdateReqDTO.getLoginPersonId());

                companyInfoService.updateCompanyExpireStatus(companyExpireStatusBO);
                return null;
            }
        });
    }
}
