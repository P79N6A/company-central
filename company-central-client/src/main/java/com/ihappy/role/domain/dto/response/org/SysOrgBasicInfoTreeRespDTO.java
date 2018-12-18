package com.ihappy.role.domain.dto.response.org;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/6/18.
 */
public class SysOrgBasicInfoTreeRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 8860477063358757790L;
    /**
     * 节点
     */
    private SysOrgBasicInfoRespDTO node;
    /**
     * 子树
     */
    private Map<Long,List<SysOrgBasicInfoTreeRespDTO>> childTree;

    public SysOrgBasicInfoRespDTO getNode() {
        return node;
    }

    public void setNode(SysOrgBasicInfoRespDTO node) {
        this.node = node;
    }

    public Map<Long, List<SysOrgBasicInfoTreeRespDTO>> getChildTree() {
        return childTree;
    }

    public void setChildTree(Map<Long, List<SysOrgBasicInfoTreeRespDTO>> childTree) {
        this.childTree = childTree;
    }
}
