package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.response.StoreStockListRespDTO;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.stock.domain.dto.request.stock.StockListQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import com.ihappy.store.domain.bo.store.QueryStoreListByCompIdAndStoreIdsBO;
import com.ihappy.store.domain.dto.response.store.StoreRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/13.
 */
public class QueryStoreStockListProcess extends DefaultQueryProcess<StockListQueryReqDTO,StockListQueryRespDTO> {
    @Autowired
    private StockService stockService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<StockListQueryReqDTO, StockListQueryRespDTO> context) {
        StockListQueryReqDTO stockListQueryReqDTO = context.getParam();
        Long personId = stockListQueryReqDTO.personId();
        Integer compId = Integer.parseInt(stockListQueryReqDTO.userCompId().toString());
        String stockName = stockListQueryReqDTO.getStockName();
        Integer forbidden = stockListQueryReqDTO.getForbidden();
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
        List<CompanyStockModel> publicStocks = stockService.findPublicStockListByCompId(compId,stockName,forbidden);
        //本公司超级管理员
        if(company.getAdminPersonId() != null && company.getAdminPersonId().equals(personId)){
            stores = companyStoreService.findStoreListByCompId(compId);
            notPublicStocks = stockService.findNotPublicStockListByCompId(compId,stockName,forbidden);
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
                QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO=new QueryStoreListByCompIdAndStoreIdsBO();
                queryStoreListByCompIdAndStoreIdsBO.setCompId(compId);
                queryStoreListByCompIdAndStoreIdsBO.setStoreIds(storeIds);
                queryStoreListByCompIdAndStoreIdsBO.setAvailable(null);
                stores = companyStoreService.findValidStoreListByCompIdAndStoreIds(queryStoreListByCompIdAndStoreIdsBO);
                notPublicStocks = stockService.findNotPublicStockListByCompIdAndStoreIds(compId,storeIds,stockName,forbidden);
            }else{
                //用户无门店权限
            }
        }
        StockListQueryRespDTO result = new StockListQueryRespDTO();
        //公共仓库
        StoreStockListRespDTO publicStockList = new StoreStockListRespDTO();
        StoreRespDTO publicStore = new StoreRespDTO();
        publicStore.setStoreName(OptConstans.PUBLIC_STOCK_NAME);
        publicStockList.setStore(publicStore);
        List<StockRespDTO> publicStockRespDTOs = CompanyStockFactory.modelListToStockRespDTOList(publicStocks);
        publicStockList.setStocks(publicStockRespDTOs);
        result.setPublicStock(publicStockList);
        //非公共仓库
        List<StoreStockListRespDTO> storeStocks = new ArrayList<StoreStockListRespDTO>();
        if(!CollectionUtils.isEmpty(stores) && !CollectionUtils.isEmpty(notPublicStocks)){
            Map<Long,List<CompanyStockModel>> notPublicSockMap = new HashMap<>(OptConstans.MAP_INITIALCAPACITY);
            for (CompanyStockModel obj : notPublicStocks){
                Long storeId = obj.getDO().getStoreId();
                if (notPublicSockMap.get(storeId) != null){
                    notPublicSockMap.get(storeId).add(obj);
                }else{
                    List<CompanyStockModel> newStockList = new ArrayList<CompanyStockModel>();
                    newStockList.add(obj);
                    notPublicSockMap.put(storeId,newStockList);
                }
            }
            for (CompanyStoreModel obj : stores){
                Long storeId = obj.getDO().getStoreId();
                if(!CollectionUtils.isEmpty(notPublicSockMap.get(storeId))){
                    StoreStockListRespDTO storeStock = new StoreStockListRespDTO();
                    storeStock.setStore(CompanyStoreFactory.modelToStoreRespDTO(obj));
                    storeStock.setStocks(CompanyStockFactory.modelListToStockRespDTOList(notPublicSockMap.get(storeId)));
                    storeStocks.add(storeStock);
                }
            }
        }
        result.setStoreStocks(storeStocks);
        context.getResult().setModule(result);
    }
}
