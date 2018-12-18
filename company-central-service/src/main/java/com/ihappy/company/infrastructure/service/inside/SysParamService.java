package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.model.model.SysParamModel;

/**
 * Created by sunjd on 2018/12/4.
 */
public interface SysParamService {
    SysParamModel selectByKey(String key);

    String selectValueByKey(String key);
}
