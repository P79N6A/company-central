package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.role.domain.bo.SysClientBO;
import com.ihappy.role.domain.bo.SysClientInfoBO;

import java.util.List;

public interface SysClientService {
    /**
     * 查询系统客户端信息列表
     * @param sysClientBO
     * @return
     */
   List<SysClientModel> querySysClientList(SysClientBO sysClientBO);
    /**
     * 查询系统客户端信息
     * @param sysClientInfoBO
     * @return
     */
    SysClientModel  querySysClientByClId(SysClientInfoBO sysClientInfoBO);
}
