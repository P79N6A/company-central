package com.ihappy.store.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.store.infrastructure.service.WeshopVisitCollectionNumWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-06 17:05
 */
@Deprecated
public class WeshopVisitCollectionNumWriteServiceImpl implements WeshopVisitCollectionNumWriteService {

    @Autowired
    private IProcess addWeshopVisitProcess;

    @Override
    public Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO) {
        Context<WeshopVisitCountAddReqDTO, String> context = new Context<WeshopVisitCountAddReqDTO, String>(weshopVisitCountAddReqDTO,
                new Result<String>(), Action.ADD_WESHOP_VISIT);
        addWeshopVisitProcess.start(context);
        return context.getResult();
    }
}
