package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.store.domain.dto.request.store.StorePrintIpAndPortUpdateReqDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/16.
 */
public class UpdatePrintIpAndPortProcess extends DefaultProcess<StorePrintIpAndPortUpdateReqDTO, String> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StorePrintIpAndPortUpdateReqDTO, String> context) {
        StorePrintIpAndPortUpdateReqDTO reqDTO = context.getParam();
        CompanyStoreModel model = CompanyStoreFactory.storePrintIpAndPortUpdateReqDTOToModel(reqDTO);
        Integer updateNum = companyStoreService.updatePrintIpAndPort(model);
        if (updateNum < 0){
            throw new CompanyException(StoreErrorCodeEnum.
                    UPDATE_PRINT_IP_AND_PORT.getErrCode(),
                    StoreErrorCodeEnum.UPDATE_PRINT_IP_AND_PORT.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
