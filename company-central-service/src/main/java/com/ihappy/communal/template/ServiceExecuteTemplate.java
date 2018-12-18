package com.ihappy.communal.template;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.unifiedLog.module.UnifiedBaseDO;

import java.util.List;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/12 13:55
 * @Version
 */
public class ServiceExecuteTemplate {
    /**
     * 通用接口执行流程模板 返回对象
     */
    public static <T> Result<T> executeCommon(IProcess process, UnifiedBaseDO req, Class<T> respType, Action action) {
        Context context = new Context(req, new Result<T>(), action);
        process.start(context);
        return context.getResult();
    }

    /**
     * 通用接口执行流程模板，返回list
     */
    public static <T> Result<List<T>> executeCommonReturnList(IProcess process, UnifiedBaseDO req, Class<T> respType, Action action) {
        Context context = new Context(req, new Result<List<T>>(), action);
        process.start(context);
        return context.getResult();
    }

    /**
     * 通用流程执行模板 ，返回分页
     */
    public static <T> Result<Page<T>> executeCommonReturnPage(IProcess process, UnifiedBaseDO req, Class<T> respType, Action action) {
        Context context = new Context(req, new Result<Page<T>>(), action);
        process.start(context);
        return context.getResult();
    }
}
