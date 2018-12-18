package com.ihappy.role.interfaces.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoDelReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuUptateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoDelRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuUptateRespDTO;
import com.ihappy.role.infrastructure.service.SysFuncWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
@Deprecated
public class SysFuncWriteServiceImpl implements SysFuncWriteService {
    @Autowired
    private IProcess delSysFuncMenuBackstageMenuProcess;
    @Autowired
    private IProcess addSysFuncMenuBackstageMenuProcess;
    @Autowired
    private IProcess updateSysFuncMenuBackstageMenuInfoProcess;
    @Override
    public Result<SysFuncMenuBackstageMenuInfoDelRespDTO> delSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO) {
        Context context=new Context(sysFuncMenuBackstageMenuInfoDelReqDTO,new Result<SysFuncMenuBackstageMenuInfoDelRespDTO>(),Action.DELETE_MENU);
        delSysFuncMenuBackstageMenuProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysFuncMenuBackstageMenuAddRespDTO> addSysFuncMenuBackstageMenu(SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO) {
        Context context=new Context(sysFuncMenuBackstageMenuAddReqDTO,new Result<SysFuncMenuBackstageMenuAddRespDTO>(),Action.ADD_MENU);
        addSysFuncMenuBackstageMenuProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysFuncMenuBackstageMenuUptateRespDTO> updateSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO) {
       Context context=new Context(sysFuncMenuBackstageMenuUptateReqDTO,new Result<SysFuncMenuBackstageMenuUptateRespDTO>(),Action.UPDATE_MENU);
        updateSysFuncMenuBackstageMenuInfoProcess.start(context);
        return context.getResult();
    }
}
