package com.ihappy.company.domain.dto.request.org;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/6/18.
 */
public class SysOrgBasicInfoByIdQueryRpcReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 8557264329164831253L;
    private Long orgId;
    /**
     * 返回数据结构  1-列表：List<>  2-以Map组织的树型
     */
    private Integer dataStructure=1;

    public Integer getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(Integer dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public void validation() {
        super.validation();
        if (orgId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
