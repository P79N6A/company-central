package com.ihappy.stock.infrastructure.service.inside.impl;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.IsPublicEnum;
import com.ihappy.company.common.enumtype.company.IsDefaultEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.bo.stock.StockBO;
import com.ihappy.stock.domain.bo.stock.StockInfoByPersonRoleDO;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import com.ihappy.store.domain.bo.store.QueryStoreListByCompIdAndStoreIdsBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/4/16.
 */
public class StockServiceImpl implements StockService {

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public int addStock(BaseinfoCompanyStock stock) {
        if (stock == null || stock.getCompId() == null || stock.getCompId() == 0 || stock.getStoreId() == null || stock.getStoreId() == 0){
            return 0;
        }
        Long stockId = DistributedPrimaryKeyFactory.generateCompanyStockId(stock.getCompId());
        stock.setStockId(stockId);
        return baseinfoCompanyStockMapper.insertSelective(stock);
    }

    @Override
    public Boolean addDefStockAndPublicDefStock(CompanyStockModel model) {
        if (model == null || model.getDO() == null || model.getDO().getCompId() == null || model.getDO().getStoreId() == null){
            return false;
        }
        Integer compId = model.getDO().getCompId();
        Long storeId = model.getDO().getStoreId();
        Long stockId = null;

        //添加总店
        BaseinfoCompanyStore publicStore = new BaseinfoCompanyStore();
        publicStore.setStoreId(storeId);
        publicStore.setCompId(compId);
        publicStore.setAdminPersonId(model.getDO().getCreatedPersonId());
        Long publicStoreId = companyStoreService.addPublicStore(publicStore);
        if (publicStoreId != null && publicStoreId != 0L){
            //判断默认公共仓库是否已存在
            BaseinfoCompanyStock oldPalicStockParam = new BaseinfoCompanyStock();
            oldPalicStockParam.setStockName(CompanyConstant.DEFAULT_PUBLIC_STOCK_NAME);
            oldPalicStockParam.setCompId(compId);
            oldPalicStockParam.setIsPublic(1);
            oldPalicStockParam.setIsDeleted(0);
            List<BaseinfoCompanyStock> oldPublicStocks = baseinfoCompanyStockMapper.selectByConditionSelective(oldPalicStockParam);

            if (!CollectionUtils.isEmpty(oldPublicStocks)){
                for (BaseinfoCompanyStock obj : oldPublicStocks){
                    if (!CompanyConstant.DEFAULT_PUBLIC_STORE_STOCK_NAME.equals(obj.getStockName())){
                        BaseinfoCompanyStock oldPublicStockUpdateParam = new BaseinfoCompanyStock();
                        oldPublicStockUpdateParam.setStockName(CompanyConstant.DEFAULT_PUBLIC_STORE_STOCK_NAME);
                        oldPublicStockUpdateParam.setStockId(obj.getStockId());
                        oldPublicStockUpdateParam.setStoreId(publicStoreId);
                        oldPublicStockUpdateParam.setIsDefault(IsDefaultEnum.NOT_DEFAULT.getKey());
                        oldPublicStockUpdateParam.setIsPublic(IsPublicEnum.PUBLIC.getKey());
                        oldPublicStockUpdateParam.setCompId(compId);
                        baseinfoCompanyStockMapper.updateByPrimaryKeySelective(oldPublicStockUpdateParam);
                    }
                }
            }else {
                oldPalicStockParam.setStockName(CompanyConstant.DEFAULT_PUBLIC_STORE_STOCK_NAME);
                List<BaseinfoCompanyStock> oldPublicStoreStocks = baseinfoCompanyStockMapper.selectByConditionSelective(oldPalicStockParam);
                if (CollectionUtils.isEmpty(oldPublicStoreStocks)){
                    BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                    stockId = DistributedPrimaryKeyFactory.generateCompanyStockId(compId);
                    stock.setCompId(compId);
                    stock.setStoreId(publicStoreId);
                    stock.setStockId(stockId);
                    stock.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
                    stock.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                    //添加总仓
                    stock.setStockName(CompanyConstant.DEFAULT_PUBLIC_STORE_STOCK_NAME);
                    stock.setIsPublic(IsPublicEnum.PUBLIC.getKey());
                    Integer insertNum = baseinfoCompanyStockMapper.insertSelective(stock);
                    if (insertNum != 1){
                        throw new CompanyException(StockErrorCodeEnum.
                                ADD_DEF_STOCK_ERROR.getErrCode(),
                                StockErrorCodeEnum.ADD_DEF_STOCK_ERROR.getErrMsg());
                    }
                }
            }
        }

        //判断默认仓库是否存在
        BaseinfoCompanyStock oldStockParam = new BaseinfoCompanyStock();
        oldStockParam.setStockName(CompanyConstant.DEFAULT_STOCK_NAME);
        oldStockParam.setCompId(compId);
        oldStockParam.setIsPublic(0);
        oldStockParam.setStoreId(storeId);
        oldStockParam.setIsDeleted(0);
        List<BaseinfoCompanyStock> oldStocks = baseinfoCompanyStockMapper.selectByConditionSelective(oldStockParam);
        if (!CollectionUtils.isEmpty(oldStocks)){
            for (BaseinfoCompanyStock obj : oldStocks){
                if (!obj.getIsDefault().equals(IsDefaultEnum.DEFAULT.getKey())){
                    BaseinfoCompanyStock oldStockUpdateParam = new BaseinfoCompanyStock();
                    oldStockUpdateParam.setStockId(obj.getStockId());
                    oldStockUpdateParam.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
                    oldStockUpdateParam.setCompId(compId);
                    baseinfoCompanyStockMapper.updateByPrimaryKeySelective(oldStockUpdateParam);
                }
            }
        }else {
            BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
            stockId = DistributedPrimaryKeyFactory.generateCompanyStockId(compId);
            stock.setCompId(compId);
            stock.setStoreId(storeId);
            stock.setStockId(stockId);
            stock.setStockName(CompanyConstant.DEFAULT_STOCK_NAME);
            stock.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
            stock.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
            stock.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
            //添加默认仓库
            Integer insertNum = baseinfoCompanyStockMapper.insertSelective(stock);
            if (insertNum != 1){
                throw new CompanyException(StockErrorCodeEnum.
                        ADD_DEF_STOCK_ERROR.getErrCode(),
                        StockErrorCodeEnum.ADD_DEF_STOCK_ERROR.getErrMsg());
            }
        }
        return true;
    }

