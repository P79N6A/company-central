package com.ihappy.role.domain.dto.request.org;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgBasicInfoByOrgIdListQuery extends ICallRequestBaseQuery {

    private List<Long> orgIdList;

    public List<Long> getOrgIdList() {
        return orgIdList;
    }

    public void setOrgIdList(List<Long> orgIdList) {
        this.orgIdList = orgIdList;
    }

    @Override
    public void validation() {
        super.validation();
        if (orgIdList == null || orgIdList.size() <= 0) {
            throw new RoleException(RoleErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
