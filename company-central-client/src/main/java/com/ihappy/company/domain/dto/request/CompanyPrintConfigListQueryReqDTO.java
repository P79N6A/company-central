package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 13:52
 */
public class CompanyPrintConfigListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 1646781500930839650L;
    @FieldComment(value = "公司id",required = true,defaultValue = "")
    private Long compId;  // 公司id
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;  // 门店id

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if(compId == null || compId.equals(0L)){
            throw new CompanyException(CompanyErrorCodeEnum.CONFIG_ID_IS_NULL);
        }
    }
}
