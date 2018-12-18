package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/2.
 */
public class StaffListQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -5815125200812639383L;
    /**
     * 人员账号id
     */
    private Integer person_id;
    /**
     * 真实姓名
     */
    private String person_name;
    /**
     * 手机号
     */
    private String mobile;

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
