package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/4/1.
 */
public class CompanyBrandListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -578280029913494877L;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 模糊查询 品牌名称
     */
    private String fuzzyBrandName;
    /**
     * 精确查询品牌名称
     */
    private String brandName;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getFuzzyBrandName() {
        return fuzzyBrandName;
    }

    public void setFuzzyBrandName(String fuzzyBrandName) {
        this.fuzzyBrandName = fuzzyBrandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
