package com.ihappy.company.domain.dto.request.user;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/8/30.
 * 用户信息查询DTO
 */
public class UserInfoReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 7612276385511854182L;
    @FieldComment(value = "门店id",required = true,defaultValue = "")
    private Long storeId;
    @FieldComment("企业ID")
    private Long compId;
    @FieldComment(value = "是否删除标志")
    private Integer deletedFlag;
    @FieldComment(value = "门店id列表")
    private List<Long> storeIdList;
    @FieldComment(value = "角色id")
    private List<Long> roleIdList;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public List<Long> getStoreIdList() {
        return storeIdList;
    }

    public void setStoreIdList(List<Long> storeIdList) {
        this.storeIdList = storeIdList;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
