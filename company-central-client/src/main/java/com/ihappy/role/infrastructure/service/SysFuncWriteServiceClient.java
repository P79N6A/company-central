package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoDelReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuUptateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoDelRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuUptateRespDTO;
import com.ihappy.unifiedLog.module.Result;
@Deprecated
public class SysFuncWriteServiceClient implements SysFuncWriteService {
    private SysFuncWriteService sysFuncWriteService;

    @Override
    public Result<SysFuncMenuBackstageMenuInfoDelRespDTO> delSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO) {
        sysFuncMenuBackstageMenuInfoDelReqDTO.validation();
        return sysFuncWriteService.delSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuInfoDelReqDTO);
    }

    @Override
    public Result<SysFuncMenuBackstageMenuAddRespDTO> addSysFuncMenuBackstageMenu(SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO) {
        sysFuncMenuBackstageMenuAddReqDTO.validation();
        return sysFuncWriteService.addSysFuncMenuBackstageMenu(sysFuncMenuBackstageMenuAddReqDTO);
    }

    @Override
    public Result<SysFuncMenuBackstageMenuUptateRespDTO> updateSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO) {
        sysFuncMenuBackstageMenuUptateReqDTO.validation();
        return sysFuncWriteService.updateSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuUptateReqDTO);
    }
}
