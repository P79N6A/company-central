package com.ihappy.company.domain.bo;

import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/11/15.
 */
public class CompanyPrintModeBO {
    @FieldComment(value = "公司id")
    private Long compId;  // 公司id
    @FieldComment(value = "打印模式0-蓝牙 1-服务")
    private Integer printMode;  // 打印模式0-蓝牙 1-服务
    @FieldComment(value = "修改时间")
    private Long updatedAt;
    @FieldComment(value = "修改人id")
    private Long updatedPersonId;

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getPrintMode() {
        return printMode;
    }

    public void setPrintMode(Integer printMode) {
        this.printMode = printMode;
    }
}
