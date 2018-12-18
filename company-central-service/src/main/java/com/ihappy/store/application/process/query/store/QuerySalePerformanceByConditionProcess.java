package com.ihappy.store.application.process.query.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dto.request.store.SalePerformanceReqDTO;
import com.ihappy.store.domain.dto.response.store.SalePerformanceRespDTO;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/11/3.
 */
public class QuerySalePerformanceByConditionProcess extends DefaultQueryProcess<SalePerformanceReqDTO,List<SalePerformanceRespDTO>>{
    @Autowired
    private CompanyStoreService companyStoreService;
    @Override
    public void process(Context<SalePerformanceReqDTO, List<SalePerformanceRespDTO>> context) {
        List<SalePerformanceRespDTO> respDTOS = new ArrayList<SalePerformanceRespDTO>();
        SalePerformanceReqDTO reqDTO = context.getParam();
        SalePerformanceBO param = new SalePerformanceBO();
        param.setSalePerformanceId(reqDTO.getSalePerformanceId());
        param.setCompId(reqDTO.getCompId());
        param.setStoreId(reqDTO.getStoreId());
        param.setStoreIds(reqDTO.getStoreIds());
        param.setPersonId(reqDTO.getPersonId());
        param.setYearMonth(reqDTO.getYearMonth());
        param.setIsDeleted(reqDTO.getIsDelete());
        List<SalePerformance> list = companyStoreService.selectSalePerformanceByCondition(param);
        if (!CollectionUtil.isEmpty(list)){
            list.forEach((obj)->{
                SalePerformanceRespDTO respDTO = new SalePerformanceRespDTO();
                respDTO.setSalePerformanceId(obj.getSalePerformanceId());
                respDTO.setCompId(obj.getCompId());
                respDTO.setStoreId(obj.getStoreId());
                respDTO.setStoreName(obj.getStoreName());
                respDTO.setPersonId(obj.getPersonId());
                respDTO.setPersonName(obj.getPersonName());
                respDTO.setAvatar(obj.getAvatar());
                respDTO.setAimAmount(obj.getAimAmount());
                respDTO.setYearonth(obj.getIsDeleted());
                respDTOS.add(respDTO);
            });
        }
        context.getResult().setModule(respDTOS);
    }
}
