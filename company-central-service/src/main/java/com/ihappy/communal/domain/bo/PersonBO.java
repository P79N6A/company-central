package com.ihappy.communal.domain.bo;

import com.ihappy.company.domain.model.model.CompanyModel;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-12-7 上午10:34
 */
public class PersonBO {
    private Long curCompId;
    private Long personId;
    private String personName;

    public Long getCurCompId() {
        return curCompId;
    }

    public void setCurCompId(Long curCompId) {
        this.curCompId = curCompId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
