package com.ihappy.communal.infrastructure.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CommParamService;
import com.ihappy.myredis.MyRedis;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import org.apache.log4j.Logger;

/**
 * Created by sunjd on 2018/4/3.
 */
public final class DistributedPrimaryKeyFactory {

    private final static Logger logger = CompanyLoggerUtil.getLogger();

    private static MyRedis myRedis;

    private static CommParamService commParamService;

    /**
     * 初始化方法
     * @param myRedis
     */
    public static void init(MyRedis myRedis, CommParamService commParamService) {
        DistributedPrimaryKeyFactory.myRedis = myRedis;
        DistributedPrimaryKeyFactory.commParamService = commParamService;
    }

    //企业中心，Partner分布式主键Key
    public final static String BASEINFO_COMPANY_PARTNER_SEQ_NAME = "BASEINFO_COMPANY_PARTNER_SEQ_NAME";
    //企业中心，Partner分布式主键Key并发锁
    private final static String BASEINFO_COMPANY_PARTNER_SEQ_NAME_LOCK = "BASEINFO_COMPANY_PARTNER_SEQ_NAME_LOCK";

    //企业中心，角色分布式主键Key
    public final static String BASEINFO_COMPANY_ROLE_SEQ_NAME = "BASEINFO_COMPANY_ROLE_SEQ_NAME";
    //企业中心，角色分布式主键Key并发锁
    private final static String BASEINFO_COMPANY_ROLE_SEQ_NAME_LOCK = "BASEINFO_COMPANY_ROLE_SEQ_NAME_LOCK";

    //企业中心，门店分布式主键Key
    public final static String BASEINFO_COMPANY_STORE_SEQ_NAME  = "BASEINFO_COMPANY_STORE_SEQ_NAME";
    //企业中心，门店分布式主键Key并发锁
    private final static String BASEINFO_COMPANY_STORE_SEQ_NAME_LOCK = "BASEINFO_COMPANY_STORE_SEQ_NAME_LOCK";

    //企业中心，仓库分布式主键Key
    public final static String BASEINFO_COMPANY_STOCK_SEQ_NAME  = "BASEINFO_COMPANY_STOCK_SEQ_NAME";
    //企业中心，仓库分布式主键Key并发锁
    private final static String BASEINFO_COMPANY_STOCK_SEQ_NAME_LOCK = "BASEINFO_COMPANY_STOCK_SEQ_NAME_LOCK";

    //企业中心，合作伙伴欠款订单流水分布式主键Key
    public final static String BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME  = "BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME";
    //企业中心，合作伙伴欠款订单流水分布式主键Key并发锁
    private final static String BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME_LOCK = "BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME_LOCK";

    //企业中心，会员客户等级分布式主键Key
    public final static String BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME  = "BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME";
    //企业中心，会员客户等级分布式主键Key并发锁
    private final static String BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME_LOCK = "BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME_LOCK";

    //企业中心，用户商铺收藏已购表分布式主键Key
    public final static String PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME  = "PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME";
    //企业中心，用户商铺收藏已购表分布式主键Key并发锁
    private final static String PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME_LOCK = "PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME_LOCK";

    //企业中心，店铺收藏流水表分布式主键Key
    public final static String WESHOP_COLLECTION_JOURNAL_SEQ_NAME  = "WESHOP_COLLECTION_JOURNAL_SEQ_NAME";
    //企业中心，店铺收藏流水表分布式主键Key并发锁
    private final static String WESHOP_COLLECTION_JOURNAL_SEQ_NAME_LOCK = "WESHOP_COLLECTION_JOURNAL_SEQ_NAME_LOCK";
    //企业中心 , 店铺访问流水表分布式key
    private final static String WESHOP_VISIT_JOURNAL_SEQ_NAME = "WESHOP_VISIT_JOURNAL_SEQ_NAME";
    //企业中心 , 店铺访问流水表分布式key并发锁
    private final static String WESHOP_VISIT_JOURNAL_SEQ_NAME_LOCK = "WESHOP_VISIT_JOURNAL_SEQ_NAME_LOCK";
    //企业中心，打印设置分布式主键key
    private final static String COMPANY_PRINT_CONFIG_SEQ_NAME = "COMPANY_PRINT_CONFIG_SEQ_NAME";
    //企业中心，打印设置分布式主键key并发锁
    private final static String COMPANY_PRINT_CONFIG_SEQ_NAME_LOCK = "COMPANY_PRINT_CONFIG_SEQ_NAME_LOCK";

    //门店销售业绩分布式主键key
    private final static String SALE_PERFORMANCE_SEQ_NAME = "SALE_PERFORMANCE_SEQ_NAME";
    //门店销售业绩分布式主键key并发锁
    private final static String SALE_PERFORMANCE_SEQ_NAME_LOCK = "SALE_PERFORMANCE_SEQ_NAME_LOCK";

    //分布式主键Key并发锁随机
    private final static String LOCK_VAL = "LOCK_VAL";

