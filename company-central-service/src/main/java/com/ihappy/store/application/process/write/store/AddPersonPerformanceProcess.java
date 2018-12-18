package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.dto.request.store.AddPersonPerformanceReqDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/8/30.
 */
public class AddPersonPerformanceProcess extends DefaultProcess<AddPersonPerformanceReqDTO, String> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Override
    public void process(Context<AddPersonPerformanceReqDTO, String> context) {
        AddPersonPerformanceReqDTO reqDTO = context.getParam();
        SalePerformanceBO record = getRecord(reqDTO);
        int row = companyStoreService.insertOrUpdateSalePerformance(record);
        if (row >= 0){
            context.getResult().setModule(record.getSalePerformanceId().toString());
            context.getResult().setErrMsg("设置成功");
        }else {
            throw new CompanyException(StoreErrorCodeEnum.
                    SET_PERFORMANCE_ERROR.getErrCode(),
                    StoreErrorCodeEnum.SET_PERFORMANCE_ERROR.getErrMsg());
        }
    }

    private SalePerformanceBO getRecord(AddPersonPerformanceReqDTO reqDTO){
        SalePerformanceBO record = new SalePerformanceBO();
        record.setSalePerformanceId(reqDTO.getSalePerformanceId());
        record.setCompId(reqDTO.getLoginCompId());
        record.setStoreId(reqDTO.getStoreId());
        CompanyStoreModel storeModel = companyStoreService.findStoreById(reqDTO.getStoreId());
        if (storeModel != null && storeModel.getDO() != null){
            record.setStoreName(storeModel.getDO().getStoreName());
        }
        record.setPersonId(reqDTO.getPersonId());
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getLoginCompId(),reqDTO.getPersonId(), ConfigCenterUtil.ENV);
        if (orgRespDTO != null){
            record.setPersonName(orgRespDTO.getPersonName());
            record.setAvatar(orgRespDTO.getAvatar());
        }
        record.setAimAmount(reqDTO.getAimAmount());
        record.setYearMonth(reqDTO.generateIntYearMonth());
        record.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        record.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        record.setCreatedPersonId(reqDTO.getLoginPersonId());
        record.setUpdatedPersonId(reqDTO.getLoginPersonId());
        if (record.getSalePerformanceId() == null || record.getSalePerformanceId().equals(0L)){
            record.setSalePerformanceId(DistributedPrimaryKeyFactory.generateSalePerformanceId(record.getCompId()));
        }
        return record;
    }
}
