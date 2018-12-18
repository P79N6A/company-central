package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public class SysFuncReadServiceClient implements SysFuncReadService {
    private SysFuncReadService sysFuncReadService;

    @Override
    public Result<List<SysFuncMenuBackstageMenuListQueryRespDTO>> findSysFuncMenuBackstageMenuList(SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO) {
        sysFuncMenuBackstageMenuListQueryReqDTO.validation();
        return sysFuncReadService.findSysFuncMenuBackstageMenuList(sysFuncMenuBackstageMenuListQueryReqDTO);
    }

    @Override
    public Result<SysFuncMenuBackstageMenuInfoQueryRespDTO> findSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO) {
        sysFuncMenuBackstageMenuInfoQueryReqDTO.validation();
        return sysFuncReadService.findSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuInfoQueryReqDTO);
    }
}
