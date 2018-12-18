package com.ihappy.role.domain.dto.response.org;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgBasicInfoRespDTO extends ICallResponseBaseDTO {

    private static final long serialVersionUID = 1162969155005967360L;
    /**
     * 组织架构id
     */
    private Long orgId;
    /**
     * 组织架构名称
     */
    private String orgName;
    /**
     * 组织架构路径 1,2,3,路径格式
     */
    private String orgPath;
    /**
     * 组织架构编号
     */
    private String orgNo;
    /**
     * 上层组织id
     */
    private Long parentOrgid;
    /**
     * 组织架构排序 根据该排序号来确定在页面上位置，越小越在前面
     */
    private Integer orgSort;
    /**
     * 公司id
     */
    private Integer compId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Long getParentOrgid() {
        return parentOrgid;
    }

    public void setParentOrgid(Integer parentOrgid) {
        this.parentOrgid = parentOrgid == null?null:Long.valueOf(parentOrgid);
    }

    public Integer getOrgSort() {
        return orgSort;
    }

    public void setOrgSort(Integer orgSort) {
        this.orgSort = orgSort;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
