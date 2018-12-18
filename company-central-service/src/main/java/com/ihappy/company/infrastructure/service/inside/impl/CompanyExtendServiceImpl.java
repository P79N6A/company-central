package com.ihappy.company.infrastructure.service.inside.impl;


import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyExtendServiceJournalMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyExtendService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.store.UpdateStoreExpireDateBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.exception.StoreException;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import com.yx.eweb.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * Created by sunjd on 2018/6/28.
 */
public class CompanyExtendServiceImpl implements CompanyExtendService {
    private final static Logger logger = CompanyLoggerUtil.getLogger();
    @Autowired
    private TransactionTemplate companyTransactionTemplate;
    @Autowired
    private BaseinfoCompanyExtendServiceJournalMapper baseinfoCompanyExtendServiceJournalMapper;
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private BaseinfoCompanyStoreMapper baseinfoCompanyStoreMapper;

    @Override
    public Long addCompanyExtendServiceJournal(CompanyExtendServiceJournalModel model) {
        if (model == null || model.getDO() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        if (model.getDO().getCompId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (model.getDO().getStoreId() == null){
            throw new StoreException(StoreErrorCodeEnum.NO_STORE_FIND);
        }
        if (model.getDO().getTime() == null && model.getDO().getTime() != 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    TIME_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.TIME_IS_NULL.getErrMsg());
        }
        if (model.getDO().getTime() == 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    TIME_IS_ZERO.getErrCode(),
                    CompanyErrorCodeEnum.TIME_IS_ZERO.getErrMsg());
        }
        if (model.getDO().getUpdatedAt() == null){
            model.getDO().setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        }
        if (model.getDO().getCreatedAt() == null){
            model.getDO().setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        }
        if (StringUtil.isBlank(model.getDO().getOrderNo())){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_EXTEND_SERVICE_ORDER_NO_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_EXTEND_SERVICE_ORDER_NO_IS_EMPTY.getErrMsg());
        }
        if (StringUtil.isBlank(model.getDO().getOrderType())){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_EXTEND_SERVICE_ORDER_TYPE_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_EXTEND_SERVICE_ORDER_TYPE_IS_EMPTY.getErrMsg());
        }
        //BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(model.getDO().getCompId());
        BaseinfoCompanyStore store = baseinfoCompanyStoreMapper.selectByPrimaryKey(model.getDO().getStoreId());
        if (store == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }

        Long curExpireDate = store.getExpireDate();
        if (curExpireDate == null || curExpireDate == 0){
            curExpireDate = CompanyDateUtil.getDate14Long(new Date());
        }
        //例如：用户15年10月到期了，他18年想玩我们系统了，那么取当前时间往后延续
        if(DateUtil.differentDays(DateUtil.parseDateYMD(curExpireDate+""),new Date()) >= 0) {
            curExpireDate = CompanyDateUtil.getTodayStartDate14Long();
        }
        //计算延期后的时间
        Long expireDate = CompanyDateUtil.addDateToLong(curExpireDate,model.getDO().getTime());

        Integer res = null;
        try{
            res = baseinfoCompanyExtendServiceJournalMapper.insertSelective(model.getDO());
        }catch (RuntimeException e){
            logger.error(e.getMessage(),e);
        }
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ADD_COMPANY_EXTEND_JOURNAL_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.ADD_COMPANY_EXTEND_JOURNAL_ERROR.getErrMsg());
        }
        UpdateStoreExpireDateBO updateStoreExpireDateBO = new UpdateStoreExpireDateBO();
        updateStoreExpireDateBO.setCompId(model.getDO().getCompId());
        updateStoreExpireDateBO.setExpireDate(expireDate);
        updateStoreExpireDateBO.setUpdatedAt(model.getDO().getUpdatedAt());
        updateStoreExpireDateBO.setUpdatedPersonId(model.getDO().getUpdatedPersonId());
        updateStoreExpireDateBO.setVersion(store.getVersion());
        updateStoreExpireDateBO.setExpireStatus(1);
        updateStoreExpireDateBO.setStoreId(store.getStoreId());
        Integer res1 = baseinfoCompanyStoreMapper.updateStoreExpireDate(updateStoreExpireDateBO);
        if(res1 == 0){
            throw new StoreException(StoreErrorCodeEnum.
                    UPDATE_STORE_EXPIRE_DATE_ERROR.getErrCode(),
                    StoreErrorCodeEnum.UPDATE_STORE_EXPIRE_DATE_ERROR.getErrMsg());
        }
        return model.getDO().getJournalId();
    }

    @Override
    public Long addCompanyExtendServiceJournalWithTransaction(CompanyExtendServiceJournalModel model) {

        companyTransactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                addCompanyExtendServiceJournal(model);
                return null;
            }
        });
        return model.getDO().getJournalId();
    }
}
