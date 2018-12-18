package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class SysCompanyRoleListQueryRespDTO extends ICallResponseBaseDTO {
   private List<SysCompanyRoleListQueryRespDTOList> list;

    public List<SysCompanyRoleListQueryRespDTOList> getList() {
        return list;
    }

    public void setList(List<SysCompanyRoleListQueryRespDTOList> list) {
        this.list = list;
    }
}
