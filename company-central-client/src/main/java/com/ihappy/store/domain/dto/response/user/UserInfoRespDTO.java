package com.ihappy.store.domain.dto.response.user;

import com.ihappy.store.domain.dto.response.store.PersonPerformanceRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/7.
 */
public class UserInfoRespDTO implements Serializable{
    private static final long serialVersionUID = -4104695661042698715L;
    @FieldComment(value = "公司id",required = false,defaultValue = "")
    private Long compId;

    @FieldComment(value = "用户id",required = false,defaultValue = "")
    private Long personId;

    @FieldComment(value = "用户名",required = false,defaultValue = "王大锤")
    private String personName;

    @FieldComment(value = "用户头像",required = false,defaultValue = "")
    private String avatar;

    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;

    @FieldComment(value = "手机号")
    private String personMobile;

    @FieldComment(value = "角色id")
    private Long roleId;

    public PersonPerformanceRespDTO toPersonPerformanceRespDTO(){
        PersonPerformanceRespDTO respDTO = new PersonPerformanceRespDTO();
        respDTO.setPersonId(personId);
        respDTO.setPersonName(personName);
        respDTO.setAvatar(avatar);
        respDTO.setAimAmount(0L);
        respDTO.setAimAmountY("0.00");
        respDTO.setDueAmount(0L);
        respDTO.setDueAmountY("0.00");
        return respDTO;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(String personMobile) {
        this.personMobile = personMobile;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
