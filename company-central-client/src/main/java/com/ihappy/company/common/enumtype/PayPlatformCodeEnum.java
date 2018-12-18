package com.ihappy.company.common.enumtype;

/**
 * Created by Administrator on 2017/2/16.
 */
public enum PayPlatformCodeEnum {

    POS_CODE("1","1","POS刷卡"),
    MONEY__CODE("2","2", "现金"),
    WECHAT_CODE("3","4","微信"),
    APLIPAY_CODE("4","8","支付宝");
    private String code;
    private String tradeCode;

    private String value;

    PayPlatformCodeEnum(String code, String tradeCode, String value) {
        this.code = code;
        this.value = value;
        this.tradeCode = tradeCode;
    }

    public String getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

    public static String getValue(String code){
        for(PayPlatformCodeEnum payPlatformCodeEnum : PayPlatformCodeEnum.values()){
            if(payPlatformCodeEnum.getCode().equals(code)){
                return payPlatformCodeEnum.getValue();
            }
        }
        return "";
    }
    public static Integer getTradeCode(String code){
        for(PayPlatformCodeEnum payPlatformCodeEnum : PayPlatformCodeEnum.values()){
            if(payPlatformCodeEnum.getCode().equals(code)){
                return Integer.parseInt(payPlatformCodeEnum.getTradeCode());
            }
        }
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public static void main(String[] args) {
        System.out.println(PayPlatformCodeEnum.getTradeCode("1"));
    }
}
