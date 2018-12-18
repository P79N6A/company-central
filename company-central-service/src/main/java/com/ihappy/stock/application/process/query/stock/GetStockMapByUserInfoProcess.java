package com.ihappy.stock.application.process.query.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.stock.domain.dto.request.stock.StockMapByUserInfoQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
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
 * Created by sunjd on 2018/5/23.
 */
public class GetStockMapByUserInfoProcess extends DefaultQueryProcess<StockMapByUserInfoQueryReqDTO,StockListByStoreIdsQueryRespDTO> {
    @Autowired
    private StockService stockService;
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StockMapByUserInfoQueryReqDTO, StockListByStoreIdsQueryRespDTO> context) {
        StockMapByUserInfoQueryReqDTO reqDTO = context.getParam();
        Long personId = reqDTO.getPersonId();
        Integer compId = Integer.valueOf(reqDTO.getCompId().toString());
        Integer isPublic = reqDTO.getIsPublic();
        Integer forbidden = reqDTO.getForbidden();
        Boolean filterUnvalidStore = reqDTO.getFilterUnvalidStore();
        //门店id列表
        List<Long> storeIds = new ArrayList<Long>();

        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if (company == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        //非公司管理员需要获取门店权限列表
        if(company.getAdminPersonId() != null && !company.getAdminPersonId().equals(personId)){
            //通过redis获取用户信息
            BaseinfoPersonCompanyOrgRespDTO userinfo = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(Long.parseLong(compId.toString()),personId, ConfigCenterUtil.ENV);
            List<StoreInfoRespDTO> storeInfoRespDTO = userinfo.getStoreInfoList();
            if (!CollectionUtils.isEmpty(storeInfoRespDTO)){
                for (StoreInfoRespDTO obj : storeInfoRespDTO){
                    storeIds.add(Long.valueOf(obj.getStoreId()));
                }
            }else {
                throw new CompanyException(StoreErrorCodeEnum.
                        NO_STORE_FIND.getErrCode(),
                        StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
            }
        }

        if (filterUnvalidStore != null && filterUnvalidStore){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("compId",compId);
            map.put("storeIds",storeIds);
            List<CompanyStoreModel> storeModels = companyStoreService.findStoreListByCompIdAndStoreIds(map);
            if (!CollectionUtils.isEmpty(storeModels)){
                List<BaseinfoCompanyStore> unFilterStores = new ArrayList<BaseinfoCompanyStore>();
                for (CompanyStoreModel obj : storeModels){
                    unFilterStores.add(obj.getDO());
                }
                List<CompanyStoreModel> filterStores = CompanyStoreFactory.list2ModeList(unFilterStores);
                if (CollectionUtils.isEmpty(filterStores)){
                    throw new CompanyException(StoreErrorCodeEnum.
                            NO_STORE_FIND.getErrCode(),
                            StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
                }
                storeIds = new ArrayList<Long>();
                for (CompanyStoreModel obj : filterStores){
                    storeIds.add(obj.getDO().getStoreId());
                }
            }
        }

        Map<String,Object> paraMap = new HashMap<String,Object>();
        paraMap.put("compId",compId);
        paraMap.put("isPublic",isPublic);
        paraMap.put("forbidden",forbidden);
        paraMap.put("storeIds",storeIds);
        List<CompanyStockModel> stockModels = stockService.findStockListByConditon(paraMap);

        StockListByStoreIdsQueryRespDTO respDTO = new StockListByStoreIdsQueryRespDTO();
        Map<Long,List<StockRespDTO>> storeStocks = new HashMap<Long,List<StockRespDTO>>();
        for (CompanyStockModel obj : stockModels){
            StockRespDTO stockRespDTO = CompanyStockFactory.modelToStockRespDTO(obj);
            if (storeStocks.get(stockRespDTO.getStoreId()) == null){
                List<StockRespDTO> stockRespDTOList = new ArrayList<StockRespDTO>();
                stockRespDTOList.add(stockRespDTO);
                storeStocks.put(stockRespDTO.getStoreId(),stockRespDTOList);
            }else {
                storeStocks.get(stockRespDTO.getStoreId()).add(stockRespDTO);
            }
        }
        respDTO.setStoreStocks(storeStocks);

        context.getResult().setModule(respDTO);
    }
}