    @Override
    public Boolean addDefStock(CompanyStockModel model) {
        if (model == null || model.getDO() == null || model.getDO().getCompId() == null || model.getDO().getStoreId() == null){
            return false;
        }
        Integer compId = model.getDO().getCompId();
        Long storeId = model.getDO().getStoreId();
        Long stockId = DistributedPrimaryKeyFactory.generateCompanyStockId(compId);
        BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
        stock.setCompId(compId);
        stock.setStoreId(storeId);
        stock.setStockId(stockId);
        stock.setStockName(CompanyConstant.DEFAULT_STOCK_NAME);
        stock.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
        stock.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        stock.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        Integer insertNum = baseinfoCompanyStockMapper.insertSelective(stock);
        if (insertNum != 1){
            throw new CompanyException(StockErrorCodeEnum.
                    ADD_DEF_STOCK_ERROR.getErrCode(),
                    StockErrorCodeEnum.ADD_DEF_STOCK_ERROR.getErrMsg());
        }
        return true;
    }

    @Override
    public Boolean addPublicStock(CompanyStockModel model) {
        if (model == null || model.getDO() == null || model.getDO().getCompId() == null || model.getDO().getStoreId() == null){
            return false;
        }
        Integer compId = model.getDO().getCompId();
        Long publicStoreId = model.getDO().getStoreId();
        Long stockId = null;

        if (publicStoreId != null && publicStoreId != 0L){
            //判断默认公共仓库是否已存在
            BaseinfoCompanyStock oldPalicStockParam = new BaseinfoCompanyStock();
            oldPalicStockParam.setStockName(CompanyConstant.DEFAULT_PUBLIC_STOCK_NAME);
            oldPalicStockParam.setCompId(compId);
            oldPalicStockParam.setIsPublic(1);
            oldPalicStockParam.setIsDeleted(0);
            oldPalicStockParam.setStoreId(publicStoreId);
            List<BaseinfoCompanyStock> oldPublicStocks = baseinfoCompanyStockMapper.selectByConditionSelective(oldPalicStockParam);

            if (!CollectionUtils.isEmpty(oldPublicStocks)){
                return true;
            }else {
                BaseinfoCompanyStock stock = new BaseinfoCompanyStock();
                stockId = DistributedPrimaryKeyFactory.generateCompanyStockId(compId);
                stock.setCompId(compId);
                stock.setStoreId(publicStoreId);
                stock.setStockId(stockId);
                stock.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
                stock.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                //添加总仓
                stock.setStockName(CompanyConstant.DEFAULT_PUBLIC_STORE_STOCK_NAME);
                stock.setIsPublic(IsPublicEnum.PUBLIC.getKey());
                Integer insertNum = baseinfoCompanyStockMapper.insertSelective(stock);
                if (insertNum != 1){
                    throw new CompanyException(StockErrorCodeEnum.
                            ADD_DEF_STOCK_ERROR.getErrCode(),
                            StockErrorCodeEnum.ADD_DEF_STOCK_ERROR.getErrMsg());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CompanyStockModel> findStockListByConditon(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)){
            return new ArrayList<>();
        }
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectStockListByConditon(map);
        if (CollectionUtils.isEmpty(stocks)){
            return new ArrayList<>();
        }
        List<CompanyStockModel> models = new ArrayList<CompanyStockModel>();
        for (BaseinfoCompanyStock obj : stocks){
            models.add(new CompanyStockModel(obj));
        }
        return models;
    }

    @Override
    public List<CompanyStockModel> findStockListByConditonWithStoreInfo(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)){
            return new ArrayList<>();
        }
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.findStockListByConditonWithStoreInfo(map);
        if (CollectionUtils.isEmpty(stocks)){
            return new ArrayList<>();
        }
        List<CompanyStockModel> models = new ArrayList<CompanyStockModel>();
        for (BaseinfoCompanyStock obj : stocks){
            models.add(new CompanyStockModel(obj));
        }
        return models;
    }

