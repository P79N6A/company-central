package com.ihappy.partner.exception;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * Created by renyueliang on 2018/3/20.
 */
public class PartnerException extends RuntimeException {


    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;


    public PartnerException(Throwable e) {
        super(e.getMessage());
        this.errorCode = e.getMessage();
    }


    public PartnerException(CompanyErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public PartnerException(CompanyErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public PartnerException(StockErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public PartnerException(StockErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public PartnerException(StoreErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public PartnerException(StoreErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public PartnerException(PartnerErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public PartnerException(PartnerErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public PartnerException(RoleErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public PartnerException(RoleErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public PartnerException(String errorCode, String errorMessage, String detailErrorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public PartnerException(String errorCode, String errorMessage, String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public PartnerException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public PartnerException(String errorCode, String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public PartnerException(String errorCode, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
    }

    public PartnerException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDetailErrorMessage() {
        return detailErrorMessage;
    }

}
