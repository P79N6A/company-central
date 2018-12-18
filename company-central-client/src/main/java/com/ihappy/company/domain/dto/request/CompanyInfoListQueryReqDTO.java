package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

import java.util.List;

/**
 * 根据公司id 批量查询 公司信息
 * Created by sunjd on 2018/4/2.
 */
public class CompanyInfoListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 1385832999388574065L;
    /**
     * 公司id List
     */
    private List<Integer> compIds;

    public List<Integer> getCompIds() {
        return compIds;
    }

    public void setCompIds(List<Integer> compIds) {
        this.compIds = compIds;
    }

    @Override
    public void validation() {
        if (compIds == null || compIds.size() == 0) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
