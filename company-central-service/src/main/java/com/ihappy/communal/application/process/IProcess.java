package com.ihappy.communal.application.process;


import com.ihappy.communal.application.Context;

/**
 * Created by renyueliang on 2018/3/7.
 */
public interface IProcess <P,M> {


    public void start(Context<P, M> context);


    void onStarted(Context<P, M> context);


    void process(Context<P, M> context);


    void onSuccess(Context<P, M> context);


    void onIdempotent(Context<P, M> context);


    void onError(Context<P, M> context, Throwable e);


    void onEnd(Context<P, M> context);
}