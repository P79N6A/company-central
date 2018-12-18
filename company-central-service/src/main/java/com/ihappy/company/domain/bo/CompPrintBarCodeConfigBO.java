package com.ihappy.company.domain.bo;

/**
 * Created by chenying on 2018/11/19.
 */
public class CompPrintBarCodeConfigBO {
    /**
     * 公司id
     */
    private Long compId;

    /**
     * 打印尺寸
     */
    private String printSize;

    /**
     * 模板类型 ：0-简易模板
     */
    private Integer barCodeTemplateType;

    /**
     * 是否优先打印单品条码:0- 不优先1-优先
     */
    private Integer firstPrintFlag;

    /**
     * 修改时间
     */
    private Long updatedAt;

    /**
     * 修改人id
     */
    private Long updatedPersonId;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getPrintSize() {
        return printSize;
    }

    public void setPrintSize(String printSize) {
        this.printSize = printSize;
    }

    public Integer getBarCodeTemplateType() {
        return barCodeTemplateType;
    }

    public void setBarCodeTemplateType(Integer barCodeTemplateType) {
        this.barCodeTemplateType = barCodeTemplateType;
    }

    public Integer getFirstPrintFlag() {
        return firstPrintFlag;
    }

    public void setFirstPrintFlag(Integer firstPrintFlag) {
        this.firstPrintFlag = firstPrintFlag;
    }

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
}
