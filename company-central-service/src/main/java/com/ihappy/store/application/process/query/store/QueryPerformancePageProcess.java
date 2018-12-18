package com.ihappy.store.application.process.query.store;

import com.ihappy.common.domain.Page;
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
import com.ihappy.store.domain.dto.request.store.CompanyStoreListByUserQueryReqDTO;
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
 * Created by sunjd on 2018/8/27.
 */
public class QueryPerformancePageProcess extends DefaultQueryProcess<StorePerformanceReqDTO,Page<StorePerformanceRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private CompanyStoreReadRpcService companyStoreReadRpcService;
    @Autowired
    private OrderSellerReadService orderSellerReadService;
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<StorePerformanceReqDTO, Page<StorePerformanceRespDTO>> context) {
        StorePerformanceReqDTO reqDTO = context.getParam();
        Integer total = 0;
        Map<Long,StorePerformanceRespDTO> storeMap = getStoreMap(reqDTO,total);
        if (CollectionUtils.isEmpty(storeMap)){
            context.getResult().setModule(new Page<>(1, 10, 0, new ArrayList<>()));
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
        context.getResult().setModule(getPage(storeMap,total));
    }

    private Page<StorePerformanceRespDTO> getPage(Map<Long,StorePerformanceRespDTO> storeMap,Integer total){
        List<StorePerformanceRespDTO> list = new ArrayList<StorePerformanceRespDTO>();
        for (StorePerformanceRespDTO value : storeMap.values()) {
            list.add(value);
        }
        //排序，未设置业绩目标的排前面
        Collections.sort(list, new Comparator<StorePerformanceRespDTO>() {
            @Override
            public int compare(StorePerformanceRespDTO v1, StorePerformanceRespDTO v2) {
                Long a = v1.getAimAmount();
                if (a == null){
                    a = 0L;
                }
                Long b = v2.getAimAmount();
                if (b == null){
                    b = 0L;
                }
                return a.compareTo(b);
            }
        });
        Page<StorePerformanceRespDTO> respDTOPage = new Page(1, 1,total , list);
        return respDTOPage;
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
    private Map<Long,StorePerformanceRespDTO> getStoreMap(StorePerformanceReqDTO reqDTO,Integer total){
        Map<Long,StorePerformanceRespDTO> map = new HashMap<Long,StorePerformanceRespDTO>();
        CompanyStoreListByUserQueryReqDTO param = new CompanyStoreListByUserQueryReqDTO();
        param.setLoginCompId(reqDTO.getLoginCompId());
        param.setLoginPersonId(reqDTO.getLoginPersonId());
        Result<List<CompanyStoreListQueryRespDTO>> result = companyStoreReadRpcService.findStoreListByUser(param);
        if (null != result && !CollectionUtils.isEmpty(result.getModule())){
            List<CompanyStoreListQueryRespDTO> totalList = result.getModule();
            total = totalList.size();
            int limit = reqDTO.getLimit() == null?10:reqDTO.getLimit();
            int offset = reqDTO.getOffset() == null?0:reqDTO.getOffset();
            if (offset >= totalList.size()){
                return new HashMap<>();
            }
            for (int i = offset;i < totalList.size() && i < i+limit;i++){
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
