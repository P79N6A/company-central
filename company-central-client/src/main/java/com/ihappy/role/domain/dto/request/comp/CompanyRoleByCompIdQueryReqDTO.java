package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.role.exception.RoleException;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;

import java.util.List;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyRoleByCompIdQueryReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = -3631359747499583199L;
    /**
     * 公司id列表
     */
    private List<Long> compIds;

    public List<Long> getCompIds() {
        return compIds;
    }

    public void setCompIds(List<Long> compIds) {
        this.compIds = compIds;
    }

    @Override
    public void validation() {
        if (compIds == null || compIds.size() == 0) {
            throw new RoleException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
