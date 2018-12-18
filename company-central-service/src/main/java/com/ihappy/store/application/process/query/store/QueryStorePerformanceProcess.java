package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.service.outside.trade.OrderSellerReadService;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.store.common.util.Arith;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePerformanceReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.dto.response.store.StorePerformanceRespDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreReadRpcService;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.trade.domain.dto.request.order.OrderPerformanceQueryReqDTO;
import com.ihappy.trade.domain.dto.response.order.OrderPerformanceQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by sunjd on 2018/12/6.
 */
public class QueryStorePerformanceProcess extends DefaultQueryProcess<StorePerformanceReqDTO,StorePerformanceRespDTO> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private CompanyStoreReadRpcService companyStoreReadRpcService;
    @Autowired
    private OrderSellerReadService orderSellerReadService;
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<StorePerformanceReqDTO, StorePerformanceRespDTO> context) {
        StorePerformanceReqDTO reqDTO = context.getParam();
        Map<Long,StorePerformanceRespDTO> storeMap = getStoreMap(reqDTO);
        if (CollectionUtils.isEmpty(storeMap)){
            context.getResult().setModule(null);
            return;
        }
        List<Long> storeIds = getStoreIds(storeMap);
        //设置了业绩的门店列表
        List<Long> aimedStoreIds = addAimAmount(storeMap,storeIds,reqDTO);
        //设置了业绩目标的员工id列表
        List<Long> sellerIds = getSellerIds(aimedStoreIds,reqDTO);
        if (!CollectionUtils.isEmpty(aimedStoreIds) && !CollectionUtils.isEmpty(sellerIds)){
            setPerformance(aimedStoreIds,sellerIds,reqDTO,storeMap);
        }

        //查询公司详情
        BaseinfoCompany param = new BaseinfoCompany();
        param.setCompId(reqDTO.getLoginCompId().intValue());
        param.setIsDeleted(0);
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(param);
        if (baseinfoCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        for (Map.Entry<Long, StorePerformanceRespDTO> entry : storeMap.entrySet()) {
            entry.getValue().setLogoUrl(baseinfoCompany.getCompanyHead());
        }
        context.getResult().setModule(getTotalPerformance(storeMap));
    }

    private StorePerformanceRespDTO getTotalPerformance(Map<Long,StorePerformanceRespDTO> storeMap){
        StorePerformanceRespDTO total = new StorePerformanceRespDTO();
        Long aimAmount = 0L;
        Long dueAmount = 0L;
        for (StorePerformanceRespDTO value : storeMap.values()) {
            aimAmount += value.getAimAmount();
            dueAmount += value.getDueAmount();
        }
        String rate = null;
        if (aimAmount > 0){
            rate = dueAmount == 0?String.valueOf(0): String.valueOf(Arith.div((dueAmount*100)+"",aimAmount.toString(),2));
        }
        total.setDueAmount(dueAmount);
        total.setAimAmount(aimAmount);
        total.setRate(rate);
        return total;
    }

    /**
     * 设置业绩
     * @param aimedStoreIds
     * @param sellerIds
     * @param reqDTO
     * @param storeMap
     */
    private void setPerformance(List<Long> aimedStoreIds,List<Long> sellerIds,StorePerformanceReqDTO reqDTO,Map<Long,StorePerformanceRespDTO> storeMap){
        OrderPerformanceQueryReqDTO param = new OrderPerformanceQueryReqDTO();
        param.setCompId(reqDTO.getLoginCompId());
        param.setConfirmedStartTime(reqDTO.toStartLongDate());
        param.setConfirmedEndTime(reqDTO.toEndLongDate());
        param.setStoreIds(aimedStoreIds);
        param.setOrder("seller_store_id");
        List<OrderPerformanceQueryRespDTO> orderPerformanceList = orderSellerReadService.queryStorePerformance(param);
        if (!CollectionUtils.isEmpty(orderPerformanceList)){
            for (OrderPerformanceQueryRespDTO obj : orderPerformanceList){
                if (obj.getDueAmount() != null){
                    StorePerformanceRespDTO respDTO = storeMap.get(obj.getSellerStoreId());
                    if (respDTO != null){
                        respDTO.setDueAmount(obj.getDueAmount());
                        respDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
                        String rate = respDTO.getDueAmount() == 0?String.valueOf(100): String.valueOf(Arith.div((respDTO.getDueAmount()*100)+"",respDTO.getAimAmount().toString(),2));
                        respDTO.setRate(rate);
                    }
                }
            }
        }
    }

    List<Long> getSellerIds(List<Long> aimedStoreIds,StorePerformanceReqDTO reqDTO){
        List<Long> sellerIds = new ArrayList<Long>();
        SalePerformanceBO bo = new SalePerformanceBO(reqDTO,aimedStoreIds);
        List<SalePerformance> salePerformanceList = companyStoreService.querySellerPerformance(bo);
        if (!CollectionUtils.isEmpty(salePerformanceList)){
            for (SalePerformance obj : salePerformanceList){
                sellerIds.add(obj.getPersonId());
            }
        }
        return sellerIds;
    }

    /**
     * 查询门店业绩目标 并返回设置业绩目标的门店Id列表
     * @param storeMap
     * @param storeIds
     * @param reqDTO
     * @return
     */
    private List<Long> addAimAmount(Map<Long,StorePerformanceRespDTO> storeMap,List<Long> storeIds,StorePerformanceReqDTO reqDTO){
        List<Long> aimedStoreIds = new ArrayList<Long>();
        SalePerformanceBO bo = new SalePerformanceBO(reqDTO,storeIds);
        List<SalePerformance> salePerformanceList = companyStoreService.queryStorePerformance(bo);
        if (!CollectionUtils.isEmpty(salePerformanceList)){
            for (SalePerformance obj : salePerformanceList){
                storeMap.get(obj.getStoreId()).setAimAmount(obj.getAimAmount());
                storeMap.get(obj.getStoreId()).setAimAmountY(AmountUtils.changeF2Y(obj.getAimAmount()));
                //先将销售额设置为0
                storeMap.get(obj.getStoreId()).setDueAmount(0L);
                storeMap.get(obj.getStoreId()).setDueAmountY(AmountUtils.changeF2Y(0L));
                aimedStoreIds.add(obj.getStoreId());
            }
        }
        return aimedStoreIds;
    }

    /**
     * 获取门店id列表
     * @param map
     * @return
     */
    private List<Long> getStoreIds(Map<Long,StorePerformanceRespDTO> map){
        List<Long> storeIds = new ArrayList<Long>();
        for (Long key : map.keySet()) {
            storeIds.add(key);
        }
        return storeIds;
    }

    /**
     * 获取分页后的门店列表
     * @param reqDTO
     * @return
     */
    private Map<Long,StorePerformanceRespDTO> getStoreMap(StorePerformanceReqDTO reqDTO){
        Map<Long,StorePerformanceRespDTO> map = new HashMap<Long,StorePerformanceRespDTO>();
        CompanyStoreListQueryReqDTO param = new CompanyStoreListQueryReqDTO();
        param.setLoginCompId(reqDTO.getLoginCompId());
        param.setCompId(reqDTO.getLoginCompId().intValue());
        param.setLoginPersonId(reqDTO.getLoginPersonId());
        if (reqDTO.getStoreId() != null){
            param.setStoreIds(Arrays.asList(reqDTO.getStoreId()));
        }
        Result<List<CompanyStoreListQueryRespDTO>> result = companyStoreReadRpcService.findStoreListByCompIdAndStoreIds(param);
        if (null != result && !CollectionUtils.isEmpty(result.getModule())){
            List<CompanyStoreListQueryRespDTO> totalList = result.getModule();
            for (int i = 0;i < totalList.size() ;i++){
                //默认业绩值为0
                StorePerformanceRespDTO store = new StorePerformanceRespDTO(0);
                store.setStoreId(totalList.get(i).getStoreId());
                store.setStoreName(totalList.get(i).getStoreName());
                map.put(store.getStoreId(),store);
            }
            return map;
        }
        return new HashMap<>();
    }
}
