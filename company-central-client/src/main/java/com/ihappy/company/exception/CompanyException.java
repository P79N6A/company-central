package com.ihappy.company.exception;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * Created by renyueliang on 2018/3/20.
 */
public class CompanyException extends RuntimeException {


    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;


    public CompanyException(Throwable e) {
        super(e.getMessage());
        this.errorCode = e.getMessage();
    }

    public CompanyException(CompanyErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public CompanyException(CompanyErrorCodeEnum errorCodeEnum,String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public CompanyException(StockErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public CompanyException(StockErrorCodeEnum errorCodeEnum,String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public CompanyException(StoreErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public CompanyException(StoreErrorCodeEnum errorCodeEnum,String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public CompanyException(PartnerErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public CompanyException(PartnerErrorCodeEnum errorCodeEnum,String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public CompanyException(RoleErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public CompanyException(RoleErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public CompanyException( String errorCode,String errorMessage,String detailErrorMessage,Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public CompanyException( String errorCode,String errorMessage,String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public CompanyException(String errorCode,String errorMessage,Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CompanyException(String errorCode,String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CompanyException(String errorCode,Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
    }

    public CompanyException(String errorCode) {
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
