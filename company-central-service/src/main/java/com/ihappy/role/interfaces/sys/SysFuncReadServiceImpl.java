package com.ihappy.role.interfaces.sys;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;
import com.ihappy.role.infrastructure.service.SysFuncReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Deprecated
public class SysFuncReadServiceImpl implements SysFuncReadService {
    @Autowired
    private IProcess querySysFuncMenuBackstageMenuListProcess;
    @Autowired
    private IProcess querySysFuncMenuBackstageMenuInfoProcess;

    @Override
    public Result<List<SysFuncMenuBackstageMenuListQueryRespDTO>> findSysFuncMenuBackstageMenuList(SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO) {
        Context context = new Context(sysFuncMenuBackstageMenuListQueryReqDTO, new Result<Page<SysFuncMenuBackstageMenuListQueryRespDTO>>(), Action.QUERY_MENU_LIST);
        querySysFuncMenuBackstageMenuListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysFuncMenuBackstageMenuInfoQueryRespDTO> findSysFuncMenuBackstageMenuInfo(SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO) {
        Context context=new Context(sysFuncMenuBackstageMenuInfoQueryReqDTO,new Result<SysFuncMenuBackstageMenuInfoQueryRespDTO>(),Action.QUERY_MENU_INFO);
        querySysFuncMenuBackstageMenuInfoProcess.start(context);
        return context.getResult();
    }
}