    public static Long generateSalePerformanceId(Long compId){
        try {
            Long l = generateCommon(SALE_PERFORMANCE_SEQ_NAME,
                    SALE_PERFORMANCE_SEQ_NAME_LOCK, compId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(CompanyErrorCodeEnum.SALE_PERFORMANCE_SEQ_FAILED);
        }
    }

    public static Long generateWeshopVisitJournalId(Long compId){
        try {
            Long l = generateCommon(WESHOP_VISIT_JOURNAL_SEQ_NAME,
                    WESHOP_VISIT_JOURNAL_SEQ_NAME_LOCK, compId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(CompanyErrorCodeEnum.WESHOP_VISIT_JOURNAL_SEQ_FAILED);
        }
    }

    /**
     *  生成公司打印设置主键值
     * @param compId
     * @return
     */
    public static Long generateCompanyPrintConfigId(Long compId) {
        try {
            Long l = generateCommon(COMPANY_PRINT_CONFIG_SEQ_NAME,
                    COMPANY_PRINT_CONFIG_SEQ_NAME_LOCK, compId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_PRINT_CONFIG_SEQ_FAILED);
        }
    }

    /**
     *  生成用户收藏表主键值
     * @param personId
     * @return
     */
    public static Long generatePersonWeshopCollectionPurchaseId(Long personId) {
        try {
            Long l = generateCommon(PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME,
                    PERSON_WESHOP_COLLECTION_PURCHASE_SEQ_NAME_LOCK, personId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(CompanyErrorCodeEnum.PERSION_WESHOP_COLLECTION_SEQ_FAILED);
        }
    }
    /**
     *  生成店铺收藏流水表主键值
     * @param compId
     * @return
     */
    public static Long generateWeshopCollectionJournalId(Long compId) {
        try {
            Long l = generateCommon(WESHOP_COLLECTION_JOURNAL_SEQ_NAME,
                    WESHOP_COLLECTION_JOURNAL_SEQ_NAME_LOCK, compId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(CompanyErrorCodeEnum.WESHOP_COLLECTION_JOURNAL_SEQ_FAILED);
        }
    }
    public static Long generatePartnerLevelId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME, BASEINFO_COMPANY_PARTNER_LEVEL_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(PartnerErrorCodeEnum.PARTNER_LEVEL_ID_SEQ_FAILED);
        }
    }

    public static Long generatePartnerArrearsOrderId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME, BASEINFO_PARTNER_ARREARS_ORDER_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(PartnerErrorCodeEnum.PARTNER_ARREARS_ORDER_ID_SEQ_FAILED);
        }
    }

    public static Long generateCompanyStockId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_COMPANY_STOCK_SEQ_NAME, BASEINFO_COMPANY_STOCK_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(StockErrorCodeEnum.BASEINFO_COMPANY_STOCK_ID_SEQ_FAILED);
        }
    }

    public static Long generateCompanyStoreId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_COMPANY_STORE_SEQ_NAME, BASEINFO_COMPANY_STORE_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(StoreErrorCodeEnum.BASEINFO_COMPANY_STORE_ID_SEQ_FAILED);
        }
    }

    public static Long generateCompanyPartnerId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_COMPANY_PARTNER_SEQ_NAME, BASEINFO_COMPANY_PARTNER_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(PartnerErrorCodeEnum.BASEINFO_COMPANY_PARTNER_ID_SEQ_FAILED);
        }
    }

    public static Long generateCompanyRoleId(Object value) {
        if(value == null || !StringUtils.isNumeric(value.toString())){
            throw new CompanyException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        Long companyId = Long.parseLong(value.toString());
        try {
            Long l =  generateCommon(BASEINFO_COMPANY_ROLE_SEQ_NAME, BASEINFO_COMPANY_ROLE_SEQ_NAME_LOCK, companyId, 4);
            return l;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CompanyException(RoleErrorCodeEnum.BASEINFO_COMPANY_ROLE_ID_SEQ_FAILED);
        }
    }

    private static Long generateCommon(String seqName, String seqLockName, long id,  int length) throws Exception{
        Long seq = 0l;
        //获取db最大值
        /*Long maxId = commParamService.getValueByName(seqName);
        try {
            if (myRedis.setnx(seqLockName, LOCK_VAL) == 1) {
                seq = myRedis.getSequence(seqName);
                if (seq == null || seq <= maxId) {
                    //db拿到的数据加1000，以防异步线程同步延迟。项目紧急，异步线程后面再加
                    seq = myRedis.getSequenceAddNum(seqName, maxId + 1000L - seq);
                }
            } else {
                Thread.sleep(500l);
                seq = myRedis.getSequence(seqName);
                if (seq == null || seq <= maxId) {
                    throw new CompanyException(seqName);
                }
            }
        } finally {
            myRedis.del(seqLockName);
        }
        if (seq == null || seq == 0){
            throw new CompanyException(seqName);
        }*/
        seq = myRedis.getSequence(seqName);
        return  Long.valueOf(seq + subfix(id, length));
    }


    private static String subfix(Long id, int length) {
        Long max = (long)(Math.pow(10, length)) - 1;
        if(id <= max - 1) {
            return String.format("%0" + length + "d", id);
        }
        String idStr = id.toString();
        return idStr.substring(idStr.length() - length, idStr.length());
    }
}

