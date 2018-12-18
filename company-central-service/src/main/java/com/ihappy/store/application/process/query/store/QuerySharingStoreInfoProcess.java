package com.ihappy.store.application.process.query.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.constans.StoreConstants;
import com.ihappy.store.domain.dto.request.store.CompanyStroreInfoQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.SharingCompanyStoreInfoQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStroreInfoQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/11 15:29
 * @Version
 */
public class QuerySharingStoreInfoProcess extends QueryStoreInfoProcess<SharingCompanyStoreInfoQueryReqDTO> {
    @Override
    public void process(Context<SharingCompanyStoreInfoQueryReqDTO, CompanyStroreInfoQueryRespDTO> context) {
        context.getParam().setLoginCompId(context.getParam().getCompId());
        super.process(context);
    }

    @Override
    protected CompanyStoreModel queryStoreInfo(SharingCompanyStoreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        if (companyStroreInfoQueryReqDTO.getStoreId() == null || companyStroreInfoQueryReqDTO.getStoreId() < 0L) {
            Map<String, Object> publicStoreQueryParam = new HashMap<>();
            publicStoreQueryParam.put("compId", companyStroreInfoQueryReqDTO.getCompId());
            publicStoreQueryParam.put("isPublic", 1);
            List<CompanyStoreModel> publicStoreList = companyStoreService.findStoreListByCompIdAndStoreIds(publicStoreQueryParam);
            //如果门店为空，则不存在
            if (CollectionUtil.isEmpty(publicStoreList)) {
                throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
            }
            // 没传storeId, 门店名称取全部门店, 信息还是取总店的信息
            CompanyStoreModel publicStore = publicStoreList.get(0);
            publicStore.getDO().setStoreName(StoreConstants.ALL_STORE_NAME);
            return publicStore;
        }
        return super.queryStoreInfo(companyStroreInfoQueryReqDTO);
    }
}