    @Override
    public List<CompanyStockModel> findStockListByStoreIdList(Map<String, Object> map) {
        List<CompanyStockModel> models = new ArrayList<CompanyStockModel>();
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectStockListByStoreIdList(map);
        if (CollectionUtils.isEmpty(stocks)){
            return new ArrayList<>();
        }
        Map<Long,CompanyStoreModel> storeMap = companyStoreService.findStoreMapByCompIdAndStoreIds(map);
        for (BaseinfoCompanyStock obj : stocks){
            if (storeMap.get(obj.getStoreId()) != null){
                obj.setStoreName(storeMap.get(obj.getStoreId()).getDO().getStoreName());
            }
        }
        stocks.forEach((obj)->{
            models.add(new CompanyStockModel(obj));
        });
        return models;
    }

    @Override
    public List<CompanyStockModel> findNotPublicStockListByCompIdAndStoreIds(Integer compId, List<Long> storeIds,String stockName,Integer forbidden) {
        if(storeIds == null || storeIds.size() == 0 || compId == null){
            return new ArrayList<CompanyStockModel>();
        }
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectNotPublicStockListByCompIdAndStoreIds(compId,storeIds,stockName,forbidden);
        if (CollectionUtils.isEmpty(stocks)) {
            return new ArrayList<>();
        }
        return transform(stocks, (stock) -> new CompanyStockModel(stock));
    }

    @Override
    public List<CompanyStockModel> findNotPublicStockListByCompId(Integer compId,String stockName,Integer forbidden) {
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectNotPublicStockListByCompId(compId,stockName,forbidden);
        if (CollectionUtils.isEmpty(stocks)) {
            return new ArrayList<>();
        }
        return transform(stocks, (stock) -> new CompanyStockModel(stock));
    }

    @Override
    public List<CompanyStockModel> findPublicStockListByCompId(Integer compId,String stockName,Integer forbidden) {
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectPublicStockListByCompId(compId,stockName,forbidden);
        if (CollectionUtils.isEmpty(stocks)) {
            return new ArrayList<>();
        }
        return transform(stocks, (stock) -> new CompanyStockModel(stock));
    }

    @Override
    public List<CompanyStockModel> findStockListByIds(List<Long> stockIds) {
        if (CollectionUtils.isEmpty(stockIds)){
            return new ArrayList<>();
        }
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("stockIds",stockIds);
        List<BaseinfoCompanyStock> stocks = baseinfoCompanyStockMapper.selectStockListByIds(paramMap);
        return transform(stocks, (stock) -> new CompanyStockModel(stock));
    }

    @Override
    public Integer updateStockInventorying(StockBO stockBO) {
        if (CollectionUtils.isEmpty(stockBO.getStockIds()) || null == stockBO.getStockIds()){
            return 0;
        }
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("stockIds",stockBO.getStockIds());
        paramMap.put("stockChangeId",stockBO.getInventorying());
        paramMap.put("updatedAt",CompanyDateUtil.getDate14Long(new Date()));
        Integer res = baseinfoCompanyStockMapper.updateStockInventorying(paramMap);
        return res;
    }

    @Override
    public Integer clearStockInventorying(StockBO stockBO) {
        if (CollectionUtils.isEmpty(stockBO.getStockChangeIds()) || null == stockBO.getCompId()){
            return 0;
        }
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("compId",stockBO.getCompId());
        paramMap.put("stockIds",stockBO.getStockIds());
        paramMap.put("updatedAt",CompanyDateUtil.getDate14Long(new Date()));
        paramMap.put("stockChangeIds",stockBO.getStockChangeIds());
        Integer res = baseinfoCompanyStockMapper.clearStockInventorying(paramMap);
        return res;
    }

