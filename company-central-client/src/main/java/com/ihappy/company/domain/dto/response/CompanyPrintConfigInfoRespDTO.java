package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 13:36
 */
public class CompanyPrintConfigInfoRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 2273889517487321104L;

    @FieldComment(value = "打印配置id")
    private Long configId;
    @FieldComment(value = "单据类型")
    private Integer billType;
    @FieldComment(value = "单据详细类型")
    private Integer billTypeCode;
    @FieldComment(value = "打印尺寸")
    private String printSize = "";
    @FieldComment(value = "单据标题")
    private String billName = "";
    @FieldComment(value = "打印提醒")
    private String printWarn = "";
    @FieldComment(value = "是否直接打印")
    private Boolean printBill = false;
    @FieldComment(value = "打印份数")
    private Integer printNum = 0;
    @FieldComment(value = "单据类型名称")
    private String billTypeName;
    @FieldComment(value = "0：不立即打印  1：立即打印")
    private Integer immediatelyPrint;
    @FieldComment(value = "模板类型 ：0-简易模板")
    private Integer barCodeTemplateType;
    @FieldComment(value = " 是否优先打印单品条码:0- 不优先1-优先")
    private Integer firstPrintFlag;

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

    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    public Boolean getPrintBill() {
        return printBill;
    }

    public void setPrintBill(Boolean printBill) {
        this.printBill = printBill;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getBillTypeCode() {
        return billTypeCode;
    }

    public void setBillTypeCode(Integer billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    public String getPrintSize() {
        return printSize;
    }

    public void setPrintSize(String printSize) {
        this.printSize = printSize;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getPrintWarn() {
        return printWarn;
    }

    public void setPrintWarn(String printWarn) {
        this.printWarn = printWarn;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public Integer getImmediatelyPrint() {
        return immediatelyPrint;
    }

    public void setImmediatelyPrint(Integer immediatelyPrint) {
        this.immediatelyPrint = immediatelyPrint;
    }
}
