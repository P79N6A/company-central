package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.domain.dbdo.sys.SysParam;
import com.ihappy.company.domain.model.model.SysParamModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysParamMapper;
import com.ihappy.company.infrastructure.service.inside.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/12/4.
 */
public class SysParamServiceImpl implements SysParamService {
    @Autowired
    private SysParamMapper sysParamMapper;
    @Override
    public SysParamModel selectByKey(String key) {
        if (StringUtil.isBlank(key)){
            return null;
        }
        SysParam sysParam = sysParamMapper.selectByKey(key);
        if (sysParam == null){
            return null;
        }
        return new SysParamModel(sysParam);
    }

    @Override
    public String selectValueByKey(String key) {
        SysParamModel model = selectByKey(key);
        if (model == null){
            return null;
        }
        return model.getDO().getParamValue();
    }
}
