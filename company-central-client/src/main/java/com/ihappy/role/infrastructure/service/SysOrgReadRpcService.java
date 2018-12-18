package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.org.SysOrgBasicInfoByIdQueryRpcReqDTO;
import com.ihappy.role.domain.dto.request.org.SysOrgBasicInfoByOrgIdListQuery;
import com.ihappy.role.domain.dto.response.org.SysOrgBasicInfoByIdQueryRpcRespDTO;
import com.ihappy.role.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
@Deprecated
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
