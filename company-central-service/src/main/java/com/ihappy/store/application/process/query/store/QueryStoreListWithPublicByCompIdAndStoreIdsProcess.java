package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.IsDeletedEnum;
import com.ihappy.company.common.enumtype.IsPublicEnum;
import com.ihappy.store.domain.bo.store.QueryStoreListByCompIdAndStoreIdsBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/7/26.
 */
public class QueryStoreListWithPublicByCompIdAndStoreIdsProcess extends DefaultQueryProcess<CompanyStoreListQueryReqDTO,List<CompanyStoreListQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<CompanyStoreListQueryReqDTO, List<CompanyStoreListQueryRespDTO>> context) {
        CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO = context.getParam();
        List<CompanyStoreModel> companyStoreModels = companyStoreService.findValidStoreListByCompIdAndStoreIds(CompanyStoreFactory.companyStoreListQueryReqDTOToQueryStoreListByCompIdAndStoreIdsBO(companyStoreListQueryReqDTO));
        BaseinfoCompanyStore param = new BaseinfoCompanyStore();
        param.setCompId(companyStoreListQueryReqDTO.getCompId());
        param.setIsPublic(IsPublicEnum.PUBLIC.getKey());
        param.setIsDeleted(IsDeletedEnum.NOT_DELETED.getKey());
        companyStoreModels.addAll(companyStoreService.selectStoreByCondition(param));
        List<CompanyStoreListQueryRespDTO> sysCompanyRoleQueryRespDTOs = CompanyStoreFactory.modelListToRespDTOList(companyStoreModels);
        context.getResult().setModule(sysCompanyRoleQueryRespDTOs);
    }
}
