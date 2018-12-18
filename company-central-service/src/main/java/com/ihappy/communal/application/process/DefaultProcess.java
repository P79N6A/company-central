package com.ihappy.communal.application.process;

/**
 * Created by renyueliang on 2018/3/7.
 */

import com.alibaba.fastjson.JSON;
import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.common.exception.DataBaseException;
import com.ihappy.common.exception.IdempotentException;
import com.ihappy.common.exception.InvokeRpcServiceException;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.infrastructure.util.CompayLoggerUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.exception.PartnerException;
import com.ihappy.role.exception.RoleException;
import com.ihappy.stock.exception.StockException;
import com.ihappy.store.exception.StoreException;
import org.apache.log4j.Logger;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: renyueliang
 * Date: 16/9/3
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 */
public abstract class DefaultProcess<P extends BaseReqDTO,M> implements IProcess<P, M> {


    protected static Logger logger = CompayLoggerUtil.getLogger();

    private long startTime;

    private long endTime;

    @Override
    public void start(Context<P, M> context) {

        try {
            onStarted(context);
            process(context);
            onSuccess(context);
        } catch (IdempotentException e) {
            onIdempotent(context);
        } catch (Throwable e) {
            onError(context, e);
            //throw e;
        } finally {
            onEnd(context);
        }
    }

    @Override
    public void onStarted(Context<P, M> context) {
        startTime = new Date().getTime();
        checkNotNull(context.getParam(), CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode());
        context.getParam().validation();

    }

    @Override
    public abstract void process(Context<P, M> context);

    @Override
    public void onSuccess(Context<P, M> context) {
        if (!context.getResult().isSuccess()) {
            context.setResultSuccess(true);
        }
    }

    @Override
    public void onIdempotent(Context<P, M> context) {
        context.setResultSuccess(true);
        context.setResultErrCode(CompanyErrorCodeEnum.IDEMPOTENT_INVOKE.getErrCode());
    }

    @Override
    public void onError(Context<P, M> context, Throwable e) {
        if (e != null) {
            if (e instanceof IdempotentException || CompanyErrorCodeEnum.IDEMPOTENT_INVOKE.getErrCode().equals(e.getMessage())) {
                onIdempotent(context);
                return;
            }
            if (e.getCause() != null && (e.getCause() instanceof IdempotentException || CompanyErrorCodeEnum.IDEMPOTENT_INVOKE.getErrCode().equals(e.getCause().getMessage()))) {
                onIdempotent(context);
                return;
            }
        }
        if (context.getResult().isSuccess()) {
            context.getResult().setSuccess(false);
        }
        if (e instanceof InvokeRpcServiceException) {
            context.setResultErr(e.getMessage(), ((InvokeRpcServiceException) e).getErrCode());
        }
        if (e instanceof DataBaseException) {
            context.setResultErrCode(CompanyErrorCodeEnum.EXCUTE_SQL_ERROR.getErrCode());
        } else if (e instanceof CompanyException) {
            context.setResultErr(((CompanyException) e).getErrorCode(), ((CompanyException) e).getErrorMessage() == null ? ((CompanyException) e).getDetailErrorMessage() : ((CompanyException) e).getErrorMessage());
        }else if (e instanceof RoleException) {
            context.setResultErr(((RoleException) e).getErrorCode(), ((RoleException) e).getErrorMessage() == null ? ((RoleException) e).getDetailErrorMessage() : ((RoleException) e).getErrorMessage());
        }else if (e instanceof PartnerException) {
            context.setResultErr(((PartnerException) e).getErrorCode(), ((PartnerException) e).getErrorMessage() == null ? ((PartnerException) e).getDetailErrorMessage() : ((PartnerException) e).getErrorMessage());
        }else if (e instanceof StockException) {
            context.setResultErr(((StockException) e).getErrorCode(), ((StockException) e).getErrorMessage() == null ? ((StockException) e).getDetailErrorMessage() : ((StockException) e).getErrorMessage());
        }else if (e instanceof StoreException) {
            context.setResultErr(((StoreException) e).getErrorCode(), ((StoreException) e).getErrorMessage() == null ? ((StoreException) e).getDetailErrorMessage() : ((StoreException) e).getErrorMessage());
        }else if (e != null) {
            context.setResultErrCode(e.getMessage());
        }

        logger.error("[param]:" + JSON.toJSONString(context.getParam()) + ",[action]:" + context.getAction().name(), e);
    }

    @Override
    public void onEnd(Context<P, M> context) {
        endTime = new Date().getTime();
        CompayLoggerUtil.record(context.getAction().name(), context.getResult(), context.getParam(), endTime - startTime);
    }

}