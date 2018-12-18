package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 15:38
 */
public class CompanyPrintConfigInfoUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -1489463990098141284L;
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;  // 门店id
    @FieldComment(value = "打印配置id",required = true,defaultValue = "")
    private Long configId;  // 打印配置id
    @FieldComment(value = "打印尺寸",required = false,defaultValue = "")
    private String printSize;  // 打印尺寸
    @FieldComment(value = "单据标题",required = false,defaultValue = "")
    private String billName;  // 单据标题
    @FieldComment(value = "打印提醒",required = false,defaultValue = "")
    private String printWarn;  // 打印提醒
    @FieldComment(value = "是否打印账单   0：否  1：是",required = false,defaultValue = "")
    private Boolean printBill;  // 是否直接打印
    @FieldComment(value = "打印数量",required = false,defaultValue = "")
    private Integer printNum;  // 打印数量
    @FieldComment(value = "0：不立即打印  1：立即打印",required = false,defaultValue = "0")
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
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

    public Boolean getPrintBill() {
        return printBill;
    }

    public void setPrintBill(Boolean printBill) {
        this.printBill = printBill;
    }

    public Integer getImmediatelyPrint() {
        return immediatelyPrint;
    }

    public void setImmediatelyPrint(Integer immediatelyPrint) {
        this.immediatelyPrint = immediatelyPrint;
    }

    @Override
    public void validation() {
        if(configId == null || configId.equals(0L)){
            throw new CompanyException(CompanyErrorCodeEnum.CONFIG_ID_IS_NULL);
        }
    }
}
