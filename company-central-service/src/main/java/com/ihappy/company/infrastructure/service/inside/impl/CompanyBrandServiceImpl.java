package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.company.domain.dbdo.BaseinfoCompanyBrand;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyBrandMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandServiceImpl implements CompanyBrandService {
    @Autowired
    private BaseinfoCompanyBrandMapper baseinfoCompanyBrandMapper;

    @Override
    public List<CompanyBrandModel> findCompanyBrandListByCompId(Integer compId) {
        List<BaseinfoCompanyBrand> baseinfoCompanyBrands = baseinfoCompanyBrandMapper.selectListByCompId(compId);
        if (CollectionUtils.isEmpty(baseinfoCompanyBrands)) {
            return new ArrayList<>();
        }
        return transform(baseinfoCompanyBrands, (baseinfoCompanyBrand) -> new CompanyBrandModel(baseinfoCompanyBrand));
    }

    @Override
    public List<CompanyBrandModel> findCompanyBrandListByCompIdAndCondition(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)){
            return new ArrayList<>();
        }
        List<BaseinfoCompanyBrand> baseinfoCompanyBrands = baseinfoCompanyBrandMapper.selectCompanyBrandListByCompIdAndCondition(map);
        if (CollectionUtils.isEmpty(baseinfoCompanyBrands)) {
            return new ArrayList<>();
        }
        return transform(baseinfoCompanyBrands, (baseinfoCompanyBrand) -> new CompanyBrandModel(baseinfoCompanyBrand));
    }
}
