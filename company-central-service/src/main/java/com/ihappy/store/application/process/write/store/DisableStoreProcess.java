package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.CompanyReadService;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.dto.request.store.DisableStoreReqDTO;
import com.ihappy.store.domain.dto.response.store.DisableStoreRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/16 13:15
 * *@content禁用门店
 **/
public class DisableStoreProcess extends DefaultProcess<DisableStoreReqDTO, DisableStoreRespDTO> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private CompanyReadService companyReadService;

    @Override
    public void process(Context<DisableStoreReqDTO, DisableStoreRespDTO> context) {
        DisableStoreReqDTO disableStoreReqDTO = context.getParam();
        //根据公司id和门店id查询门店信息
        CompanyStoreModel companyStoreModel = companyStoreService.findByStoreIdAndCompId(CompanyStoreFactory.reqToCompanyStoreModel(disableStoreReqDTO));
        //判断门店是否存在或已被删除
        if (companyStoreModel == null) {
            throw new CompanyException(CompanyErrorCodeEnum.STORE_IS_NOT_EXIT_OR_DELETED);
        }
        //将门店禁用
        StoreInfoBO storeInfoBO = CompanyStoreFactory.reqToStoreInfoBO(disableStoreReqDTO);
        DisableStoreRespDTO disableStoreRespDTO = new DisableStoreRespDTO();
        //如果是总店，则不能禁用
        if (companyStoreModel.getDO().getIsPublic() == 1) {
            throw new CompanyException(CompanyErrorCodeEnum.PUBLIC_STORE_IS_CAN_NOT_FORBIDDEN);
        }
        //默认门店不能禁用
        if (companyStoreModel.getDO().getIsDefault()==1){
            throw new CompanyException(CompanyErrorCodeEnum.DEFAULT_STORE_CAN_NOT_BE_DISABLED);
        }
        //如果门店是启用状态
        if (companyStoreModel.getDO().getForbidden() == 0) {
            storeInfoBO.setForbidden(1);
        } else {
            throw new CompanyException(CompanyErrorCodeEnum.THIS_SOTRE_IS_BE_BANNED);
        }
        int disableStore = companyStoreService.modifyStoreState(storeInfoBO);
        if (disableStore > 0) {
            disableStoreRespDTO.setMessage("禁用成功");
        }
        context.getResult().setModule(disableStoreRespDTO);
    }
}
