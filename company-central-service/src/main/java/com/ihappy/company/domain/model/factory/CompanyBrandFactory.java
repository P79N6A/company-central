package com.ihappy.company.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyBrand;
import com.ihappy.company.domain.dto.request.CompanyBrandAddInsideReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandAddReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandDelReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandsDelReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandFactory {
    public static List<CompanyBrandListQueryRespDTO> modelListToRespDTOList(List<CompanyBrandModel> list){
        if(null == list || list.size() == 0){
            return new ArrayList<CompanyBrandListQueryRespDTO>();
        }
        List<CompanyBrandListQueryRespDTO> resList = new ArrayList<CompanyBrandListQueryRespDTO>();
        for(CompanyBrandModel obj : list){
            if(null != obj){
                CompanyBrandListQueryRespDTO respDTO = new CompanyBrandListQueryRespDTO();
                BeanUtils.copyProperties(obj.getDO(),respDTO);
                resList.add(respDTO);
            }
        }
        return resList;
    }

    public static CompanyBrandModel companyBrandAddReqDTODTOToModel(CompanyBrandAddReqDTO companyBrandAddReqDTO){
        BaseinfoCompanyBrand baseinfoCompanyBrand = new BaseinfoCompanyBrand();
        BeanUtils.copyProperties(companyBrandAddReqDTO,baseinfoCompanyBrand);
        baseinfoCompanyBrand.setUpdatedAt(CompanyDateUtil.getDate14Long(companyBrandAddReqDTO.getUpdateTime()));
        baseinfoCompanyBrand.setCreatedAt(CompanyDateUtil.getDate14Long(companyBrandAddReqDTO.getCreateTime()));
        baseinfoCompanyBrand.setCompId(Integer.parseInt(companyBrandAddReqDTO.userCompId().toString()));
        baseinfoCompanyBrand.setCreatedPersonId(companyBrandAddReqDTO.personId());
        return new CompanyBrandModel(baseinfoCompanyBrand);
    }

    public static CompanyBrandModel companyBrandAddInsideReqDTODTOToModel(CompanyBrandAddInsideReqDTO reqDTO){
        BaseinfoCompanyBrand baseinfoCompanyBrand = new BaseinfoCompanyBrand();
        BeanUtils.copyProperties(reqDTO,baseinfoCompanyBrand);
        baseinfoCompanyBrand.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        baseinfoCompanyBrand.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        baseinfoCompanyBrand.setCompId(Integer.parseInt(reqDTO.getCompId().toString()));
        return new CompanyBrandModel(baseinfoCompanyBrand);
    }

    public static CompanyBrandModel companyBrandDelReqDTODTOToModel(CompanyBrandDelReqDTO companyBrandDelReqDTO){
        BaseinfoCompanyBrand baseinfoCompanyBrand = new BaseinfoCompanyBrand();
        BeanUtils.copyProperties(companyBrandDelReqDTO,baseinfoCompanyBrand);
        baseinfoCompanyBrand.setUpdatedAt(CompanyDateUtil.getDate14Long(companyBrandDelReqDTO.getUpdateTime()));
        baseinfoCompanyBrand.setUpdatedPersonId(companyBrandDelReqDTO.personId());
        return new CompanyBrandModel(baseinfoCompanyBrand);
    }

    public static CompanyBrandModel companyBrandsDelReqDTODTOToModel(CompanyBrandsDelReqDTO companyBrandsDelReqDTO){
        BaseinfoCompanyBrand baseinfoCompanyBrand = new BaseinfoCompanyBrand();
        BeanUtils.copyProperties(companyBrandsDelReqDTO,baseinfoCompanyBrand);
        baseinfoCompanyBrand.setUpdatedAt(CompanyDateUtil.getDate14Long(companyBrandsDelReqDTO.getUpdateTime()));
        baseinfoCompanyBrand.setUpdatedPersonId(companyBrandsDelReqDTO.personId());
        baseinfoCompanyBrand.setCompId(Integer.valueOf(companyBrandsDelReqDTO.userCompId().toString()));
        return new CompanyBrandModel(baseinfoCompanyBrand);
    }

    public static CompanyBrandModel companyBrandListQueryReqDTO(CompanyBrandDelReqDTO companyBrandDelReqDTO){
        BaseinfoCompanyBrand baseinfoCompanyBrand = new BaseinfoCompanyBrand();
        BeanUtils.copyProperties(companyBrandDelReqDTO,baseinfoCompanyBrand);
        baseinfoCompanyBrand.setUpdatedAt(CompanyDateUtil.getDate14Long(companyBrandDelReqDTO.getUpdateTime()));
        baseinfoCompanyBrand.setUpdatedPersonId(companyBrandDelReqDTO.personId());
        return new CompanyBrandModel(baseinfoCompanyBrand);
    }
}
