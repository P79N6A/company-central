package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 3695245164227994966L;
    /**
     * 公司品牌id
     */
    private Integer brandId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
