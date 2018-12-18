package com.ihappy.store.domain.dto.response.store;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/8/29.
 */
public class PersonPerformanceRespDTO implements Serializable {
    private static final long serialVersionUID = -3727187877229551588L;
    @FieldComment(value = "用户id",required = false,defaultValue = "10001")
    private Long personId;
    @FieldComment(value = "用户名",required = false,defaultValue = "王大锤")
    private String personName;
    @FieldComment(value = "用户头像",required = false,defaultValue = "")
    private String avatar;
    @FieldComment(value = "业绩目标-分",required = false,defaultValue = "10000")
    private Long aimAmount;
    @FieldComment(value = "业绩目标-圆",required = false,defaultValue = "100")
    private String aimAmountY;
    @FieldComment(value = "实际业绩-分",required = false,defaultValue = "1200")
    private Long dueAmount;
    @FieldComment(value = "实际业绩-圆",required = false,defaultValue = "12")
    private String dueAmountY;
    @FieldComment(value = "完成率",required = false,defaultValue = "20.1")
    private String rate;
    @FieldComment(value = "业绩目标id 修改业绩时用",required = false,defaultValue = "12502")
    private Long salePerformanceId;

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

    public Long getAimAmount() {
        return aimAmount;
    }

    public void setAimAmount(Long aimAmount) {
        this.aimAmount = aimAmount;
    }

    public String getAimAmountY() {
        return aimAmountY;
    }

    public void setAimAmountY(String aimAmountY) {
        this.aimAmountY = aimAmountY;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getDueAmountY() {
        return dueAmountY;
    }

    public void setDueAmountY(String dueAmountY) {
        this.dueAmountY = dueAmountY;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getSalePerformanceId() {
        return salePerformanceId;
    }

    public void setSalePerformanceId(Long salePerformanceId) {
        this.salePerformanceId = salePerformanceId;
    }
}
