package com.ihappy.store.infrastructure.service.inside;

import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.bo.store.*;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.StoreListQueryReqDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/10.
 */
public interface CompanyStoreService {
    /**
     * 添加默认门店，同时在门店下添加默认仓库
     * 参数
     * compId
     * adminPersonId
     * @param model
     * @return
     */
    Boolean addDefStore(CompanyStoreModel model);

    /**
     * 添加公共门店（总店）
     * @param model
     * @return
     */
    Boolean addPublicStoreAndStock(CompanyStoreModel model);

    /**
     * 新增门店
     * @param companyStore
     * @return
     */
    int addStore(BaseinfoCompanyStore companyStore);

    /**
     * 新增门店，并且增加仓库
     * @param companyStore
     * @return
     */
    int addStoreAndStock(BaseinfoCompanyStore companyStore);

    /**
     * 根据门店id列表查询
     * @param map
     * @return
     */
    Map<Long,CompanyStoreModel> selectByStoreIds(Map<String,Object> map);

    /**
     * 根据 公司id和门店id列表查询 门店列表
     * @param compId  必须 storeIds 门店id列表  isPublic null 所有 0：不查询总店 1：只查询总店
     * @return
     */
    List<CompanyStoreModel> findStoreListByCompIdAndStoreIds(Map<String, Object> map);

    /**
     * 根据 公司id和门店id列表查询 门店列表
     * @param compId  必须 storeIds 门店id列表  isPublic null 所有 0：不查询总店 1：只查询总店
     * @return
     */
    Map<Long,CompanyStoreModel> findStoreMapByCompIdAndStoreIds(Map<String, Object> map);

    /**
     * 查询门店信息
     * @param storeInfoQueryBO
     * @return
     */
    List<CompanyStoreModel> queryStoreInfoByInfoList(StoreInfoQueryBO storeInfoQueryBO);

    /**
     * 过滤服务已到期门店
     * @return
     */
    List<CompanyStoreModel> findValidStoreListByCompIdAndStoreIds(QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO);

    List<CompanyStoreModel> findStoreListByCompId(Integer compId);

    /**
     *过滤已过期门店
     * @param compId
     * @return
     */
    List<CompanyStoreModel> findValidStoreListByCompId(Integer compId);

    /**
     * 过滤掉已过期的门店
     * @param baseinfoCompanyStores
     * @return
     */
    //List<CompanyStoreModel> filterValidStoreList(List<BaseinfoCompanyStore> baseinfoCompanyStores);

    /**
     * 修改打印ip和端口
     * @param model
     * @return
     */
    Integer updatePrintIpAndPort(CompanyStoreModel model);

    /**
     * 查询门店
     * @param model
     * @return
     */
    CompanyStoreModel findByStoreIdAndCompId(CompanyStoreModel model);

     /**
       * @Description: 判断门店是否过期  由于过期改为公司，故门店过期功能作废
       * @Param:
       * @return:
       * @Author: zhangtengpo
       * @Date: 2018/6/11
       */
    Boolean validateStore(BaseinfoCompanyStore baseinfoCompanyStore);

    /**
     * 根据门店id查询门店
     * @param storeId
     * @return
     */
    CompanyStoreModel findStoreById(Long storeId);

    /**
     * 根据id修改门店信息
     * @param store
     * @return
     */
    Integer updateByIdSelective(CompanyStoreModel store);

    /**
     * 根据条件查询门店列表
     * @param store
     * @return
     */
    List<CompanyStoreModel> selectStoreByCondition(BaseinfoCompanyStore store);

    /**
     * 添加总店-返回门店id
     * 入参
     * 公司id为必需
     * @return
     */
    Long addPublicStore(BaseinfoCompanyStore store);


    /**
     *   根据门店名称查询门店信息
     * @param storeName
     * @param compId
     * @return
     */
    List<BaseinfoCompanyStore> queryStoreByStoreName(String storeName,Long compId);

    /**
     * 根据门店名称查询门店信息
     * @param baseinfoCompanyStore
     * @return
     */
    int deleteCompanyStore(BaseinfoCompanyStore baseinfoCompanyStore);

    /**
     * 门店名称是否重复
     * @param checkStoreNameBO
     * @return
     */
    List<BaseinfoCompanyStore> checkStoreNameIsExist(CheckStoreNameBO checkStoreNameBO);

    /**
     * 查询门店 当月绩效目标
     * @param bo compId,yearMonth,storeIds
     * @return
     */
    List<SalePerformance> queryStorePerformance(SalePerformanceBO bo);

    /**
     * 查询员工业绩目标
     * @param bo compId,yearMonth,storeIds
     * @return
     */
    List<SalePerformance> querySellerPerformance(SalePerformanceBO bo);

    /**
     * 插入更新
     * @param record
     * @return
     */
    int insertOrUpdateSalePerformance(SalePerformanceBO record);

    /**
     * 分表计数
     * @param bo
     * @return
     */
    int selectShardingSalePerformanceCount(SalePerformanceBO bo);

    /**
     * 分表查询
     * @param bo
     * @return
     */
    List<SalePerformance> selectShardingSalePerformance(SalePerformanceBO bo);

    /**
     * @Author sunjd
     * @Description 根据条件查询业绩
     * @Date 14:50 2018/11/3
     * @Param [bo]
     * @return java.util.List<com.ihappy.store.domain.dbdo.performance.SalePerformance>
     **/
    List<SalePerformance> selectSalePerformanceByCondition(SalePerformanceBO bo);
    /**
     * 查询门店列表
     */
    List<BaseinfoCompanyStore> selectStoreList(StoreListQueryReqDTO storeListQueryReqDTO);
    /**
     * 根据门店id更新门店状态
     * @param
     * @return
     */
    Integer modifyStoreState(StoreInfoBO  storeInfoBO);

    /**
     * @Author sunjd
     * @Description 查询门店分页列表
     * @Date 12:56 2018/10/17
     * @Param []
     * @return java.util.List<com.ihappy.store.domain.bo.store.StoreInfoBO>
     **/
    List<StoreInfoBO> queryStorePage(StoreInfoQueryBO bo);
    /**
     * @Author sunjd
     * @Description 查询门店分页列表计数
     * @Date 12:57 2018/10/17
     * @Param []
     * @return java.lang.Integer
     **/
    Integer queryStorePageCount(StoreInfoQueryBO bo);

    List<BaseinfoCompanyStore> storeNames(StoreInfoBO reqToStoreInfoBO);

    /**
     * 判断门店是否是使用中，判断逻辑
     *                 // case 1: 以下情况，满足其中一种，则 true -使用中
     *                 //              1.1 若在试用期之内（nowTime - createdAt < 15)，
     * //                              1.2 若门店已付费（expireStatus == 1） 且当前时间未超过过期时间（expireDate）
     * //                              1.3 公司 status = 2（白名单)
     *                 // case 2: 其他情况为, false -待续费
     * @param checkCompanyStoreUsingBO
     * @return
     */
    boolean isCompanyStoreUsing(CheckCompanyStoreUsingBO checkCompanyStoreUsingBO);
}
