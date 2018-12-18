package com.ihappy.company.domain.model.factory;

import com.alibaba.fastjson.JSON;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyVerifiedEnum;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;
import com.ihappy.company.common.enumtype.StatusEnum;
import com.ihappy.company.common.enumtype.company.CompanyBarCodePrintSizeEnum;
import com.ihappy.company.common.enumtype.company.CompanyPrintSizeEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.BaseinfoCompanyBO;
import com.ihappy.company.domain.bo.CompanyInfoBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyServiceStatusPageQueryReqDTO;
import com.ihappy.company.domain.dto.response.BaseinfoCompanyRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoListQueryRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoQueryRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyServiceStatusPageQueryRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfosRespDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.domain.bo.SysCompanyRoleBO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleInfoQueryReqDTO;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.bo.store.StoreNamesQueryBO;
import com.ihappy.store.domain.dto.request.store.CompanyStroreInfoQueryReqDTO;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/3/29.
 */
public class BaseinfoCompanyFactory {
    public static List<CompanyModel> toModelList(List<BaseinfoCompany> baseinfoCompanys){
        List<CompanyModel> models = new ArrayList<CompanyModel>();
        if (CollectionUtil.isEmpty(baseinfoCompanys)){
            return models;
        }
        for (BaseinfoCompany obj : baseinfoCompanys){
            models.add(new CompanyModel(obj));
        }
        return models;
    }
    public static BaseinfoCompany toPayRemark(CompanyInfoUpdateReqDTO reqDTO) {
        if (StringUtil.isBlank(reqDTO.getPayRemark())) {
            return null;
        }
        BaseinfoCompany company = new BaseinfoCompany();
        company.setPayRemark(reqDTO.getPayRemark());
        company.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        company.setPayRemarkTime(CompanyDateUtil.getDate14Long(new Date()));
        company.setPayRemarkUserId(reqDTO.getLoginPersonId());
        company.setCompId(reqDTO.getCompId());
        //查询用户权限
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getLoginCompId(), reqDTO.getLoginPersonId(), ConfigCenterUtil.ENV);
        if (orgRespDTO != null) {
            company.setPayRemarkUserName(orgRespDTO.getPersonName());
        }
        return company;
    }

    public static List<CompanyServiceStatusPageQueryRespDTO> companysToCompanyServiceStatusPageQueryRespDTOList(List<BaseinfoCompany> companys) {
        List<CompanyServiceStatusPageQueryRespDTO> respDTOS = new ArrayList<CompanyServiceStatusPageQueryRespDTO>();
        if (CollectionUtil.isEmpty(companys)) {
            return respDTOS;
        }
        for (BaseinfoCompany obj : companys) {
            CompanyServiceStatusPageQueryRespDTO respDTO = new CompanyServiceStatusPageQueryRespDTO();
            BeanUtils.copyProperties(obj, respDTO);
            respDTO.setRegisterDateStr(CompanyDateUtil.longDate2String(obj.getCreatedAt()));
            respDTO.setExpireDateStr(CompanyDateUtil.longDate2String(obj.getExpireDate()));
            if (obj.getStatus() == 2) {
                respDTO.setPeriodOfValidity("-");
            } else {
                Integer periodOfValidity = DateUtil.differentDays(new Date(), DateUtil.parseDateYMD(obj.getExpireDate() + ""));
                if (periodOfValidity < 0) {
                    respDTO.setPeriodOfValidity("已过期" + (-periodOfValidity) + "日");
                } else {
                    respDTO.setPeriodOfValidity(periodOfValidity + "日");
                }
            }
            respDTO.setUpdatedAt(CompanyDateUtil.parseDian(obj.getUpdatedAt()));
            respDTO.setUpdatedPersonId(obj.getUpdatedPersonId());
            String name = "";
            if (obj.getUpdatedPersonId() != 0) {
                BaseinfoPersonRespDTO dto = SysAndPersonRedisUtil.getUserInfoKey(obj.getUpdatedPersonId(), ConfigCenterUtil.ENV);
                if (dto != null) {
                    name = dto.getPersonName();
                }
            }
            respDTO.setUpdatedPersonName(name);
            respDTO.setMemo(obj.getMemo());
            respDTO.setExpireStatusName(ExpireStatusEnum.getTbcpNatureEnum(obj.getExpireStatus()).getValue());
            respDTO.setPayRemarkTimeStr(CompanyDateUtil.longDate2String(obj.getPayRemarkTime()));
            respDTO.setStatusName(StatusEnum.getTbcpNatureEnum(obj.getStatus()).getValue());
            respDTOS.add(respDTO);
        }
        return respDTOS;
    }

    public static CompanyInfoBO companyServiceStatusPageQueryReqDTOToBO(CompanyServiceStatusPageQueryReqDTO reqDTO) {
        CompanyInfoBO bo = new CompanyInfoBO();
        BeanUtils.copyProperties(reqDTO, bo);
        if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() > 0) {
            Long startValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity() - 1);
            Long endValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity());
            bo.setStartValidTime(startValidTime);
            bo.setEndValidTime(endValidTime);
        } else if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() == -1) {
            Long endValidTime = CompanyDateUtil.getTodayStartDate14Long();
            bo.setEndValidTime(endValidTime);
        }
        return bo;
    }

    public static List<BaseinfoCompanyRespDTO> modelListToRespDTOList(List<BaseinfoCompany> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList<BaseinfoCompanyRespDTO>();
        }
        List<BaseinfoCompanyRespDTO> resList = new ArrayList<BaseinfoCompanyRespDTO>();
        for (BaseinfoCompany obj : list) {
            if (null != obj) {
                BaseinfoCompanyRespDTO respDTO = new BaseinfoCompanyRespDTO();
                BeanUtils.copyProperties(obj, respDTO);
                respDTO.setIsVerifiedStr(CompanyVerifiedEnum.getTbcpVerifiedEnum(obj.getIsVerified()).getValue());
                respDTO.setRegisterDateStr(CompanyDateUtil.longDate2String(obj.getCreatedAt(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                respDTO.setExpireDateStr(CompanyDateUtil.longDate2String(obj.getExpireDate(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                if (obj.getStatus() == 2) {
                    respDTO.setPeriodOfValidity("-");
                } else {
                    if (obj.getExpireDate() != null && obj.getExpireDate() != 0L) {
                        Integer periodOfValidity = DateUtil.differentDays(new Date(), DateUtil.parseDateYMD(obj.getExpireDate() + ""));
                        if (periodOfValidity < 0) {
                            respDTO.setPeriodOfValidity("已过期" + (-periodOfValidity) + "日");
                        } else {
                            respDTO.setPeriodOfValidity(periodOfValidity + "日");
                        }
                    }
                }
                respDTO.setUpdatedAt(CompanyDateUtil.parseDian(obj.getUpdatedAt()));
                respDTO.setUpdatedPersonId(obj.getUpdatedPersonId());
                String name = "";
                if (obj.getUpdatedPersonId() != null && obj.getUpdatedPersonId() != 0) {
                    BaseinfoPersonRespDTO dto = SysAndPersonRedisUtil.getUserInfoKey(obj.getUpdatedPersonId(), ConfigCenterUtil.ENV);
                    if (dto != null) {
                        name = dto.getPersonName();
                    }
                }
                respDTO.setUpdatedPersonName(name);
                respDTO.setMemo(obj.getMemo());
                respDTO.setExpireStatusName(ExpireStatusEnum.getTbcpNatureEnum(obj.getExpireStatus()).getValue());
                respDTO.setPayRemarkTimeStr(CompanyDateUtil.longDate2String(obj.getPayRemarkTime()));
                respDTO.setStatusName(StatusEnum.getTbcpNatureEnum(obj.getStatus()).getValue());
                resList.add(respDTO);
            }
        }
        return resList;
    }

    /**
     * BaseinfoCompanyReqDTO 转 BaseinfoCompany
     *
     * @param baseinfoCompanyReqDTO
     * @return BaseinfoCompany
     */
    public static BaseinfoCompany reqDTOToModel(BaseinfoCompanyReqDTO baseinfoCompanyReqDTO) {
        if (null == baseinfoCompanyReqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(baseinfoCompanyReqDTO, baseinfoCompany);
        baseinfoCompany.setOffset(baseinfoCompanyReqDTO.getOffset());
        baseinfoCompany.setLimit(baseinfoCompanyReqDTO.getLimit());
        return baseinfoCompany;
    }

    public static BaseinfoCompany companyStatusReqDTOToModel(CompanyStatusReqDTO companyStatusReqDTO) {
        if (null == companyStatusReqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyStatusReqDTO, baseinfoCompany);
        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyStatusReqDTO.getUpdateTime()));
        baseinfoCompany.setUpdatedPersonId(companyStatusReqDTO.personId());
        return baseinfoCompany;
    }

    public static BaseinfoCompany companyInfoQueryReqDTOBaseinfoCompany(CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        if (null == companyInfoQueryReqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        baseinfoCompany.setCompId(companyInfoQueryReqDTO.getCompId());
        return baseinfoCompany;
    }

    public static BaseinfoCompany companyInfoWithoutLoginQueryReqDTOTOBaseinfoCompany(CompanyInfoWithoutLoginQueryReqDTO reqDTO) {
        if (null == reqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        baseinfoCompany.setCompId(reqDTO.getCompId());
        return baseinfoCompany;
    }

    public static CompanyInfoQueryRespDTO modelTOCompanyInfoQueryRespDTO(BaseinfoCompany baseinfoCompany) {
        if (null == baseinfoCompany) {
            return new CompanyInfoQueryRespDTO();
        }
        CompanyInfoQueryRespDTO bompanyInfoQueryRespDTO = new CompanyInfoQueryRespDTO();
        BeanUtils.copyProperties(baseinfoCompany, bompanyInfoQueryRespDTO);
        if (!StringUtil.isBlank(baseinfoCompany.getPrintSize())) {
            bompanyInfoQueryRespDTO.setPrintSize(CompanyPrintSizeEnum.getEnumByValue(baseinfoCompany.getPrintSize()).getKey());
        }
       // bompanyInfoQueryRespDTO.setArea(baseinfoCompany.getProvince()+baseinfoCompany.getCity()+baseinfoCompany.getZone());
        bompanyInfoQueryRespDTO.setCompLinkmanTel(baseinfoCompany.getCompLinkmanTel());

        return bompanyInfoQueryRespDTO;
    }

    public static BaseinfoCompany companyInfoUpdateReqDTOTOModel(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        if (null == companyInfoUpdateReqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyInfoUpdateReqDTO, baseinfoCompany);
        //经营类型不能修改
        baseinfoCompany.setCtIds(null);
        baseinfoCompany.setCtNames(null);
        if (!StringUtil.isBlank(companyInfoUpdateReqDTO.getPrintSize())) {
            baseinfoCompany.setPrintSize(CompanyPrintSizeEnum.getEnumByKey(companyInfoUpdateReqDTO.getPrintSize()).getValue());
        }
        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoUpdateReqDTO.getUpdateTime()));
        baseinfoCompany.setUpdatedPersonId(companyInfoUpdateReqDTO.personId());
        return baseinfoCompany;
    }

    public static BaseinfoCompany companyInfoUpdateReqDTORpcTOModel(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        if (null == companyInfoUpdateReqDTO) {
            return new BaseinfoCompany();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyInfoUpdateReqDTO, baseinfoCompany);
        //经营类型不能修改
        baseinfoCompany.setCtIds(null);
        baseinfoCompany.setCtNames(null);
        if (!StringUtil.isBlank(companyInfoUpdateReqDTO.getPrintSize())) {
            baseinfoCompany.setPrintSize(CompanyPrintSizeEnum.getEnumByKey(companyInfoUpdateReqDTO.getPrintSize()).getValue());
        }
        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoUpdateReqDTO.getUpdateTime()));
        return baseinfoCompany;
    }

    public static CompanyModel companyInfoAddReqDTOToModel(CompanyInfoAddReqDTO companyInfoAddReqDTO) {
        if (null == companyInfoAddReqDTO) {
            return new CompanyModel();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyInfoAddReqDTO, baseinfoCompany);
        if (!StringUtil.isBlank(companyInfoAddReqDTO.getPrintSize())) {
            baseinfoCompany.setPrintSize(CompanyPrintSizeEnum.getEnumByKey(companyInfoAddReqDTO.getPrintSize()).getValue());
        }
        //设置公司名称和简称
        if (companyInfoAddReqDTO.getCompShortName() == null || companyInfoAddReqDTO.getCompShortName().equals("")) {
            String defaultName = OptConstans.DEFAULE_COMP_NAME;
            if (companyInfoAddReqDTO.getAdminPersonMobile() != null && !companyInfoAddReqDTO.getAdminPersonMobile().equals("")) {
                defaultName += "(" + companyInfoAddReqDTO.getAdminPersonMobile() + ")";
            }
            baseinfoCompany.setCompShortName(defaultName);
            baseinfoCompany.setCompName(null);
        }

        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getUpdateTime()));
        baseinfoCompany.setCreatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getCreateTime()));
        baseinfoCompany.setCreatedPersonId(companyInfoAddReqDTO.personId());
        baseinfoCompany.setExpireDate(CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), OptConstans.DEFAULT_COMPANY_SERVICE_TIME));
        return new CompanyModel(baseinfoCompany);
    }

    public static CompanyModel companyInfoAddReqDTORpcToModel(CompanyInfoAddReqDTO companyInfoAddReqDTO) {
        if (null == companyInfoAddReqDTO) {
            return new CompanyModel();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyInfoAddReqDTO, baseinfoCompany);
        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getUpdateTime()));
        baseinfoCompany.setCreatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getCreateTime()));
        return new CompanyModel(baseinfoCompany);
    }

    public static CompanyModel companyInfoAddByRpcReqDTORpcToModel(CompanyInfoAddByRpcReqDTO companyInfoAddByRpcReqDTO) {
        if (null == companyInfoAddByRpcReqDTO) {
            return new CompanyModel();
        }
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        BeanUtils.copyProperties(companyInfoAddByRpcReqDTO, baseinfoCompany);

        if (!StringUtil.isBlank(companyInfoAddByRpcReqDTO.getPrintSize())) {
            baseinfoCompany.setPrintSize(CompanyPrintSizeEnum.getEnumByKey(companyInfoAddByRpcReqDTO.getPrintSize()).getValue());
        }
        //设置公司名称和简称
        if (companyInfoAddByRpcReqDTO.getCompShortName() == null || companyInfoAddByRpcReqDTO.getCompShortName().equals("")) {
            String defaultName = OptConstans.DEFAULE_COMP_NAME;
            if (companyInfoAddByRpcReqDTO.getAdminPersonMobile() != null && !companyInfoAddByRpcReqDTO.getAdminPersonMobile().equals("")) {
                defaultName += "(" + companyInfoAddByRpcReqDTO.getAdminPersonMobile() + ")";
            }
            baseinfoCompany.setCompShortName(defaultName);
            baseinfoCompany.setCompName(null);
        }
        baseinfoCompany.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoAddByRpcReqDTO.getUpdateTime()));
        baseinfoCompany.setCreatedAt(CompanyDateUtil.getDate14Long(companyInfoAddByRpcReqDTO.getCreateTime()));
        baseinfoCompany.setExpireDate(CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), OptConstans.DEFAULT_COMPANY_SERVICE_TIME));
        return new CompanyModel(baseinfoCompany);
    }

    public static List<CompanyInfoListQueryRespDTO> modelListToCompanyInfoListQueryReqDTOList(List<CompanyModel> companyModels) {
        if (null == companyModels) {
            return new ArrayList<>();
        }
        List<CompanyInfoListQueryRespDTO> companyInfoListQueryRespDTOs = new ArrayList<CompanyInfoListQueryRespDTO>();
        for (CompanyModel obj : companyModels) {
            CompanyInfoListQueryRespDTO companyInfoListQueryRespDTO = new CompanyInfoListQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(), companyInfoListQueryRespDTO);
            if (!StringUtil.isBlank(obj.getDO().getPrintSize())) {
                companyInfoListQueryRespDTO.setPrintSize(CompanyPrintSizeEnum.getEnumByValue(obj.getDO().getPrintSize()).getKey());
            }
            companyInfoListQueryRespDTOs.add(companyInfoListQueryRespDTO);
        }
        return companyInfoListQueryRespDTOs;
    }

    public static CompanyPrintConfigInfoRespDTO companyPrintConfigModelToCompanyPrintConfigInfoRespDTO(CompanyPrintConfigModel printConfigModel) {
        if (printConfigModel == null) {
            return null;
        }
        CompanyPrintConfigInfoRespDTO companyPrintConfigInfoRespDTO = new CompanyPrintConfigInfoRespDTO();
        BeanUtils.copyProperties(printConfigModel.getDO(), companyPrintConfigInfoRespDTO);
        // 设置打印尺寸
        companyPrintConfigInfoRespDTO.setPrintSize(CompanyBarCodePrintSizeEnum.getEnumByValue(printConfigModel.getDO().getPrintSize()).getKey());
        return companyPrintConfigInfoRespDTO;
    }

    public static BaseinfoCompanyBO toBaseinfoCompanyBO(BaseinfoCompanyReqDTO reqDTO) {
        BaseinfoCompanyBO bo = new BaseinfoCompanyBO();
        BeanUtils.copyProperties(reqDTO, bo);
        if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() > 0) {
            Long startValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity() - 1);
            Long endValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity());
            bo.setStartValidTime(startValidTime);
            bo.setEndValidTime(endValidTime);
        } else if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() == -1) {
            Long endValidTime = CompanyDateUtil.getTodayStartDate14Long();
            bo.setEndValidTime(endValidTime);
        }
        return bo;
    }


    public static List<FactoryInfoRespDTO> jsonToListFactoryInfoRespDTO(String json) {
        if (com.ihappy.common.util.StringUtil.isBlank(json)) {
            return new ArrayList<>();
        }

        return JSON.parseArray(json, FactoryInfoRespDTO.class);
    }

    public static FactoryInfosRespDTO jsonFactoryInfoToFactoryInfosRespDTO(String json) {
        if (com.ihappy.common.util.StringUtil.isBlank(json)) {
            return null;
        }

        return listFactoryInfoToFactoryInfosRespDTO(jsonToListFactoryInfoRespDTO(json));
    }

    public static FactoryInfosRespDTO listFactoryInfoToFactoryInfosRespDTO(List<FactoryInfoRespDTO> list) {
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }
        FactoryInfosRespDTO factoryInfosRespDTO = new FactoryInfosRespDTO();
        factoryInfosRespDTO.init(list);

        return factoryInfosRespDTO;
    }

    public static CompanyInfoByCompIdQuery companyRoleInfoQueryReqDTOToCompanyInfoByCompIdQuery(CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(companyRoleInfoQueryReqDTO.getLoginCompId().intValue());
        return companyInfoByCompIdQuery;
    }

    public static CompanyInfoByCompIdQuery companyInfoQueryReqDTOToCompanyInfoByCompIdQuery(com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(companyInfoQueryReqDTO.getCompId().intValue());
        return companyInfoByCompIdQuery;
    }

    public static BaseInfoCompanyInfoQueryRespDTO modelToResp(CompanyModel companyInfo) {
        if (null == companyInfo) {
            return new BaseInfoCompanyInfoQueryRespDTO();
        }
        BaseInfoCompanyInfoQueryRespDTO baseInfoCompanyInfoQueryRespDTO = new BaseInfoCompanyInfoQueryRespDTO();
        BeanUtils.copyProperties(companyInfo.getDO(), baseInfoCompanyInfoQueryRespDTO);
        baseInfoCompanyInfoQueryRespDTO.setStoreName(null);
        baseInfoCompanyInfoQueryRespDTO.setArea(companyInfo.getDO().getProvince()+
                companyInfo.getDO().getCity()+companyInfo.getDO().getZone());
        baseInfoCompanyInfoQueryRespDTO.setCompLinkTel(companyInfo.getDO().getCompLinkmanTel());
        return baseInfoCompanyInfoQueryRespDTO;
    }

    public static StoreNamesQueryBO companyInfoQueryReqDTOToStoreNamesQueryBO(com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        StoreNamesQueryBO storeNamesQueryBO=new StoreNamesQueryBO();
        storeNamesQueryBO.setCompId(companyInfoQueryReqDTO.getCompId());
        return storeNamesQueryBO;
    }

    public static StoreInfoBO reqToStoreInfoBO(com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        StoreInfoBO storeInfoBO=new StoreInfoBO();
        storeInfoBO.setCompId(companyInfoQueryReqDTO.getCompId());
        return storeInfoBO;
    }

    public static CompanyInfoByCompIdQuery sysCompanyRoleBOToCompanyInfoByCompIdQuery(SysCompanyRoleBO sysCompanyRoleBO) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery=new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(sysCompanyRoleBO.getCompId());
        return companyInfoByCompIdQuery;
    }

    public static BaseinfoCompany reqToBaseinfoCompany(CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        BaseinfoCompany baseinfoCompany=new BaseinfoCompany();
        baseinfoCompany.setCompId(companyStroreInfoQueryReqDTO.getLoginCompId().intValue());
        baseinfoCompany.setIsDeleted(0);
        return baseinfoCompany;
    }
}
