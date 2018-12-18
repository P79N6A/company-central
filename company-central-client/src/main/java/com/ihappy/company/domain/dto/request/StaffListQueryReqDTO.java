package com.ihappy.company.domain.dto.request;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/4/2.
 */
public class StaffListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -824882182097742093L;
    /**
     * 企业id
     */
    private Integer comp_id;

    public Integer getComp_id() {
        return comp_id;
    }

    public void setComp_id(Integer comp_id) {
        this.comp_id = comp_id;
    }

    @Override
    public void validation() {

    }
}
