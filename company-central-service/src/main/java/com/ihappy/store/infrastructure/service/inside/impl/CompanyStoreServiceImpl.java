package com.ihappy.store.infrastructure.service.inside.impl;

import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.CompanyWhiteBlackEnum;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;
import com.ihappy.company.common.enumtype.IsPublicEnum;
import com.ihappy.company.common.enumtype.company.IsDefaultEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.bo.store.*;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStoreCt;
import com.ihappy.store.domain.dto.request.store.StoreListQueryReqDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.exception.StoreException;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.performance.SalePerformanceMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreCtMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/4/10.
 */
public class CompanyStoreServiceImpl implements CompanyStoreService {
    @Autowired
    private BaseinfoCompanyStoreMapper baseinfoCompanyStoreMapper;
    @Autowired
    private BaseinfoCompanyStoreCtMapper baseinfoCompanyStoreCtMapper;
    @Autowired
    private TransactionTemplate companyTransactionTemplate;
    @Autowired
    private StockService stockService;
    @Autowired
    private SalePerformanceMapper salePerformanceMapper;

    @Override
    public Boolean addDefStore(CompanyStoreModel model) {
        if (model == null || model.getDO() == null || model.getDO().getCompId() == null) {
            return false;
        }
        Integer compId = model.getDO().getCompId();
        Long adminPersonId = model.getDO().getAdminPersonId();
        companyTransactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                //判断默认门店是否已存在
                BaseinfoCompanyStore oldStorParam = new BaseinfoCompanyStore();
                oldStorParam.setStoreName(CompanyConstant.DEFAULT_STORE_NAME);
                oldStorParam.setCompId(model.getDO().getCompId());
                oldStorParam.setIsDeleted(0);
                List<BaseinfoCompanyStore> oldStores = baseinfoCompanyStoreMapper.selectSelective(oldStorParam);
                if (!CollectionUtils.isEmpty(oldStores)) {
                    for (BaseinfoCompanyStore obj : oldStores) {
                        if (!obj.getIsDefault().equals(IsDefaultEnum.DEFAULT.getKey())) {
                            BaseinfoCompanyStore oldStoreUpdateParam = new BaseinfoCompanyStore();
                            oldStoreUpdateParam.setStoreId(obj.getStoreId());
                            oldStoreUpdateParam.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
                            baseinfoCompanyStoreMapper.updateByPrimaryKeySelective(oldStoreUpdateParam);
                        }
                        BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                        stock.setCompId(compId);
                        stock.setStoreId(obj.getStoreId());
                        stock.setCreatedPersonId(adminPersonId);
                        stockService.addDefStockAndPublicDefStock(new CompanyStockModel(stock));
                    }
                } else {
                    Long storeId = DistributedPrimaryKeyFactory.generateCompanyStoreId(compId);
                    if (storeId == null) {
                        throw new CompanyException(StoreErrorCodeEnum.
                                ADD_DEF_STORE_ERROR.getErrCode(),
                                StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
                    }
                    BaseinfoCompanyStore store = new BaseinfoCompanyStore();
                    store.setStoreId(storeId);
                    store.setCompId(compId);
                    store.setAdminPersonId(adminPersonId);
                    store.setStoreName(CompanyConstant.DEFAULT_STORE_NAME);
                    store.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
                    store.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                    store.setCreateTime(Integer.valueOf(System.currentTimeMillis() / 1000 + ""));
                    store.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
                    // 初始化微商铺信息
                    store.setIsHasWeshop(1);
                    store.setWeshopStatus(2);
                    store.setWeshopName(CompanyConstant.DEFAULT_STORE_NAME);
                    store.setWeshopAddress(model.getDO().getWeshopAddress());
                    store.setWeshopProvince(model.getDO().getWeshopProvince());
                    store.setWeshopCity(model.getDO().getWeshopCity());
                    store.setWeshopZone(model.getDO().getWeshopZone());
                    store.setBusinessCategory(model.getDO().getBusinessCategory());
                    store.setWeshopContactType(model.getDO().getWeshopContactType());
                    store.setWeshopManagerId(model.getDO().getWeshopManagerId());
                    store.setWeshopManagerName(model.getDO().getWeshopManagerName());
                    Integer insertStoreNum = baseinfoCompanyStoreMapper.insertSelective(store);
                    if (insertStoreNum == 1) {
                        BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                        stock.setCompId(compId);
                        stock.setStoreId(storeId);
                        stock.setCreatedPersonId(adminPersonId);
                        if (!stockService.addDefStockAndPublicDefStock(new CompanyStockModel(stock))) {
                            status.setRollbackOnly();
                        }
                    } else {
                        status.setRollbackOnly();
                        throw new CompanyException(StoreErrorCodeEnum.
                                ADD_DEF_STORE_ERROR.getErrCode(),
                                StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
                    }
                }
                return null;
            }
        });
        return true;
    }

    @Override
    public Boolean addPublicStoreAndStock(CompanyStoreModel model) {
        if (model == null || model.getDO() == null || model.getDO().getCompId() == null) {
            return false;
        }
        Integer compId = model.getDO().getCompId();
        Long adminPersonId = model.getDO().getAdminPersonId();
        //判断默认门店是否已存在
        BaseinfoCompanyStore oldStorParam = new BaseinfoCompanyStore();
        oldStorParam.setStoreName(CompanyConstant.DEFAULT_STORE_NAME);
        oldStorParam.setCompId(model.getDO().getCompId());
        oldStorParam.setIsDeleted(0);
        oldStorParam.setIsPublic(1);
        List<BaseinfoCompanyStore> oldStores = baseinfoCompanyStoreMapper.selectSelective(oldStorParam);
        if (!CollectionUtils.isEmpty(oldStores)) {
            for (BaseinfoCompanyStore obj : oldStores) {
                BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                stock.setCompId(compId);
                stock.setStoreId(obj.getStoreId());
                stock.setCreatedPersonId(adminPersonId);
                stockService.addPublicStock(new CompanyStockModel(stock));
            }
            return true;
        } else {
            //添加总店
            BaseinfoCompanyStore publicStore = new BaseinfoCompanyStore();
            publicStore.setCompId(compId);
            publicStore.setAdminPersonId(model.getDO().getCreatedPersonId());
            Long publicStoreId = addPublicStore(publicStore);
            BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
            stock.setCompId(compId);
            stock.setStoreId(publicStoreId);
            stock.setCreatedPersonId(adminPersonId);
            stockService.addPublicStock(new CompanyStockModel(stock));
            return true;
        }
    }


    @Override
    public Map<Long, CompanyStoreModel> selectByStoreIds(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)) {
            return new HashMap<>();
        }
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectByStoreIds(map);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new HashMap<>();
        }
        Map<Long, CompanyStoreModel> storeModelMap = new HashMap<Long, CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : baseinfoCompanyStores) {
            storeModelMap.put(obj.getStoreId(), new CompanyStoreModel(obj));
        }
        return storeModelMap;
    }

    @Override
    public List<CompanyStoreModel> findStoreListByCompIdAndStoreIds(Map<String, Object> map) {
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectByCompIdAndStoreIds(map);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new ArrayList<>();
        }
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : baseinfoCompanyStores) {
            res.add(new CompanyStoreModel(obj));
        }
        return res;
    }

    @Override
    public Map<Long, CompanyStoreModel> findStoreMapByCompIdAndStoreIds(Map<String, Object> map) {
        Map<Long, CompanyStoreModel> res = new HashMap<Long, CompanyStoreModel>();
        List<CompanyStoreModel> list = findStoreListByCompIdAndStoreIds(map);
        for (CompanyStoreModel obj : list) {
            res.put(obj.getStoreId(), obj);
        }
        return res;
    }

    @Override
    public List<CompanyStoreModel> queryStoreInfoByInfoList(StoreInfoQueryBO storeInfoQueryBO) {
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.queryStoreInfoByInfoList(storeInfoQueryBO);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new ArrayList<>();
        }
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : baseinfoCompanyStores) {
            res.add(new CompanyStoreModel(obj));
        }
        return res;
    }

    @Override
    public List<CompanyStoreModel> findValidStoreListByCompIdAndStoreIds(QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("compId", queryStoreListByCompIdAndStoreIdsBO.getCompId());
        map.put("storeIds", queryStoreListByCompIdAndStoreIdsBO.getStoreIds());
//        map.put("forbidden",0);
        if (queryStoreListByCompIdAndStoreIdsBO.getFilterForbidden() == null){
            map.put("forbidden",0);
        }
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectByCompIdAndStoreIds(map);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new ArrayList<>();
        }
        if (queryStoreListByCompIdAndStoreIdsBO.getAvailable() != null && queryStoreListByCompIdAndStoreIdsBO.getAvailable() == 2) {
            return CompanyStoreFactory.list2ModeList(baseinfoCompanyStores);
        }
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : baseinfoCompanyStores) {
            res.add(new CompanyStoreModel(obj));
        }
        return res;
    }

    @Override
    public List<CompanyStoreModel> findStoreListByCompId(Integer compId) {
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectByCompId(compId);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new ArrayList<>();
        }
        return transform(baseinfoCompanyStores, (baseinfoCompanyStore) -> new CompanyStoreModel(baseinfoCompanyStore));
    }

    @Override
    public List<CompanyStoreModel> findValidStoreListByCompId(Integer compId) {
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectByCompId(compId);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return new ArrayList<>();
        }
        return CompanyStoreFactory.list2ModeList(baseinfoCompanyStores);
    }

    /*@Override
    public List<CompanyStoreModel> filterValidStoreList(List<BaseinfoCompanyStore> baseinfoCompanyStores) {
        //服务过期时间放到公司去了，门店没有过期概念
        if (baseinfoCompanyStores == null || baseinfoCompanyStores.size() == 0){
            return new ArrayList<CompanyStoreModel>();
        }
        Integer compId = baseinfoCompanyStores.get(0).getCompId();
        BaseinfoCompany company  = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        List<String> ctIds = java.util.Arrays.asList(company.getCtIds().split(","));
        List<Long> storeIds = new ArrayList<Long>();
        for (BaseinfoCompanyStore store : baseinfoCompanyStores){
            storeIds.add(store.getStoreId());
        }
        Long curTime = CompanyDateUtil.getDate14Long(new Date());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ctIds",ctIds);
        map.put("compId",compId);
        map.put("storeIds",storeIds);
        List<BaseinfoCompanyStoreCt> baseinfoCompanyStoreCts = baseinfoCompanyStoreCtMapper.selectListByCtIds(map);
        List<BaseinfoCompanyStore> availableStore = new ArrayList<BaseinfoCompanyStore>();
        for(BaseinfoCompanyStore store : baseinfoCompanyStores){
            for(BaseinfoCompanyStoreCt storeCt : baseinfoCompanyStoreCts){
                if (NumberUtil.equalNum(store.getStoreId(),storeCt.getStoreId())){
                    if (storeCt.getEndTime() != null && storeCt.getEndTime() > curTime){
                        availableStore.add(store);
                    }
                }
            }
        }
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : baseinfoCompanyStores){
            res.add(new CompanyStoreModel(obj));
        }
        return res;
    }*/

    @Override
    public Integer updatePrintIpAndPort(CompanyStoreModel model) {
        return baseinfoCompanyStoreMapper.updatePrintIpAndPort(model.getDO());
    }

    @Override
    public CompanyStoreModel findByStoreIdAndCompId(CompanyStoreModel model) {
        BaseinfoCompanyStore store = baseinfoCompanyStoreMapper.selectByStoreIdAndCompId(model.getDO());
        if (store == null) {
            return null;
        }
        return new CompanyStoreModel(store);
    }

    @Override
    public Boolean validateStore(BaseinfoCompanyStore baseinfoCompanyStore) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("compId", baseinfoCompanyStore.getCompId());
        List<Long> storeIds = new ArrayList<>();
        storeIds.add(baseinfoCompanyStore.getStoreId());
        map.put("storeIds", storeIds);
        List<BaseinfoCompanyStoreCt> baseinfoCompanyStoreCts = baseinfoCompanyStoreCtMapper.selectListByCtIds(map);
        if (null != baseinfoCompanyStoreCts && baseinfoCompanyStoreCts.size() > 0) {
            BaseinfoCompanyStoreCt baseinfoCompanyStoreCt = baseinfoCompanyStoreCts.get(0);
            Long endtime = baseinfoCompanyStoreCt.getEndTime();
            Long startTime = baseinfoCompanyStoreCt.getStartTime();
            Long curTime = CompanyDateUtil.getDate14Long(new Date());
            if (null != endtime && null != startTime
                    && curTime != null && curTime >= startTime
                    && curTime <= endtime) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public CompanyStoreModel findStoreById(Long storeId) {
        BaseinfoCompanyStore store = baseinfoCompanyStoreMapper.selectByPrimaryKey(storeId);
        if (store == null) {
            return null;
        } else {
            return new CompanyStoreModel(store);
        }
    }

    @Override
    public Integer updateByIdSelective(CompanyStoreModel store) {
        Integer res = baseinfoCompanyStoreMapper.updateByPrimaryKeySelective(store.getDO());
        return res;
    }

    @Override
    public List<CompanyStoreModel> selectStoreByCondition(BaseinfoCompanyStore store) {
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        if (store == null) {
            return res;
        }
        List<BaseinfoCompanyStore> baseinfoCompanyStores = baseinfoCompanyStoreMapper.selectSelective(store);
        if (CollectionUtils.isEmpty(baseinfoCompanyStores)) {
            return res;
        } else {
            for (BaseinfoCompanyStore obj : baseinfoCompanyStores) {
                res.add(new CompanyStoreModel(obj));
            }
        }
        return res;
    }

    @Override
    public Long addPublicStore(BaseinfoCompanyStore store) {
        if (store == null || store.getCompId() == null) {
            throw new CompanyException(StoreErrorCodeEnum.
                    STORE_ID_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrMsg());
        }
        Integer compId = store.getCompId();
        Long adminPersonId = store.getAdminPersonId();
        Long storeId = 0L;
        //判断公共门店是否已存在
        BaseinfoCompanyStore oldStorParam = new BaseinfoCompanyStore();
        oldStorParam.setStoreName(CompanyConstant.PUBLIC_STORE_NAME);
        oldStorParam.setCompId(compId);
        oldStorParam.setIsPublic(1);
        oldStorParam.setIsDeleted(0);
        List<BaseinfoCompanyStore> oldStores = baseinfoCompanyStoreMapper.selectSelective(oldStorParam);
        if (CollectionUtils.isEmpty(oldStores)) {
            storeId = DistributedPrimaryKeyFactory.generateCompanyStoreId(compId);
            if (storeId == null) {
                throw new CompanyException(StoreErrorCodeEnum.
                        ADD_DEF_STORE_ERROR.getErrCode(),
                        StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
            }
            BaseinfoCompanyStore publicStore = new BaseinfoCompanyStore();
            publicStore.setStoreId(storeId);
            publicStore.setCompId(compId);
            publicStore.setAdminPersonId(adminPersonId);
            publicStore.setStoreName(CompanyConstant.PUBLIC_STORE_NAME);
            publicStore.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
            publicStore.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
            publicStore.setCreateTime(Integer.valueOf(System.currentTimeMillis() / 1000 + ""));
            publicStore.setIsPublic(IsPublicEnum.PUBLIC.getKey());
            publicStore.setExpireDate(CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), OptConstans.DEFAULT_COMPANY_SERVICE_TIME));
            Integer insertStoreNum = baseinfoCompanyStoreMapper.insertSelective(publicStore);
            if (insertStoreNum == 1) {
                return storeId;
            } else {
                throw new CompanyException(StoreErrorCodeEnum.
                        ADD_PUBLIC_STORE_ERROR.getErrCode(),
                        StoreErrorCodeEnum.ADD_PUBLIC_STORE_ERROR.getErrMsg());
            }
        } else {
            return oldStores.get(0).getStoreId();
        }
    }


    @Override
    public List<BaseinfoCompanyStore> queryStoreByStoreName(String storeName, Long compId) {
        if (StringUtil.isEmpty(storeName) || compId == null) {
            return null;
        }
        BaseinfoCompanyStore companyStore = new BaseinfoCompanyStore();
        companyStore.setStoreName(storeName);
        companyStore.setCompId((int) ((long) compId));
        return baseinfoCompanyStoreMapper.queryStoreByStoreName(companyStore);
    }

    @Override
    public List<SalePerformance> queryStorePerformance(SalePerformanceBO bo) {
        if (bo == null) {
            return new ArrayList<>();
        }
        return salePerformanceMapper.selectStorePerformance(bo);
    }

    @Override
    public List<SalePerformance> querySellerPerformance(SalePerformanceBO bo) {
        if (bo == null) {
            return new ArrayList<>();
        }
        return salePerformanceMapper.selectSellerPerformance(bo);
    }

    @Override
    public int insertOrUpdateSalePerformance(SalePerformanceBO record) {
        if (record.getSalePerformanceId() == null || record.getSalePerformanceId().equals(0L)) {
            record.setSalePerformanceId(DistributedPrimaryKeyFactory.generateSalePerformanceId(record.getCompId()));
        }
        return salePerformanceMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int selectShardingSalePerformanceCount(SalePerformanceBO bo) {
        if (bo == null || bo.getYearMonth() == null || bo.getYearMonth().equals(0)) {
            return 0;
        }
        return salePerformanceMapper.selectShardingCount(bo);
    }

    @Override
    public List<SalePerformance> selectShardingSalePerformance(SalePerformanceBO bo) {
        if (bo == null || bo.getYearMonth() == null || bo.getYearMonth().equals(0)) {
            return new ArrayList<>();
        }
        return salePerformanceMapper.selectSharding(bo);
    }

    @Override
    public List<SalePerformance> selectSalePerformanceByCondition(SalePerformanceBO bo) {
        if (bo.getCompId() == null){
            throw new StoreException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        return salePerformanceMapper.selectByCondition(bo);
    }

    @Override
    public List<BaseinfoCompanyStore> selectStoreList(StoreListQueryReqDTO storeListQueryReqDTO) {
        List<BaseinfoCompanyStore> companyStoreList = baseinfoCompanyStoreMapper.selectStoreList(storeListQueryReqDTO);
        if (CollectionUtils.isEmpty(companyStoreList)) {
            return new ArrayList<>();
        }
        return companyStoreList;
    }

    @Override
    public Integer modifyStoreState(StoreInfoBO storeInfoBO) {
        int updateStoreState = baseinfoCompanyStoreMapper.updateStoreState(storeInfoBO);
        return updateStoreState;
    }

    @Override
    public List<StoreInfoBO> queryStorePage(StoreInfoQueryBO bo) {
        return baseinfoCompanyStoreMapper.selectStorePayPage(bo);
    }

    @Override
    public Integer queryStorePageCount(StoreInfoQueryBO bo) {
        return baseinfoCompanyStoreMapper.selectStorePayCount(bo);
    }

    @Override
    public List<BaseinfoCompanyStore> storeNames(StoreInfoBO storeInfoBO) {
        List<BaseinfoCompanyStore> storeNamesList = baseinfoCompanyStoreMapper.queryStoreNames(storeInfoBO);
        return storeNamesList;
    }


    @Override
    public int addStore(BaseinfoCompanyStore companyStore) {
        return baseinfoCompanyStoreMapper.insertSelective(companyStore);
    }

    @Override
    public int addStoreAndStock(BaseinfoCompanyStore companyStore) {
        Boolean success = companyTransactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus status) {
                Integer row = addStore(companyStore);
                if (row <= 0) {
                    return false;
                }
                BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                stock.setStoreName(companyStore.getStoreName());
                stock.setIsDefault(companyStore.getIsDefault());
                stock.setStockName(companyStore.getStoreName() == null ? "默认仓库" : companyStore.getStoreName() + "仓库");
                stock.setAreaId(companyStore.getAreaId());
                stock.setProvince(companyStore.getProvince());
                stock.setCity(companyStore.getCity());
                stock.setZone(companyStore.getZone());
                stock.setAddress(companyStore.getAddress());
                stock.setStockTel(companyStore.getStoreTel());
                stock.setStockLinkman(companyStore.getStoreContact());
                stock.setCompId(companyStore.getCompId());
                stock.setStoreId(companyStore.getStoreId());
                stock.setSort(companyStore.getSort());
                stock.setCreatedAt(companyStore.getCreatedAt());
                stock.setUpdatedAt(companyStore.getUpdatedAt());
                stock.setCreatedPersonId(companyStore.getCreatedPersonId());
                stock.setUpdatedPersonId(companyStore.getUpdatedPersonId());
                stock.setIsDeleted(companyStore.getIsDeleted());
                stock.setIsPublic(companyStore.getIsPublic());
                Integer num = stockService.addStock(stock);
                if (num > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteCompanyStore(BaseinfoCompanyStore baseinfoCompanyStore) {
        return baseinfoCompanyStoreMapper.deleteCompanyStore(baseinfoCompanyStore);
    }

    @Override
    public List<BaseinfoCompanyStore> checkStoreNameIsExist(CheckStoreNameBO checkStoreNameBO) {
        return baseinfoCompanyStoreMapper.checkStoreNameIsExist(checkStoreNameBO);
    }

    @Override
    public boolean isCompanyStoreUsing(CheckCompanyStoreUsingBO checkCompanyStoreUsingBO) {
        long createAt = checkCompanyStoreUsingBO.getCreatedAt();
        Date createAtDate = DateUtil.parseDateYMD(String.valueOf(createAt));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        Date date = calendar.getTime();
        int diffDays = DateUtil.differentDays(createAtDate, date);

        Long expireDateLong = checkCompanyStoreUsingBO.getExpireDateLong();
        Date expireDate = DateUtil.parseDateYMD(String.valueOf(expireDateLong == null ? 0 : expireDateLong));

        ExpireStatusEnum expireStatusEnum = checkCompanyStoreUsingBO.getExpireStatusEnum();
        CompanyWhiteBlackEnum companyWhiteBlackEnum = checkCompanyStoreUsingBO.getCompanyWhiteBlackEnum();

        return ((expireDate != null && DateUtil.differentDays(expireDate,date) < 1)
                || (companyWhiteBlackEnum != null && companyWhiteBlackEnum == CompanyWhiteBlackEnum.WHITE));

    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        Date date = calendar.getTime();
        System.out.println(DateUtil.differentDays(20190128000000L,20181123155800L));


    }
}
