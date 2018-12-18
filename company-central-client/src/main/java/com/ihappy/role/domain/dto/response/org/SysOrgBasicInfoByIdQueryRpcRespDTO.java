package com.ihappy.role.domain.dto.response.org;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

/**
 * Created by sunjd on 2018/6/18.
 */
public class SysOrgBasicInfoByIdQueryRpcRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -3737053768167578952L;
    /**
     * 列表
     */
    private List<SysOrgBasicInfoRespDTO> orgList;
    /**
     * 树
     */
    private SysOrgBasicInfoTreeRespDTO orgTree;

    public List<SysOrgBasicInfoRespDTO> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<SysOrgBasicInfoRespDTO> orgList) {
        this.orgList = orgList;
    }

    public SysOrgBasicInfoTreeRespDTO getOrgTree() {
        return orgTree;
    }

    public void setOrgTree(SysOrgBasicInfoTreeRespDTO orgTree) {
        this.orgTree = orgTree;
    }
}
