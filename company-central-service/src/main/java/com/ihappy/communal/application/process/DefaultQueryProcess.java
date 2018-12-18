package com.ihappy.communal.application.process;


import com.alibaba.fastjson.JSON;
import com.ihappy.common.domain.CommonQuery;
import com.ihappy.common.exception.DataBaseException;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.infrastructure.util.CompayLoggerUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import org.apache.log4j.Logger;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created with IntelliJ IDEA.
 * User: renyueliang
 * Date: 16/10/16
 * Time: 上午11:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class DefaultQueryProcess<P extends CommonQuery,M> implements IProcess<P, M>  {

    protected static Logger logger = CompayLoggerUtil.getLogger();

    private  long startTime ;

    private long endTime ;

    @Override
    public void start(Context<P,M> context){
        try{
            onStarted(context);
            process(context);
            onSuccess(context);
        }catch(Throwable e){
            onError(context, e);
            //throw e;
        }finally{
            onEnd(context);
        }
    }

    @Override
    public void onStarted(Context<P,M> context) {
        startTime=new Date().getTime();
        checkNotNull(context.getParam(), CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode());
        context.getParam().validation();
    }

    @Override
    public abstract void process(Context<P,M> context) ;

    @Override
    public void onSuccess(Context<P,M> context) {
        if(!context.getResult().isSuccess()){
            context.setResultSuccess(true);
        }
    }

    @Override
    public void onIdempotent(Context<P,M> context) {
        context.setResultSuccess(true);
        context.setResultErrCode(CompanyErrorCodeEnum.IDEMPOTENT_INVOKE.getErrCode());
    }

    @Override
    public void onError(Context<P,M> context,Throwable e) {
        if(context.getResult().isSuccess()){
            context.getResult().setSuccess(false);
        }
         if(e instanceof DataBaseException){
            context.setResultErrCode(CompanyErrorCodeEnum.EXCUTE_SQL_ERROR.getErrCode());
        } else if(e!=null){
            context.setResultErrCode(e.getMessage());
        }

        logger.error("[param]:"+ JSON.toJSONString(context.getParam())+",[action]:"+context.getAction().name(),e);
    }

    @Override
    public void onEnd(Context<P,M> context) {
        endTime=new Date().getTime();
        CompayLoggerUtil.recordForQuery(context.getAction().name(), context.getResult(), context.getParam(), endTime-startTime);
    }
}
