package com.ihappy.store.application.process.query.store;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.service.outside.trade.OrderSellerReadService;
import com.ihappy.communal.infrastructure.service.outside.user.UserInfoOutSideService;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.company.domain.dto.request.user.UserInfoReqDTO;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.common.util.Arith;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dto.request.store.PersonPerformanceReqDTO;
import com.ihappy.store.domain.dto.response.store.PersonPerformanceRespDTO;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.trade.domain.dto.request.order.OrderPerformanceQueryReqDTO;
import com.ihappy.trade.domain.dto.response.order.OrderPerformanceQueryRespDTO;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by sunjd on 2018/8/29.
 */
public class QueryPersonPerformancePageProcess extends DefaultQueryProcess<PersonPerformanceReqDTO,Page<PersonPerformanceRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private OrderSellerReadService orderSellerReadService;
    @Autowired
    private UserInfoOutSideService userInfoOutSideService;
    private Integer total = 0;
    @Override
    public void process(Context<PersonPerformanceReqDTO, Page<PersonPerformanceRespDTO>> context) {
        PersonPerformanceReqDTO reqDTO = context.getParam();
        List<Long> sellerIds = new ArrayList<Long>();
        Map<Long,PersonPerformanceRespDTO> personMap = getPersonMap(reqDTO,sellerIds);

        if (!CollectionUtils.isEmpty(sellerIds)){
            setPerformance(personMap,reqDTO,sellerIds);
        }
        context.getResult().setModule(getPage(personMap));
    }

    private Page<PersonPerformanceRespDTO> getPage(Map<Long,PersonPerformanceRespDTO> personMap){
        List<PersonPerformanceRespDTO> list = new ArrayList<PersonPerformanceRespDTO>();
        for (PersonPerformanceRespDTO value : personMap.values()) {
            list.add(value);
        }
        //排序，未设置业绩目标的排前面
        Collections.sort(list, new Comparator<PersonPerformanceRespDTO>() {
            @Override
            public int compare(PersonPerformanceRespDTO v1, PersonPerformanceRespDTO v2) {
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
        Page<PersonPerformanceRespDTO> respDTOPage = new Page(1, 1,total , list);
        return respDTOPage;
    }

    private void setPerformance(Map<Long,PersonPerformanceRespDTO> personMap,PersonPerformanceReqDTO reqDTO,List<Long> sellerIds){
        OrderPerformanceQueryReqDTO param = new OrderPerformanceQueryReqDTO();
        param.setCompId(reqDTO.getLoginCompId());
        param.setConfirmedStartTime(reqDTO.toStartLongDate());
        param.setConfirmedEndTime(reqDTO.toEndLongDate());
        param.setPersonIds(sellerIds);
        param.setStoreIds(Arrays.asList(reqDTO.getStoreId()));
        param.setOrder("seller_id");
        List<OrderPerformanceQueryRespDTO> orderPerformanceList = orderSellerReadService.queryStorePerformance(param);
        if (!CollectionUtils.isEmpty(orderPerformanceList)){
            for (OrderPerformanceQueryRespDTO obj : orderPerformanceList){
                if (obj.getDueAmount() != null){
                    PersonPerformanceRespDTO respDTO = personMap.get(obj.getSellerId());
                    if (respDTO != null){
                        respDTO.setDueAmount(obj.getDueAmount());
                        respDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
                        String rate = respDTO.getAimAmount() == 0?String.valueOf(100): String.valueOf(Arith.div((respDTO.getDueAmount()*100)+"",respDTO.getAimAmount().toString(),2));
                        respDTO.setRate(rate);
                    }
                }
            }
        }
        for (Map.Entry<Long, PersonPerformanceRespDTO> entry : personMap.entrySet()) {
            if (entry.getValue().getAimAmount() != null && entry.getValue().getRate() == null){
                entry.getValue().setRate("0");
            }
        }
    }

    /**
     * 查询门店下所有员工列表
     * @param salePerformanceList
     * @param reqDTO
     */
    private void getStorePerson(List<SalePerformance> salePerformanceList, PersonPerformanceReqDTO reqDTO){
        UserInfoReqDTO param = new UserInfoReqDTO();
        param.setLoginCompId(reqDTO.getLoginCompId());
        param.setStoreId(reqDTO.getStoreId());
        param.setLoginPersonId(reqDTO.getLoginPersonId());
        Map<Long,UserInfoRespDTO> userInfoRespDTOMap = userInfoOutSideService.queryStorePersonMap(param,true);
        for (SalePerformance obj : salePerformanceList){
            UserInfoRespDTO person = userInfoRespDTOMap.get(obj.getPersonId());
            if(person != null){
                obj.setAvatar(person.getAvatar());
                obj.setPersonName(person.getPersonName());
                userInfoRespDTOMap.remove(obj.getPersonId());
            }
        }
        for (UserInfoRespDTO obj : userInfoRespDTOMap.values()){
            SalePerformance salePerformance = new SalePerformance();
            salePerformance.setPerformanceStatus(1);
            salePerformance.setSalePerformanceId(0L);
            salePerformance.setCompId(obj.getCompId());
            salePerformance.setStoreId(obj.getStoreId());
            salePerformance.setPersonId(obj.getPersonId());
            salePerformance.setPersonName(obj.getPersonName());
            salePerformance.setAvatar(obj.getAvatar());
            salePerformance.setAimAmount(0L);
            salePerformanceList.add(salePerformance);
        }
    }

    /**
     * 1.查询员工列表
     * 2.设置total
     * @param reqDTO
     * @param sellerIds
     * @return
     */
    private Map<Long,PersonPerformanceRespDTO> getPersonMap(PersonPerformanceReqDTO reqDTO,List<Long> sellerIds){
        Map<Long,PersonPerformanceRespDTO> map = new LinkedHashMap<Long,PersonPerformanceRespDTO>();
        SalePerformanceBO bo = new SalePerformanceBO(reqDTO);
        List<SalePerformance> salePerformanceList = companyStoreService.querySellerPerformance(bo);
        getStorePerson(salePerformanceList,reqDTO);
        if (!CollectionUtils.isEmpty(salePerformanceList)){
            total = salePerformanceList.size();
            int limit = reqDTO.getLimit() == null?10:reqDTO.getLimit();
            int offset = reqDTO.getOffset() == null?0:reqDTO.getOffset();
            if (offset >= total){
                return new HashMap<>();
            }
            for (int i = offset;i < total && i < i+limit;i++){
                SalePerformance obj = salePerformanceList.get(i);
                PersonPerformanceRespDTO respDTO = new PersonPerformanceRespDTO();
                respDTO.setSalePerformanceId(obj.getSalePerformanceId());
                respDTO.setPersonId(obj.getPersonId());
                respDTO.setPersonName(obj.getPersonName());
                respDTO.setAvatar(obj.getAvatar());
                respDTO.setAimAmount(obj.getAimAmount());
                respDTO.setAimAmountY(AmountUtils.changeF2Y(obj.getAimAmount()));
                //实际业绩先设为0
                respDTO.setDueAmount(0L);
                respDTO.setDueAmountY(AmountUtils.changeF2Y(0L));
                //设置了业绩的查询用户信息，并且加入 sellerIds
                if (!obj.noPerformance()){
                    BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getLoginCompId(),obj.getPersonId(), ConfigCenterUtil.ENV);
                    if (orgRespDTO != null){
                        respDTO.setAvatar(orgRespDTO.getAvatar());
                        if (orgRespDTO.getPersonName() != null && !orgRespDTO.getPersonName().equals("")){
                            respDTO.setPersonName(orgRespDTO.getPersonName());
                        }
                    }
                    sellerIds.add(obj.getPersonId());
                }
                map.put(obj.getPersonId(),respDTO);
            }
        }
        return map;
    }
}
