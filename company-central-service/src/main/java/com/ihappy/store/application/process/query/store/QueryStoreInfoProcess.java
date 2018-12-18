package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.CompanyReadService;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dto.request.store.CompanyStroreInfoQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStroreInfoQueryRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/11 15:29
 * @Version
 */
public class QueryStoreInfoProcess<R extends CompanyStroreInfoQueryReqDTO> extends DefaultQueryProcess<R, CompanyStroreInfoQueryRespDTO> {
    @Autowired
    protected CompanyStoreService companyStoreService;
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Override
    public void process(Context<R, CompanyStroreInfoQueryRespDTO> context) {
        R companyStroreInfoQueryReqDTO = context.getParam();
        CompanyStoreModel storeInfo = queryStoreInfo(companyStroreInfoQueryReqDTO);

        CompanyStroreInfoQueryRespDTO result=CompanyStoreFactory.modelToCompanyStroreInfoQueryRespDTO(storeInfo);
        //查询公司详情
        BaseinfoCompany baseinfoCompany =
                baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.reqToBaseinfoCompany(companyStroreInfoQueryReqDTO));
        if (baseinfoCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        result.setLogoUrl(baseinfoCompany.getCompanyHead());
        context.getResult().setModule(result);
    }

    protected CompanyStoreModel queryStoreInfo(R companyStroreInfoQueryReqDTO) {
        //查询门店详情
        CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(CompanyStoreFactory.companyStroreInfoQueryReqDTOToModel(companyStroreInfoQueryReqDTO));
        //如果门店为空，则不存在
        if (storeInfo == null) {
            throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
        }
        return storeInfo;
    }
}
