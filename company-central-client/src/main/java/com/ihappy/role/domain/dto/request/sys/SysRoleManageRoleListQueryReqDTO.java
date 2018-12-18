package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysRoleManageRoleListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 关键词，角色名称模糊查询
     */
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public void validation() {
    }
}
