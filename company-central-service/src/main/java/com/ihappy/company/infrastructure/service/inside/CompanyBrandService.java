package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.model.model.CompanyBrandModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/3.
 */
public interface CompanyBrandService {
    public List<CompanyBrandModel> findCompanyBrandListByCompId(Integer compId);

    /**
     * 根据公司id和其他条件查询品牌列表
     * @param map
     * @return
     */
    public List<CompanyBrandModel> findCompanyBrandListByCompIdAndCondition(Map<String,Object> map);
}
