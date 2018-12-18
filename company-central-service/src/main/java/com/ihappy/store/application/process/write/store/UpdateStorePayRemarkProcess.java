package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.StoreInfoUpdateReqDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.exception.StoreException;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/10/19.
 */
public class UpdateStorePayRemarkProcess extends DefaultProcess<StoreInfoUpdateReqDTO, String> {
    @Autowired
    private BaseinfoCompanyStoreMapper baseinfoCompanyStoreMapper;
    @Override
    public void process(Context<StoreInfoUpdateReqDTO, String> context) {
        StoreInfoUpdateReqDTO reqDTO = context.getParam();
        BaseinfoCompanyStore param = CompanyStoreFactory.toPayRemark(reqDTO);
        Integer res = baseinfoCompanyStoreMapper.updateByPrimaryKeySelective(param);
        if(res < 0){
            throw new StoreException(StoreErrorCodeEnum.
                    UPDATE_STORE_INFO_ERROR.getErrCode(),
                    StoreErrorCodeEnum.UPDATE_STORE_INFO_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
