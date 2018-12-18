package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.domain.model.factory.CommonParamFactory;
import com.ihappy.company.domain.model.model.CommonParamModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.CommonParamMapper;
import com.ihappy.company.infrastructure.service.inside.CommParamService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CommParamServiceImpl implements CommParamService {
    @Autowired
    private CommonParamMapper commonParamMapper;

    @Override
    public Long getValueByName(String name) {
        if(StringUtil.isBlank(name)){
            return 0L;
        }
        Long value = commonParamMapper.getValueByName(name);
        if(value == null){
            CommonParamModel commonParamModel = CommonParamFactory.buildDefaultModel(name);
            commonParamMapper.insertSelective(commonParamModel.getDO());
            return 0L;
        }
        return value;
    }
}
