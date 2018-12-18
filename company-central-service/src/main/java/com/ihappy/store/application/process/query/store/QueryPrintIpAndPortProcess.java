package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dto.request.store.StoreQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StorePrintIpAndPortQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/16.
 */
public class QueryPrintIpAndPortProcess extends DefaultQueryProcess<StoreQueryReqDTO,StorePrintIpAndPortQueryRespDTO> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StoreQueryReqDTO, StorePrintIpAndPortQueryRespDTO> context) {
        StoreQueryReqDTO reqDTO = context.getParam();
        CompanyStoreModel model = CompanyStoreFactory.storeQueryReqDTOToModel(reqDTO);
        CompanyStoreModel resModel = companyStoreService.findByStoreIdAndCompId(model);
        if (resModel == null){
            throw new CompanyException(StoreErrorCodeEnum.
                    NO_STORE_FIND.getErrCode(),
                    StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
        }
        StorePrintIpAndPortQueryRespDTO respDTO = new StorePrintIpAndPortQueryRespDTO();
        respDTO.setPrintIp(resModel.getDO().getPrintIp());
        respDTO.setPrintPort(resModel.getDO().getPrintPort());
        respDTO.setStoreId(resModel.getDO().getStoreId());
        context.getResult().setModule(respDTO);
    }
}
