package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.domain.bo.SysCompanyTypeBO;
import com.ihappy.company.domain.dbdo.SysCompanyType;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysCompanyTypeMapper;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by liuhc on 2018/5/16.
 */
public class SysCompanyTypeServiceImpl implements SysCompanyTypeService {

    @Autowired
    private SysCompanyTypeMapper sysCompanyTypeMapper;

    @Override
    public List<SysCompanyTypeModel> selectByCompanyTypeList() {

        List<SysCompanyType> result = sysCompanyTypeMapper.selectByCompanyTypeList();

        if (CollectionUtil.isEmpty(result)) {
            return null;
        }
        return transform(result, (sysCompanyType) -> new SysCompanyTypeModel(sysCompanyType));
    }

    @Override
    public List<SysCompanyTypeModel> selectSysCompanyTypeList(SysCompanyTypeBO sysCompanyTypeBO) {
        List<SysCompanyType> sysCompanyTypesList= sysCompanyTypeMapper.selectSysCompanyTypeList(sysCompanyTypeBO);
        List<SysCompanyTypeModel> list = new ArrayList<>();
        if(CollectionUtils.isEmpty(sysCompanyTypesList)){
            return list;
        }
        for (SysCompanyType sysCompanyType : sysCompanyTypesList) {
            list.add(new SysCompanyTypeModel(sysCompanyType));
        }
        return list;
    }

    @Override
    public SysCompanyTypeModel selectOneSysCompanyTypeByCtId(SysCompanyTypeBO sysCompanyTypeBO) {
        SysCompanyType sysCompanyType=sysCompanyTypeMapper.selectOneSysCompanyTypeByCtId(sysCompanyTypeBO);
        if (sysCompanyType == null){
            return null;
        }
        return new SysCompanyTypeModel(sysCompanyType);
    }
}
