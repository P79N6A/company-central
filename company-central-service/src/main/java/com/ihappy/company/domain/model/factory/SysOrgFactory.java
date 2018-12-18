package com.ihappy.company.domain.model.factory;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.domain.dbdo.SysOrg;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.company.domain.model.model.SysOrgModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgFactory {

    public static List<SysOrgBasicInfoRespDTO> toSysOrgBasiceInfo(List<SysOrgModel> orgModelList) {

        List<SysOrgBasicInfoRespDTO> dtoList = new ArrayList<>();

        if(CollectionUtil.isEmpty(orgModelList)){
             return dtoList;
        }

         for(SysOrgModel sysOrgModel : orgModelList){
             SysOrgBasicInfoRespDTO respDTO = new SysOrgBasicInfoRespDTO();
             respDTO.setOrgId(sysOrgModel.getDO().getOrgId());
             respDTO.setOrgName(sysOrgModel.getDO().getOrgName());
             dtoList.add(respDTO);
         }
         return dtoList;
    }

    public static List<SysOrgBasicInfoRespDTO> modelsToSysOrgBasicInfoRespDTOs(List<SysOrgModel> models){
        List<SysOrgBasicInfoRespDTO> respDTOS = new ArrayList<SysOrgBasicInfoRespDTO>();
        for (SysOrgModel obj : models){
            SysOrgBasicInfoRespDTO respDTO = new SysOrgBasicInfoRespDTO();
            BeanUtils.copyProperties(obj.getDO(),respDTO);
            respDTOS.add(respDTO);
        }
        return respDTOS;
    }

    public static SysOrgBasicInfoRespDTO modelToSysOrgBasicInfoRespDTO(SysOrgModel model){
        SysOrgBasicInfoRespDTO respDTO = new SysOrgBasicInfoRespDTO();
        BeanUtils.copyProperties(model.getDO(),respDTO);
        return respDTO;
    }

    public static List<SysOrgModel> sysOrgsToModels(List<SysOrg> sysOrgs){
        List<SysOrgModel> models = new ArrayList<SysOrgModel>();
        for (SysOrg obj : sysOrgs){
            models.add(new SysOrgModel(obj));
        }
        return models;
    }
}
