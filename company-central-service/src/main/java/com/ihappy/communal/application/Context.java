package com.ihappy.communal.application;

import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by renyueliang on 2018/3/6.
 */
public class Context<P,M> {


    private P param;

    private Action action;

    private Result<M> result;

    //热点参数
    private String hotParam;


    public Context(P param, Result<M> result, Action action){
        this.param = param;
        this.result = result;
        this.action = action;
    }

    public Context(P param,Result<M> result,Action action,String hotParam){
        this.param = param;
        this.result = result;
        this.action = action;
        this.hotParam = hotParam;
    }

    public Result<M> getResult() {
        return result;
    }

    public P getParam() {
        return param;
    }

    public Action getAction() {
        return action;
    }

    public void setResultSuccess(boolean success){
        result.setSuccess(success);
    }

    public void setResultErrCode(String errCode){
        result.setErrCode(errCode);
        CompanyErrorCodeEnum tbcpErrorCodeEnum=CompanyErrorCodeEnum.getTbcpErrorCodeEnum(errCode);
        if(tbcpErrorCodeEnum!=null){
            result.setErrMsg(tbcpErrorCodeEnum.getErrMsg());
        }
    }

    public void setResultErr(String errCode, String errMsg){
        result.setErrCode(errCode);
        CompanyErrorCodeEnum tbcpErrorCodeEnum=CompanyErrorCodeEnum.getTbcpErrorCodeEnum(errCode);

        if(StringUtil.isNotBlank(errMsg)){
            result.setErrMsg(errMsg);
        }else if(tbcpErrorCodeEnum!=null){
            result.setErrMsg(tbcpErrorCodeEnum.getErrMsg());
        }
    }

    public void setResultModule(M m){
        result.setModule(m);
    }

    public void setResult(Result<M> result) {
        this.result = result;
    }
}
