package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/3/29.
 */
public class BaseinfoCompanyRespDTO extends ICallResponseBaseDTO {

    private static final long serialVersionUID = 1162969155005967360L;
    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 企业名称
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    private Integer nature;
    /**
     * 公司业务分类名
     */
    private String ctNames;
    /**
     * 公司业务分类id
     */
    private String ctIds;

    /**
     * 管理手机号
     */
    private String adminPersonName;

    /**
     * 管理员id
     */
    private Long adminPersonId;
    /**
     * 公司状态 0黑名单 1普通 2白名单
     */
    private Integer status;
    /**
     * 是否审核(0:待审核 1:审核通过 2:审核不通过)
     */
    private Integer isVerified;
    /**
     * 审核状态字符串
     */
    private String isVerifiedStr;

    /**
     * 注册人手机号
     */
    private String adminPersonMobile;
    /**
     * 注册时间字符串
     */
    private String registerDateStr;
    /**
     * 到期时间
     */
    private String expireDateStr;
    /**
     * 剩余有效日期
     */
    private String periodOfValidity;
    /**
     * 备注
     */
    private String payRemark;
    /**
     * 备注者
     */
    private String payRemarkUserName;
    /**
     * 付款备注时间
     */
    private String payRemarkTimeStr;

    /**
     * 名称
     */
    private String expireStatusName;

    /**
     * 名称
     */
    private String statusName;


    private String updatedAt;

    private String updatedPersonName;

    private Long updatedPersonId;

    /**
     * 备注
     */
    private String memo;

    @FieldComment(value = ":测试，1:线上")
    private Integer onlineOrTest;

    public String getIsVerifiedStr() {
        return isVerifiedStr;
    }

    public void setIsVerifiedStr(String isVerifiedStr) {
        this.isVerifiedStr = isVerifiedStr;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getCtNames() {
        return ctNames;
    }

    public void setCtNames(String ctNames) {
        this.ctNames = ctNames;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public String getAdminPersonMobile() {
        return adminPersonMobile;
    }

    public void setAdminPersonMobile(String adminPersonMobile) {
        this.adminPersonMobile = adminPersonMobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getAdminPersonName() {
        return adminPersonName;
    }

    public void setAdminPersonName(String adminPersonName) {
        this.adminPersonName = adminPersonName;
    }

    public Long getAdminPersonId() {
        return adminPersonId;
    }

    public void setAdminPersonId(Long adminPersonId) {
        this.adminPersonId = adminPersonId;
    }

    public String getRegisterDateStr() {
        return registerDateStr;
    }

    public void setRegisterDateStr(String registerDateStr) {
        this.registerDateStr = registerDateStr;
    }

    public String getExpireDateStr() {
        return expireDateStr;
    }

    public void setExpireDateStr(String expireDateStr) {
        this.expireDateStr = expireDateStr;
    }

    public String getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(String periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayRemarkUserName() {
        return payRemarkUserName;
    }

    public void setPayRemarkUserName(String payRemarkUserName) {
        this.payRemarkUserName = payRemarkUserName;
    }

    public String getPayRemarkTimeStr() {
        return payRemarkTimeStr;
    }

    public void setPayRemarkTimeStr(String payRemarkTimeStr) {
        this.payRemarkTimeStr = payRemarkTimeStr;
    }

    public String getExpireStatusName() {
        return expireStatusName;
    }

    public void setExpireStatusName(String expireStatusName) {
        this.expireStatusName = expireStatusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedPersonName() {
        return updatedPersonName;
    }

    public void setUpdatedPersonName(String updatedPersonName) {
        this.updatedPersonName = updatedPersonName;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getOnlineOrTest() {
        return onlineOrTest;
    }

    public void setOnlineOrTest(Integer onlineOrTest) {
        this.onlineOrTest = onlineOrTest;
    }
}
