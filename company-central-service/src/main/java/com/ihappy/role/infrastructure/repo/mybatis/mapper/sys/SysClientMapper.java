package com.ihappy.role.infrastructure.repo.mybatis.mapper.sys;

import com.ihappy.role.domain.bo.SysClientBO;
import com.ihappy.role.domain.bo.SysClientInfoBO;
import com.ihappy.role.domain.dbdo.sys.SysClient;

import java.util.List;

public interface SysClientMapper {
    /**
     * 根据客户端ID查询客户端信息列表
     * @param sysClientBO
     * @return
     */
    List<SysClient> querySysClientList(SysClientBO sysClientBO);
    /**
     * 根据客户端ID查询客户端信息
     * @param sysClientInfoBO
     * @return
     */
    SysClient querySysClientByClId(SysClientInfoBO sysClientInfoBO);
}
