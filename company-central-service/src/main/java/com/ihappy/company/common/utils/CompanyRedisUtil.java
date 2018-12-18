package com.ihappy.company.common.utils;

import com.ihappy.common.util.DateUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.domain.dbdo.SysCompanyTypePrintBill;
import com.ihappy.myredis.MyRedis;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import jdk.nashorn.internal.parser.Token;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 21:23
 */
public class CompanyRedisUtil extends SequenceBase{

    private static MyRedis myRedis;

    // 打印设置列表缓存redis前缀
    public static final String COMPANY_TYPE_PRINT_BILL_PREFIX = "COMPANY_TYPE_PRINT_BILL:";

    // 用户是否在一定间隔内访问过某微商铺的key前缀
    public static final String TOKEN_WESHOP_VISIT_PREFIX = "TOKEN_WESHOP_VISIT:";

    //用户id
    public static String orderBuyerIdSeq = "ORDER_COMPANY_JOURNAL_SEQ_NAME";
    public static String orderBuyerIdSeqLock = "ORDER_COMPANY_JOURNAL_SEQ_NAME_LOCK";
    public static String orderBuyerIdSeqLockVal = "ORDER_COMPANY_JOURNAL_SEQ_NAME_LOCK_VAL";

    public CompanyRedisUtil(){

    }


    public MyRedis getMyRedis() {
        return myRedis;
    }

    public void setMyRedis(MyRedis myRedis) {
        CompanyRedisUtil.myRedis = myRedis;
    }

    public static String putCompanyTypePrintBill(int ctId, List<SysCompanyTypePrintBill> printBillList, long expireTime){
        return myRedis.put(COMPANY_TYPE_PRINT_BILL_PREFIX + ctId, printBillList,expireTime);
    }

    public static List<SysCompanyTypePrintBill> getCompanyTypePrintBill(int ctId) {
        List<SysCompanyTypePrintBill> printBillList = myRedis.get(COMPANY_TYPE_PRINT_BILL_PREFIX + ctId, ArrayList.class);
        if(printBillList != null && printBillList.size() > 0){
            return printBillList;
        }else {
            return new ArrayList<>();
        }
    }

    public static boolean checkHasVisitDuringInterval(String loginTokenId, Long storeId){
        long success = myRedis.setnx(TOKEN_WESHOP_VISIT_PREFIX + loginTokenId + storeId, DateUtil.getCurrentDate());
        // 设置失败, 间隔时间内访问过该店铺
        if(success == 0){
            // 还要再判断一遍时间, 防止expire指令没有发送成功导致key永不过期
            Long lastVisitTime = myRedis.get(TOKEN_WESHOP_VISIT_PREFIX + loginTokenId + storeId, Long.class);
            Long interval = DateUtil.getCurrentDate() - lastVisitTime;
            if(interval > 300){  // 大于3分钟
                // 删除缓存
                myRedis.del(TOKEN_WESHOP_VISIT_PREFIX + loginTokenId + storeId);
                return false;
            }
            return true;
        }else {
            // 设置成功, 间隔时间内没有访问过该店铺
            // 设置过期时间
            myRedis.expire(TOKEN_WESHOP_VISIT_PREFIX + loginTokenId + storeId, CompanyConstant.WESHOP_VISIT_INCREASE_INTERVAL );
            return false;
        }
    }

    //生成订单编号序列
    public static String getOrderNo() {
        long seq = myRedis.getSequence(orderBuyerIdSeq);
        return "FW"+ com.ihappy.company.common.util.DateUtil.getDateYMD(new Date())+getOrderNoMask(seq);
    }



    public static void putFactoryInfoInRedis(String factoryInfo,String compId){
        if(StringUtil.isBlank(factoryInfo)){
            return ;
        }
        myRedis.putForStr(CompanyInfoUtil.createFactoryInfoRedisKey(compId),factoryInfo);
    }


    public static String getFactoryInfoInRedis(String compId){
        return myRedis.getForStr(CompanyInfoUtil.createFactoryInfoRedisKey(compId));
    }



}
