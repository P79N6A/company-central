package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByIdQueryRpcReqDTO;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByOrgIdListQuery;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoByIdQueryRpcRespDTO;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
@Deprecated
@Transfer(value = "com.ihappy.role.infrastructure.service.SysOrgReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface SysOrgReadRpcService {

    /**
     * 查询部门信息
     * @param sysOrgBasicInfoByOrgIdListQuery
     * @return
     */
    Result<List<SysOrgBasicInfoRespDTO>>  getSysOrgBasicInfo(SysOrgBasicInfoByOrgIdListQuery sysOrgBasicInfoByOrgIdListQuery);

    /**
     * 查询所有子节点组织
     * @param reqDTO
     * @return
     */
    Result<SysOrgBasicInfoByIdQueryRpcRespDTO> getAllChildSysOrgById(SysOrgBasicInfoByIdQueryRpcReqDTO reqDTO);
}
