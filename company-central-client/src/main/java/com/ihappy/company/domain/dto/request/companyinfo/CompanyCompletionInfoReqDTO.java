package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

/**
 * Created by sunjd on 2018/6/25.
 */
public class CompanyCompletionInfoReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 7715558403805800625L;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 类型
     * 1-体验账号
     * 2-普通账号
     */
    private Integer type;
    /**
     * 经营类目Id
     */
    private String businessCategory;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
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
