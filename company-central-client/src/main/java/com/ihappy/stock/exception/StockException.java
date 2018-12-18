package com.ihappy.stock.exception;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * Created by renyueliang on 2018/3/20.
 */
public class StockException extends RuntimeException {


    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;


    public StockException(Throwable e) {
        super(e.getMessage());
        this.errorCode = e.getMessage();
    }


    public StockException(CompanyErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StockException(CompanyErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StockException(StockErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StockException(StockErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StockException(StoreErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StockException(StoreErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StockException(PartnerErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StockException(PartnerErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StockException(RoleErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public StockException(RoleErrorCodeEnum errorCodeEnum, String detailErrorMessage){
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public StockException(String errorCode, String errorMessage, String detailErrorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public StockException(String errorCode, String errorMessage, String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage =detailErrorMessage;
    }

    public StockException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public StockException(String errorCode, String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public StockException(String errorCode, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
    }

    public StockException(String errorCode) {
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
