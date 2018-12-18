package com.ihappy.company.infrastructure.service;

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
public class SysOrgReadRpcServiceClient implements SysOrgReadRpcService {

    private SysOrgReadRpcService sysOrgReadRpcService;

    public void setSysOrgReadRpcService(SysOrgReadRpcService sysOrgReadRpcService) {
        this.sysOrgReadRpcService = sysOrgReadRpcService;
    }

    @Override
    public Result<List<SysOrgBasicInfoRespDTO>> getSysOrgBasicInfo(SysOrgBasicInfoByOrgIdListQuery sysOrgBasicInfoByOrgIdListQuery) {
        return sysOrgReadRpcService.getSysOrgBasicInfo(sysOrgBasicInfoByOrgIdListQuery);
    }

    @Override
    public Result<SysOrgBasicInfoByIdQueryRpcRespDTO> getAllChildSysOrgById(SysOrgBasicInfoByIdQueryRpcReqDTO reqDTO) {
        reqDTO.validation();
        return sysOrgReadRpcService.getAllChildSysOrgById(reqDTO);
    }
}
