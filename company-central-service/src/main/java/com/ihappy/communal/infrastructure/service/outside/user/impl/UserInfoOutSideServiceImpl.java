package com.ihappy.communal.infrastructure.service.outside.user.impl;

import com.ihappy.communal.domain.bo.PersonBO;
import com.ihappy.communal.infrastructure.service.outside.user.UserInfoOutSideService;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.domain.dto.request.user.UserInfoReqDTO;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.BaseInfoPersonBasicRespDTO;
import com.ihappy.user.domain.dto.response.person.CompStoreInfoRespDTO;
import com.ihappy.user.domain.dto.response.person.PersonInfoOrgBaseRespDTO;
import com.ihappy.user.domain.query.person.CompStoreQuery;
import com.ihappy.user.domain.query.person.PersonInfoByMobileQuery;
import com.ihappy.user.domain.query.person.PersonInfoOrgBaseQuery;
import com.ihappy.user.service.person.BaseinfoPersonCompanyOrgReadRpcService;
import com.ihappy.user.service.person.BaseinfoPersonInsideRpcReadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/8/30.
 */
public class UserInfoOutSideServiceImpl implements UserInfoOutSideService {
    Logger logger = CompanyLoggerUtil.getUserLogger();
    @Autowired
    private BaseinfoPersonInsideRpcReadService baseinfoPersonInsideRpcReadServiceClient;
    @Autowired
    private BaseinfoPersonCompanyOrgReadRpcService baseinfoPersonCompanyOrgReadRpcService;
    @Override
    public List<UserInfoRespDTO> queryStorePerson(UserInfoReqDTO reqDTO, boolean throwException) {
        List<UserInfoRespDTO> respDTOS = new ArrayList<UserInfoRespDTO>();
        try{
            CompStoreQuery compStoreQuery = new CompStoreQuery();
            compStoreQuery.setLoginCompId(reqDTO.getLoginCompId());
            compStoreQuery.setStoreId(reqDTO.getStoreId());
            compStoreQuery.setLoginPersonId(reqDTO.getLoginPersonId());
            Result<List<CompStoreInfoRespDTO>> result = baseinfoPersonInsideRpcReadServiceClient.queryCompStoreInfo(compStoreQuery);
            if(result.isSuccess() && result.getModule() != null && result.getModule().size() > 0){
                List<CompStoreInfoRespDTO> compStoreInfoRespDTOList = result.getModule();
                for (CompStoreInfoRespDTO obj : compStoreInfoRespDTOList){
                    UserInfoRespDTO respDTO = new UserInfoRespDTO();
                    respDTO.setCompId(obj.getCompId());
                    respDTO.setPersonId(obj.getPersonId());
                    respDTO.setPersonName(obj.getPersonName());
                    respDTO.setAvatar(obj.getAvatar());
                    respDTO.setStoreId(obj.getStoreId());
                    respDTOS.add(respDTO);
                }
            }
            return respDTOS;
        }catch(Exception e){
            logger.error("BaseinfoPersonInsideRpcReadService_queryCompStoreInfo外部服务调用失败", e);
            if(throwException){
                throw e;
            }
            return respDTOS;
        }
    }

    @Override
    public Map<Long, UserInfoRespDTO> queryStorePersonMap(UserInfoReqDTO reqDTO, boolean throwException) {
        List<UserInfoRespDTO> list = queryStorePerson(reqDTO,throwException);
        Map<Long, UserInfoRespDTO> map = new HashMap<Long, UserInfoRespDTO>();
        for (UserInfoRespDTO obj : list){
            map.put(obj.getPersonId(),obj);
        }
        return map;
    }

    @Override
    public List<CompStoreInfoRespDTO> queryCompStoreInfo(CompStoreQuery compStoreQuery, boolean throwException ) {
        try {
            Result<List<CompStoreInfoRespDTO>> result = baseinfoPersonInsideRpcReadServiceClient.queryCompStoreInfo(compStoreQuery);
            if(result == null || !result.isSuccess() || result.getModule() == null || result.getModule().size() <=0){
                return null;
            }
            return result.getModule();
        } catch (Exception e) {
            logger.error("UserInfoOutSideService_queryCompStoreInfo外部服务调用失败", e);
            if (throwException) {
                throw e;
            }
            return null;
        }
    }

    @Override
    public List<UserInfoRespDTO> queryPersonInfoOrgBaseList(UserInfoReqDTO reqDTO, boolean throwException) {
        List<UserInfoRespDTO> list = new ArrayList<UserInfoRespDTO>();
        try {
            if(reqDTO.getCompId() == null){
                return list;
            }
            PersonInfoOrgBaseQuery param = new PersonInfoOrgBaseQuery();
            param.setLoginCompId(reqDTO.getCompId());
            param.setDeletedFlag(reqDTO.getDeletedFlag());
            param.setRoleIdList(reqDTO.getRoleIdList());
            param.setStoreIdList(reqDTO.getStoreIdList());
            Result<List<PersonInfoOrgBaseRespDTO>> result = baseinfoPersonCompanyOrgReadRpcService.queryPersonInfoOrgBaseList(param);
            if(result == null || !result.isSuccess() || result.getModule() == null || result.getModule().size() <=0){
                return list;
            }
            result.getModule().forEach((obj)->{
                UserInfoRespDTO respDTO = new UserInfoRespDTO();
                respDTO.setCompId(obj.getCompId());
                respDTO.setPersonId(obj.getPersonId());
                respDTO.setPersonName(obj.getPersonName());
                respDTO.setPersonMobile(obj.getPersonMobile());
                respDTO.setRoleId(obj.getRoleId());
                list.add(respDTO);
            });
        } catch (Exception e) {
            logger.error("BaseinfoPersonCompanyOrgReadRpcService_queryPersonInfoOrgBaseList外部服务调用失败", e);
            if (throwException) {
                throw e;
            }
            return list;
        }
        return list;
    }

    @Override
    public PersonBO queryPersonInfoByMobile(String mobile) {
        PersonInfoByMobileQuery personInfoByMobileQuery = new PersonInfoByMobileQuery();
        personInfoByMobileQuery.setMobile(mobile);
        Result<BaseInfoPersonBasicRespDTO> personResult
                = baseinfoPersonCompanyOrgReadRpcService.queryBasicPersonInfoByMobile(personInfoByMobileQuery);
        if(personResult != null && personResult.isSuccess()){
            PersonBO personBO = new PersonBO();
            personBO.setCurCompId(personResult.getModule().getCurCompId());
            personBO.setPersonId(personResult.getModule().getPersonId());
            personBO.setPersonName(personResult.getModule().getPersonName());
            return personBO;
        }
        return null;
    }
}
