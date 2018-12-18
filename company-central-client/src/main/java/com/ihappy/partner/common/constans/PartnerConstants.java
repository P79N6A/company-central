package com.ihappy.partner.common.constans;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午6:51
 */
public class PartnerConstants {
    /**
     * 预存款或欠款增加
     */
    public static final Integer INCOME_TYPE_INCREASE = 1;
    /**
     * 预存款或欠款减少
     */
    public static final Integer INCOME_TYPE_DECREASE = 2;
    /**
     * redis Partner统计回调锁
     */
    public static final String PARTNER_ORDER_STATISTIC_KEY = "PARTNER_ORDER_STATISTIC_KEY";
    /**
     * redis Partner统计回调锁超时时间-秒
     */
    public static final Integer PARTNER_ORDER_STATISTIC_KEY_TIME = 10;
    /**
     * redis Partner统计回调缓存 partnerId set
     * 用于缓存需要回调的partnerId
     * PartnerId-compId-orderType
     * 拥有同样{}内部字符串的key就会拥有相同slot
     */
    public static final String PARTNER_ORDER_STATISTIC_SET = "{PARTNER_ORDER_STATISTIC}_SET";

    /**
     * redis Partner统计回调 partnerId set
     * 执行回调的partnerId set
     * 拥有同样{}内部字符串的key就会拥有相同slot
     */
    public static final String PARTNER_ORDER_STATISTIC_CALL_SET = "{PARTNER_ORDER_STATISTIC}_CALL_SET";
}
