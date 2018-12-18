package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysCompanyRoleConfigRoleListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 限制条数
     */
    private Integer limit;
    /**
     * 起始位置
     */
    private Integer offset;
    /**
     * 关键词，角色名称模糊查询
     */
    private String keyWords;

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public Integer getOffset() {
        return offset;
    }

    @Override
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
