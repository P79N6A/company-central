package com.ihappy.communal.infrastructure.service.outside.user;

import com.ihappy.user.domain.dto.response.sys.SysPersonRespDTO;
import com.ihappy.user.domain.query.sys.SysUserBasicInfoByPersonIdQuery;


/**
 * Created by chenying on 2018/9/28.
 */
public interface SysPerosnInfoOutSideService {
    /**
     * 通过personId查询sys用户信息
     * @param reqDTO
     * @return
     */
    SysPersonRespDTO querySysPerson(SysUserBasicInfoByPersonIdQuery reqDTO, boolean throwException);
}
