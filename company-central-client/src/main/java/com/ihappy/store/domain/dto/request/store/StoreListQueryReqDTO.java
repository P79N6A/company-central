package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.exception.StoreException;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/12 13:34
 * @Version
 */
public class StoreListQueryReqDTO extends ICallRequestBaseQuery {
    @Override
    public void validation(){
        if (getLoginCompId() == null || getLoginCompId() <=0||getLoginPersonId()==null || getLoginPersonId() <= 0){
            throw new StoreException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
    }
}
