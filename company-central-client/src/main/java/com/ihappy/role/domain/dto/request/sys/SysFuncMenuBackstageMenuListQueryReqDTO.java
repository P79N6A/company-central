package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysFuncMenuBackstageMenuListQueryReqDTO extends ICallRequestBaseQuery {

    /**
     * 菜单名称模糊查询
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void validation(){

    }
}
