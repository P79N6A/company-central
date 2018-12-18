package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 13:58
 */
public class CompanyPrintConfigListRespDTO extends ICallResponseBaseDTO {

    private static final long serialVersionUID = -6288408595924857218L;

    @FieldComment(value = "单据类型")
    private Integer billType;  // 单据类型
    @FieldComment(value = "单据详细类型")
    private Integer billTypeCode;  // 单据详细类型
    @FieldComment(value = "单据类型名称")
    private String billTypeName;  // 单据类型名称

    @FieldComment(value = "打印模式0-蓝牙 1-服务")
    private Integer printMode;

    @FieldComment(value = "尺寸和份数")
    private String printSizeAndNum;  // 尺寸和份数

    public String getPrintSizeAndNum() {
        return printSizeAndNum;
    }

    public void setPrintSizeAndNum(String printSizeAndNum) {
        this.printSizeAndNum = printSizeAndNum;
    }

    public Integer getPrintMode() {
        return printMode;
    }

    public void setPrintMode(Integer printMode) {
        this.printMode = printMode;
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

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }
}
