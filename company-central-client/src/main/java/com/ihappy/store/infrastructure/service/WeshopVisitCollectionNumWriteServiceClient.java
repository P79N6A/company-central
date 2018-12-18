package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-06 16:14
 */
@Deprecated
public class WeshopVisitCollectionNumWriteServiceClient implements WeshopVisitCollectionNumWriteService {

    private WeshopVisitCollectionNumWriteService weshopVisitCollectionNumWriteService;

    public WeshopVisitCollectionNumWriteService getWeshopVisitCollectionNumWriteService() {
        return weshopVisitCollectionNumWriteService;
    }

    public void setWeshopVisitCollectionNumWriteService(WeshopVisitCollectionNumWriteService weshopVisitCollectionNumWriteService) {
        this.weshopVisitCollectionNumWriteService = weshopVisitCollectionNumWriteService;
    }

    @Override
    public Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO) {
        weshopVisitCountAddReqDTO.validation();
        return weshopVisitCollectionNumWriteService.addWeshopVisitCount(weshopVisitCountAddReqDTO);
    }
}
