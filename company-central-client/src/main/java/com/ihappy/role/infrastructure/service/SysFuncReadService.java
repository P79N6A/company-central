package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public interface SysFuncReadService {
    /**
     * 运营后台-平台设定-功能菜单-后台-系统公司功能菜单列表
     * @param sysFuncMenuBackstageMenuListQueryReqDTO
     * @return
     */
    Result<List<SysFuncMenuBackstageMenuListQueryRespDTO>> findSysFuncMenuBackstageMenuList(SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单详情
     * @param sysFuncMenuBackstageMenuInfoQueryReqDTO
     * @return
     */
    Result<SysFuncMenuBackstageMenuInfoQueryRespDTO> findSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO);
}
