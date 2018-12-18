package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/3/30.
 * 查询单个公司信息
 */
public class CompanyInfoQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -444685087220643578L;
    /**
     * 公司id
     */
    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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
