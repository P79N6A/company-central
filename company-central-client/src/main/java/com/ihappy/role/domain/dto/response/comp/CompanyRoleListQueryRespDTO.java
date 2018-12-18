package com.ihappy.role.domain.dto.response.comp;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class CompanyRoleListQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 错误信息
     */
    private String errMsg;
   private List<CompanyRoleListQueryListRespDTO> list;

    public List<CompanyRoleListQueryListRespDTO> getList() {
        return list;
    }

    public void setList(List<CompanyRoleListQueryListRespDTO> list) {
        this.list = list;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
