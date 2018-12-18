package com.ihappy.company.domain.bo;

/**
 * Created by sunjd on 2018/6/22.
 */
public class UserInfoBO {
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 用户id
     */
    private Long personId;

    public UserInfoBO(){

    }
    public UserInfoBO(Integer compId,Long personId){
        this.compId = compId;
        this.personId = personId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
