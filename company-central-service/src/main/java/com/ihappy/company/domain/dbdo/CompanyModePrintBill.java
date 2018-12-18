package com.ihappy.company.domain.dbdo;

import java.util.List;

/**
 * Created by chenying on 2018/11/14.
 */
public class CompanyModePrintBill {
    /**
     * 打印模式0-蓝牙 1-服务
     */
    private Integer printMode;

    private List<SysCompanyTypePrintBill> sysCompanyTypePrintBillList;

    public Integer getPrintMode() {
        return printMode;
    }

    public void setPrintMode(Integer printMode) {
        this.printMode = printMode;
    }

    public List<SysCompanyTypePrintBill> getSysCompanyTypePrintBillList() {
        return sysCompanyTypePrintBillList;
    }

    public void setSysCompanyTypePrintBillList(List<SysCompanyTypePrintBill> sysCompanyTypePrintBillList) {
        this.sysCompanyTypePrintBillList = sysCompanyTypePrintBillList;
    }
}
