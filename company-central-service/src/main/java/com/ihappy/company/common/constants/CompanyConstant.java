package com.ihappy.company.common.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunjd on 2018/4/9.
 */
public class CompanyConstant {
    //错误重试次数
    public static final Integer ERROR_RETRY = 3;
    //默认门店名称
    public static final String DEFAULT_STORE_NAME = "默认门店";
    //公共门店（即总店/总仓门店）名称
    public static final String PUBLIC_STORE_NAME = "总店";
    //总仓名称
    public static final String DEFAULT_PUBLIC_STORE_STOCK_NAME = "总仓";
    //默认仓库名称
    public static final String DEFAULT_STOCK_NAME = "默认门店仓库";
    //默认公共仓库名称
    public static final String DEFAULT_PUBLIC_STOCK_NAME = "默认公共仓库";
    // 默认微商铺名称
    public static final String DEFAULT_WESHOP_NAME = "默认微商铺";
    // 微商铺后缀
    public static final String WESHOP_NAME_POSTFIX = "的微商铺";
    // 相同token微商铺访问量增加时间间隔(秒)
    public static final Integer WESHOP_VISIT_INCREASE_INTERVAL = 180;
    // 默认打印提醒
    public static final String DEFAULT_PRINT_WARN = "钱款、件数请当面点清，离店概不负责，货物如有缺漏、损坏、到货请即通知，次品必需七天调换，不可退款，人为因素或逾期恕不退换，多谢合作！";
    // 需要统计访问量的请求来源
    public static final Set<String> INCR_VISIT_FROM = new HashSet<>(Arrays.asList("collection","purchase","recomand","all","share"));



    public final  static String FACTORY_INFO_KEY="factoryInfoKey";

    public final static String FACTORY_INFO_REDIS_KEY ="factoryInfoKeyForRedis";

    public final static int YEAR_DAY = 365;
}
