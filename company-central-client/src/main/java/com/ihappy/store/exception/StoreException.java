package com.ihappy.store.exception;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * Created by renyueliang on 2018/3/20.
 */
public class StoreException extends RuntimeException {


    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;


    public StoreException(Throwable e) {
        super(e.getMessage());
        this.errorCode = e.getMessage();
    }


    public StoreException(CompanyErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StoreException(CompanyErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StoreException(StockErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StoreException(StockErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StoreException(StoreErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StoreException(StoreErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StoreException(PartnerErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StoreException(PartnerErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StoreException(RoleErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StoreException(RoleErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StoreException(String errorCode, String errorMessage, String detailErrorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public StoreException(String errorCode, String errorMessage, String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public StoreException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public StoreException(String errorCode, String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public StoreException(String errorCode, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
    }

    public StoreException(String errorCode) {
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
