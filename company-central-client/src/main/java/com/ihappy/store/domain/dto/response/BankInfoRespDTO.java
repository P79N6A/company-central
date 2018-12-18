package com.ihappy.store.domain.dto.response;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/10/15.
 * 银行信息DTO
 */
public class BankInfoRespDTO implements Serializable {
    private static final long serialVersionUID = -5360392874480994057L;
    @FieldComment(value = "开户银行")
    private String bankName;
    @FieldComment(value = "账户名称")
    private String bankAccountName;
    @FieldComment(value = "账户名称")
    private String bankAccountNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
