package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoDelReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuUptateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoDelRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuUptateRespDTO;
import com.ihappy.unifiedLog.module.Result;
@Deprecated
public interface SysFuncWriteService {
    /**
     * 运营后台-平台设定-功能菜单-后台-删除菜单
     * @param sysFuncMenuBackstageMenuInfoDelReqDTO
     * @return
     */
    Result<SysFuncMenuBackstageMenuInfoDelRespDTO> delSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO);

    /**
     *  运营后台-平台设定-功能菜单-后台-添加菜单
     * @param sysFuncMenuBackstageMenuAddReqDTO
     * @return
     */
    Result<SysFuncMenuBackstageMenuAddRespDTO> addSysFuncMenuBackstageMenu(SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO);

    /**
     * 运营后台-平台设定-功能菜单-后台-修改菜单
     * @param sysFuncMenuBackstageMenuUptateReqDTO
     * @return
     */
    Result<SysFuncMenuBackstageMenuUptateRespDTO> updateSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO);
}
