package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.domain.dto.request.store.StoreInfoByLoginQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StoreInfoByLoginQueryRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhc on 2018/8/27.
 */
public class QueryStoreByLoginPersonProcess extends DefaultQueryProcess<StoreInfoByLoginQueryReqDTO,List<StoreInfoByLoginQueryRespDTO>> {

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<StoreInfoByLoginQueryReqDTO, List<StoreInfoByLoginQueryRespDTO>> context) {

        StoreInfoByLoginQueryReqDTO reqDTO = context.getParam();

        List<Integer> compIds = new ArrayList<>();
        compIds.add(Integer.parseInt(reqDTO.getCompId()+""));
        List<CompanyModel> companyModelList = companyInfoService.queryCompanyInfoListByIds(compIds);
        if(CollectionUtil.isEmpty(companyModelList)){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_ILLEGAL);
        }

        CompanyModel companyModel = companyModelList.get(0);
        Boolean flag = false;
        if(companyModel.getAdminPersonId() != null &&
                companyModel.getAdminPersonId().longValue() == reqDTO.getPersonId().longValue()){
            flag = true;
        }
        List<CompanyStoreModel> storeModelList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("compId",reqDTO.getCompId());
        if(flag){//老板身份
            if(reqDTO.getType() == 1){//老板只给总店
                map.put("isPublic",1);
                storeModelList =companyStoreService.findStoreListByCompIdAndStoreIds(map);
            }else {//老板给所有门店
                storeModelList =companyStoreService.findStoreListByCompIdAndStoreIds(map);
            }
        }else {//不是老板身份
            BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getCompId(),
                    reqDTO.getPersonId(), ConfigCenterUtil.ENV);
            if (!CollectionUtil.isEmpty(orgRespDTO.getStoreInfoList())) {//判断员工是否有门店
                List<Long> storeIds = new ArrayList<>();
                for(StoreInfoRespDTO dto :orgRespDTO.getStoreInfoList()){//获取员工门店
                    storeIds.add(dto.getStoreId());
                }
                map.put("storeIds",storeIds);
                storeModelList =companyStoreService.findStoreListByCompIdAndStoreIds(map);
            }
        }
        List<StoreInfoByLoginQueryRespDTO> dtoList = new ArrayList<>();
        for(CompanyStoreModel model : storeModelList){
            StoreInfoByLoginQueryRespDTO respDTO = model.toStoreInfoByLoginQueryRespDTO();
            dtoList.add(respDTO);
        }

        context.getResult().setModule(dtoList);
    }
}
