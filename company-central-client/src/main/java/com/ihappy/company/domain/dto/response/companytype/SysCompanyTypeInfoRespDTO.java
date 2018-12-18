package com.ihappy.company.domain.dto.response.companytype;

/**
 * Created by liuhc on 2018/5/16.
 */
public class SysCompanyTypeInfoRespDTO {

    private Integer ctId;

    private String ctName;

    private String ctMemo;

    public String getCtMemo() {
        return ctMemo;
    }

    public void setCtMemo(String ctMemo) {
        this.ctMemo = ctMemo;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }
}
