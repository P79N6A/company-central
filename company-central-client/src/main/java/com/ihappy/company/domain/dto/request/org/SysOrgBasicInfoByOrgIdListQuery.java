package com.ihappy.company.domain.dto.request.org;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

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
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
