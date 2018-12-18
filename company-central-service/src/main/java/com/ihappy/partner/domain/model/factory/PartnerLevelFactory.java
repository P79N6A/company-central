package com.ihappy.partner.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.level.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/5/2.
 */
public class PartnerLevelFactory {
    public static PartnerLevelModel partnerLevelAddReqDTOToModel(PartnerLevelAddReqDTO reqDTO){
        BaseinfoCompanyPartnerLevel res = new BaseinfoCompanyPartnerLevel();
        BeanUtils.copyProperties(reqDTO,res);
        res.setCompId(Integer.parseInt(reqDTO.userCompId().toString()));
        res.setCreatedPersonId(reqDTO.personId());
        res.setCreatedAt(reqDTO.getCreateTime() == null? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        res.setUpdatedAt(reqDTO.getUpdateTime() == null? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        return new PartnerLevelModel(res);
    }

    public static PartnerLevelModel partnerLevelUpdateReqDTOToModel(PartnerLevelUpdateReqDTO reqDTO){
        BaseinfoCompanyPartnerLevel res = new BaseinfoCompanyPartnerLevel();
        BeanUtils.copyProperties(reqDTO,res);
        res.setCompId(Integer.parseInt(reqDTO.userCompId().toString()));
        res.setUpdatedPersonId(reqDTO.personId());
        res.setUpdatedAt(reqDTO.getUpdateTime() == null? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        return new PartnerLevelModel(res);
    }

    public static PartnerLevelModel partnerLevelDelReqDTOToModel(PartnerLevelDelReqDTO reqDTO){
        BaseinfoCompanyPartnerLevel res = new BaseinfoCompanyPartnerLevel();
        BeanUtils.copyProperties(reqDTO,res);
        res.setCompId(Integer.parseInt(reqDTO.userCompId().toString()));
        res.setUpdatedPersonId(reqDTO.personId());
        res.setUpdatedAt(reqDTO.getUpdateTime() == null? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        return new PartnerLevelModel(res);
    }

    public static PartnerLevelModel partnerLevelQueryReqDTOToDTO(PartnerLevelQueryReqDTO reqDTO){
        BaseinfoCompanyPartnerLevel res = new BaseinfoCompanyPartnerLevel();
        BeanUtils.copyProperties(reqDTO,res);
        res.setCompId(Integer.parseInt(reqDTO.userCompId().toString()));
        return new PartnerLevelModel(res);
    }
    public static PartnerLevelQueryRespDTO modelToPartnerLevelQueryRespDTO(PartnerLevelModel model){
        PartnerLevelQueryRespDTO res = new PartnerLevelQueryRespDTO();
        BeanUtils.copyProperties(model.getDO(),res);
        return res;
    }

    public static PartnerLevelModel partnerLevelListQueryReqDTOToModel(PartnerLevelListQueryReqDTO reqDTO){
        BaseinfoCompanyPartnerLevel res = new BaseinfoCompanyPartnerLevel();
        BeanUtils.copyProperties(reqDTO,res);
        res.setCompId(Integer.parseInt(reqDTO.userCompId().toString()));
        return new PartnerLevelModel(res);
    }

    public static List<PartnerLevelQueryRespDTO> modelListToPartnerLevelQueryRespDTOList(List<PartnerLevelModel> models){
        List<PartnerLevelQueryRespDTO> res = new ArrayList<PartnerLevelQueryRespDTO>();
        for(PartnerLevelModel obj : models){
            PartnerLevelQueryRespDTO respDTO = new PartnerLevelQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(),respDTO);
            res.add(respDTO);
        }
        return res;
    }
}
