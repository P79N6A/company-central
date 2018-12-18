package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 9:56
 * *@content
 **/
public class BaseInfoCompanyInfoQueryRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "0黑名单  1普通 2白名单")
    private Integer status;
    @FieldComment(value = "公司头像")
    private String companyHead;
    @FieldComment(value = "公司名称")
    private String compName;
    @FieldComment(value = "公司简称")
    private String compShortName;
    @FieldComment(value = "企业类型")
    private Integer nature;
    @FieldComment(value = "业务分类")
    private String ctNames;
    @FieldComment(value = "业务分类id")
    private String ctIds;
    @FieldComment(value = "经营范围")
    private String businessCategory;
    @FieldComment(value = "经营范围名称")
    private String businessCategoryStr;
    @FieldComment(value = "所在地区")
    private String area;
    @FieldComment(value = "详细地址")
    private String compAddress;
    @FieldComment(value = "联系人")
    private String compLinkman;
    @FieldComment(value = "联系电话")
    private String compLinkTel;
    @FieldComment(value = "门店名称")
    private String storeName;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompanyHead() {
        return companyHead;
    }

    public void setCompanyHead(String companyHead) {
        this.companyHead = companyHead;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
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

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompLinkman() {
        return compLinkman;
    }

    public void setCompLinkman(String compLinkman) {
        this.compLinkman = compLinkman;
    }

    public String getCompLinkTel() {
        return compLinkTel;
    }

    public void setCompLinkTel(String compLinkTel) {
        this.compLinkTel = compLinkTel;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBusinessCategoryStr() {
        return businessCategoryStr;
    }

    public void setBusinessCategoryStr(String businessCategoryStr) {
        this.businessCategoryStr = businessCategoryStr;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }
}