    @Override
    public List<StockBasicInfoRespDTO> getStockListByPersonRole(StockInfoByPersonRoleDO stockInfoByPersonRoleDO) {
        Long personId = stockInfoByPersonRoleDO.getLoginPersonId();
        Integer compId = stockInfoByPersonRoleDO.getLoginCompId();
        Integer forbidden = 0;
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if (company == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        //门店id列表
        List<Long> storeIds = new ArrayList<Long>();
        //门店列表
        List<CompanyStoreModel> stores = null;
        //非公共仓库列表
        List<CompanyStockModel> notPublicStocks = null;
        //公共仓库列表
        List<CompanyStockModel> publicStocks = findPublicStockListByCompId(compId,null,forbidden);
        QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO= new QueryStoreListByCompIdAndStoreIdsBO();
        queryStoreListByCompIdAndStoreIdsBO.setCompId(compId);
        queryStoreListByCompIdAndStoreIdsBO.setAvailable(2);
        //本公司超级管理员
        if(company.getAdminPersonId() != null && company.getAdminPersonId().equals(personId)){
            stores = companyStoreService.findValidStoreListByCompIdAndStoreIds(queryStoreListByCompIdAndStoreIdsBO);
        }else{
            //通过redis获取用户信息
            BaseinfoPersonCompanyOrgRespDTO userinfo = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(Long.parseLong(compId.toString()),personId, ConfigCenterUtil.ENV);
            if(userinfo == null){
                throw new CompanyException(CompanyErrorCodeEnum.
                        GET_USER_INFO_ERROR.getErrCode(),
                        CompanyErrorCodeEnum.GET_USER_INFO_ERROR.getErrMsg());
            }
            List<StoreInfoRespDTO> storeInfoRespDTO = userinfo.getStoreInfoList();
            if(!CollectionUtils.isEmpty(storeInfoRespDTO)){
                for(StoreInfoRespDTO obj : storeInfoRespDTO){
                    storeIds.add(Long.parseLong(obj.getStoreId()+""));
                }
                queryStoreListByCompIdAndStoreIdsBO.setStoreIds(storeIds);
                stores = companyStoreService.findValidStoreListByCompIdAndStoreIds(queryStoreListByCompIdAndStoreIdsBO);
            }else{
                //用户无门店权限
            }
        }
        if(!CollectionUtils.isEmpty(stores)){
            List<Long> storeIdList = new ArrayList<Long>();
            for(CompanyStoreModel companyStoreModel : stores){
                storeIdList.add(companyStoreModel.getStoreId());
            }
            notPublicStocks = findNotPublicStockListByCompIdAndStoreIds(compId,storeIdList,null,forbidden);
        }
        List<StockBasicInfoRespDTO> stockList = new ArrayList<>();
        //公共仓库
        if(!CollectionUtils.isEmpty(publicStocks)){
            for (CompanyStockModel obj : publicStocks){
                StockBasicInfoRespDTO stockBasicInfoRespDTO = new StockBasicInfoRespDTO();
                stockBasicInfoRespDTO.setCompId(obj.getDO().getCompId());
                stockBasicInfoRespDTO.setIsPublic(obj.getDO().getIsPublic());
                stockBasicInfoRespDTO.setStockId(obj.getDO().getStockId());
                stockBasicInfoRespDTO.setStockName(obj.getDO().getStockName());
                stockBasicInfoRespDTO.setStockNo(obj.getDO().getStockNo());
                stockBasicInfoRespDTO.setStoreId(obj.getDO().getStoreId());
                stockBasicInfoRespDTO.setStoreName(obj.getDO().getStockName());
                stockList.add(stockBasicInfoRespDTO);
            }
        }
        //非公共仓库
        if(!CollectionUtils.isEmpty(notPublicStocks)){
            for (CompanyStockModel obj : notPublicStocks){
                StockBasicInfoRespDTO stockBasicInfoRespDTO = new StockBasicInfoRespDTO();
                stockBasicInfoRespDTO.setCompId(obj.getDO().getCompId());
                stockBasicInfoRespDTO.setIsPublic(obj.getDO().getIsPublic());
                stockBasicInfoRespDTO.setStockId(obj.getDO().getStockId());
                stockBasicInfoRespDTO.setStockName(obj.getDO().getStockName());
                stockBasicInfoRespDTO.setStockNo(obj.getDO().getStockNo());
                stockBasicInfoRespDTO.setStoreId(obj.getDO().getStoreId());
                stockBasicInfoRespDTO.setStoreName(obj.getDO().getStockName());
                stockList.add(stockBasicInfoRespDTO);
            }
        }
        return stockList;
    }

    @Override
    public List<CompanyStockModel> findByConditionSelective(CompanyStockModel condition) {
        if (condition == null || condition.getDO() == null){
            return new ArrayList<>();
        }
        List<BaseinfoCompanyStock> list = baseinfoCompanyStockMapper.selectByConditionSelective(condition.getDO());
        List<CompanyStockModel> models = new ArrayList<CompanyStockModel>();
        list.forEach((obj) -> models.add(new CompanyStockModel(obj)));
        return models;
    }
}
