package com.ihappy.role.common.enumtype;

public enum SysCompanyFuncErrorCodeEnum {
    CTID_IS_NULL("CTID_IS_NULL","分类ID为空");
    private String errMsg;
    private String errCode;

    public String getErrMsg() {
        return errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    SysCompanyFuncErrorCodeEnum(String errMsg, String errCode) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public static SysCompanyFuncErrorCodeEnum getTbcpErrorCodeEnum(String code){
        for (SysCompanyFuncErrorCodeEnum x:SysCompanyFuncErrorCodeEnum.values()){
            if (x.getErrCode().equals(code)){
                return x;
            }
        }
        return null;
    }
}
