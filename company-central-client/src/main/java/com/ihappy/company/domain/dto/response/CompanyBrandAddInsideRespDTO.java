package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/5/9.
 */
public class CompanyBrandAddInsideRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7942726059670900894L;
    /**
     * 公司品牌id
     */
    private Integer brandId;
    /**
     * 是否已存在
     * 1-已存在  0-不存在
     */
    private Boolean exist;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}
