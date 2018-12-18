package com.ihappy.communal.infrastructure.service.outside;

import com.ihappy.item.domain.dto.request.DefaultInfoGrantReqDTO;

/**
 * 调用远程rpc复制角色组
 * Created by sunjd on 2018/4/9.
 */
public interface CompanyBaseInfoGrantService {
    Boolean defaultInfoGrant(DefaultInfoGrantReqDTO defaultInfoGrantReqDTO);
}
