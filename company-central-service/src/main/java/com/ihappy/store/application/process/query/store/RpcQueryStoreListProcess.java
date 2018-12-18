package com.ihappy.store.application.process.query.store;

import com.alibaba.fastjson.JSONObject;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.StoreQueryReqDTO;
import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.StoreQueryRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/10/23.
 */
public class RpcQueryStoreListProcess extends DefaultQueryProcess<StoreQueryReqDTO,List<StoreQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Override
    public void process(Context<StoreQueryReqDTO, List<StoreQueryRespDTO>> context) {
        StoreQueryReqDTO reqDTO = context.getParam();
        BaseinfoCompanyStore param = getParam(reqDTO);
        List<CompanyStoreModel> models = companyStoreService.selectStoreByCondition(param);
        context.getResult().setModule(getStoreQueryRespDTOList(models));
    }

    private List<StoreQueryRespDTO> getStoreQueryRespDTOList(List<CompanyStoreModel> models){
        List<StoreQueryRespDTO> list = new ArrayList<StoreQueryRespDTO>();
        if (!CollectionUtils.isEmpty(models)){
            for (CompanyStoreModel obj : models){
                StoreQueryRespDTO respDTO = new StoreQueryRespDTO();
                BeanUtils.copyProperties(obj.getDO(),respDTO);
                respDTO.setBankInfo(JSONObject.parseArray(obj.getAtrributes("bankInfo"), BankInfoRespDTO.class));
                list.add(respDTO);
            }
        }
        return list;
    }

    private BaseinfoCompanyStore getParam(StoreQueryReqDTO reqDTO){
        BaseinfoCompanyStore param = new BaseinfoCompanyStore();
        BeanUtils.copyProperties(reqDTO,param);
        param.setCompId(Integer.valueOf(reqDTO.getCompId()+""));
        param.setIsDeleted(reqDTO.getIsDeleted());
        param.setStoreId(reqDTO.getStoreId());
        return param;
    }

}
