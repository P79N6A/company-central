package com.ihappy.store.domain.model.factory.store;

import com.alibaba.fastjson.JSONObject;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;
import com.ihappy.company.common.enumtype.StatusEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.store.domain.bo.store.QueryStoreListByCompIdAndStoreIdsBO;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.bo.store.StoreInfoQueryBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import com.ihappy.user.domain.query.person.PersonInfoByPersonIdQuery;
import com.ihappy.user.domain.query.person.PersonPageQuery;
import com.yx.eweb.util.DateUtil;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/4/10.
 */
public class CompanyStoreFactory {
    public static BaseinfoCompanyStore toPayRemark(StoreInfoUpdateReqDTO reqDTO) {
        if (StringUtil.isBlank(reqDTO.getPayRemark())) {
            return null;
        }
        BaseinfoCompanyStore store = new BaseinfoCompanyStore();
        store.setPayRemark(reqDTO.getPayRemark());
        store.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        store.setPayRemarkTime(CompanyDateUtil.getDate14Long(new Date()));
        store.setPayRemarkUserId(reqDTO.getLoginPersonId());
        store.setCompId(Integer.valueOf(reqDTO.getCompId() + ""));
        store.setStoreId(reqDTO.getStoreId());
        //查询用户权限
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getLoginCompId(), reqDTO.getLoginPersonId(), ConfigCenterUtil.ENV);
        if (orgRespDTO != null) {
            store.setPayRemarkUserName(orgRespDTO.getPersonName());
        }
        return store;
    }

    public static List<CompanyStoreModel> list2ModeList(List<BaseinfoCompanyStore> list) {
        List<CompanyStoreModel> res = new ArrayList<CompanyStoreModel>();
        for (BaseinfoCompanyStore obj : list) {
            res.add(new CompanyStoreModel(obj));
        }
        return res;
    }

    public static List<CompanyStoreListQueryRespDTO> modelListToRespDTOList(List<CompanyStoreModel> companyStoreModels) {
        List<CompanyStoreListQueryRespDTO> list = new ArrayList<CompanyStoreListQueryRespDTO>();
        for (CompanyStoreModel obj : companyStoreModels) {
            CompanyStoreListQueryRespDTO companyStoreListQueryRespDTO = new CompanyStoreListQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(), companyStoreListQueryRespDTO);
            if (obj.getAtrributes("bankInfo") != null) {
                companyStoreListQueryRespDTO.setBankInfo(JSONObject.parseArray(obj.getAtrributes("bankInfo"), BankInfoRespDTO.class));
            }

            companyStoreListQueryRespDTO.setWeshopName(obj.getWeshopName());
            list.add(companyStoreListQueryRespDTO);
        }
        return list;
    }

    public static StoreRespDTO modelToStoreRespDTO(CompanyStoreModel model) {
        StoreRespDTO res = new StoreRespDTO();
        if (model == null) {
            return null;
        }
        BeanUtils.copyProperties(model.getDO(), res);
        if (model == null) {
            return null;
        }
        BeanUtils.copyProperties(model.getDO(), res);
        return res;
    }

    public static CompanyStoreModel storePrintIpAndPortUpdateReqDTOToModel(StorePrintIpAndPortUpdateReqDTO reqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setCompId(Integer.valueOf(reqDTO.getCompId().toString()));
        baseinfoCompanyStore.setStoreId(reqDTO.getStoreId());
        baseinfoCompanyStore.setPrintIp(reqDTO.getPrintIp());
        baseinfoCompanyStore.setPrintPort(reqDTO.getPrintPort());
        return new CompanyStoreModel(baseinfoCompanyStore);
    }

    public static CompanyStoreModel storeQueryReqDTOToModel(StoreQueryReqDTO reqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setCompId(Integer.valueOf(reqDTO.getCompId().toString()));
        baseinfoCompanyStore.setStoreId(reqDTO.getStoreId());
        return new CompanyStoreModel(baseinfoCompanyStore);
    }

    public static StoreInfoByLoginQueryRespDTO toStoreInfoByLoginQueryRespDTO(BaseinfoCompanyStore storeDo) {
        StoreInfoByLoginQueryRespDTO respDTO = new StoreInfoByLoginQueryRespDTO();
        respDTO.setStoreId(storeDo.getStoreId());
        respDTO.setStoreNo(storeDo.getStoreNo());
        respDTO.setStoreName(storeDo.getStoreName());
        respDTO.setCompId(Long.parseLong(storeDo.getCompId() + ""));
        return respDTO;
    }

    public static CompanyStoreModel companyStroreInfoQueryReqDTOToModel(CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
        companyStoreModel.getDO().setCompId(companyStroreInfoQueryReqDTO.getLoginCompId().intValue());
        companyStoreModel.getDO().setAdminPersonId(companyStroreInfoQueryReqDTO.getLoginPersonId());
        companyStoreModel.getDO().setStoreId(companyStroreInfoQueryReqDTO.getStoreId());
        return companyStoreModel;
    }

    public static CompanyStroreInfoQueryRespDTO modelToCompanyStroreInfoQueryRespDTO(CompanyStoreModel storeInfo) {
        CompanyStroreInfoQueryRespDTO companyStroreInfoQueryRespDTO = new CompanyStroreInfoQueryRespDTO();
        companyStroreInfoQueryRespDTO.setLogoUrl(storeInfo.getDO().getLogoUrl());
        companyStroreInfoQueryRespDTO.setStoreName(storeInfo.getDO().getStoreName());
        companyStroreInfoQueryRespDTO.setStoreContact(storeInfo.getDO().getStoreContact());
        companyStroreInfoQueryRespDTO.setStorePhone(storeInfo.getDO().getStorePhone());
        companyStroreInfoQueryRespDTO.setStoreTel(storeInfo.getDO().getStoreTel());
        companyStroreInfoQueryRespDTO.setAddress(storeInfo.getDO().getAddress());
//        companyStroreInfoQueryRespDTO.setStoreAcreage(storeInfo.getDO().getStoreAcreage());
        companyStroreInfoQueryRespDTO.setStoreId(storeInfo.getDO().getStoreId());
        companyStroreInfoQueryRespDTO.setProvince(storeInfo.getDO().getProvince());
        companyStroreInfoQueryRespDTO.setCity(storeInfo.getDO().getCity());
        companyStroreInfoQueryRespDTO.setZone(storeInfo.getDO().getZone());
        companyStroreInfoQueryRespDTO.setAlipayAccountName(storeInfo.getDO().getAlipayAccountName());
        companyStroreInfoQueryRespDTO.setAlipayReceiptQrcode(storeInfo.getDO().getAlipayReceiptQrcode());
        companyStroreInfoQueryRespDTO.setAlipayReceiptQrcodeContent(storeInfo.getDO().getAlipayReceiptQrcodeContent());
        companyStroreInfoQueryRespDTO.setWechatAccountName(storeInfo.getDO().getWechatAccountName());
        companyStroreInfoQueryRespDTO.setWechatAccountQrcode(storeInfo.getDO().getWechatAccountQrcode());
        companyStroreInfoQueryRespDTO.setWechatAccountQrcodeContent(storeInfo.getDO().getWechatAccountQrcodeContent());
        companyStroreInfoQueryRespDTO.setWechatReceiptQrcode(storeInfo.getDO().getWechatReceiptQrcode());
        companyStroreInfoQueryRespDTO.setWechatReceiptQrcodeContent(storeInfo.getDO().getWechatReceiptQrcodeContent());
        // companyStroreInfoQueryRespDTO.setAttributes(storeInfo.getDO().getAttributes());
        if (storeInfo.getAtrributes("bankInfo") != null) {
            companyStroreInfoQueryRespDTO.setBankInfo(JSONObject.parseArray(storeInfo.getAtrributes("bankInfo"), BankInfoRespDTO.class));
        }
        companyStroreInfoQueryRespDTO.setForbidden(storeInfo.getDO().getForbidden());
        companyStroreInfoQueryRespDTO.setIsPublic(storeInfo.getDO().getIsPublic());
        return companyStroreInfoQueryRespDTO;
    }

    public static CompanyInfoByCompIdQuery storeListQueryReqDTOToCompanyInfoByCompIdQuery(StoreListQueryReqDTO storeListQueryReqDTO) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(storeListQueryReqDTO.getLoginCompId().intValue());
        return companyInfoByCompIdQuery;
    }

    public static StoreListQueryRespDTO modelListToStoreListQueryRespDTOList(CompanyStoreModel baseinfoCompanyStore) {
        StoreListQueryRespDTO storeListQueryRespDTO = new StoreListQueryRespDTO();
        storeListQueryRespDTO.setCompId(baseinfoCompanyStore.getDO().getCompId());
        storeListQueryRespDTO.setIsDeleted(baseinfoCompanyStore.getDO().getIsDeleted());
        storeListQueryRespDTO.setIsPublic(baseinfoCompanyStore.getDO().getIsPublic());
        storeListQueryRespDTO.setStoreId(baseinfoCompanyStore.getDO().getStoreId());
        storeListQueryRespDTO.setStoreName(baseinfoCompanyStore.getDO().getStoreName());
        storeListQueryRespDTO.setStorePhone(baseinfoCompanyStore.getDO().getStorePhone());
        storeListQueryRespDTO.setArea(baseinfoCompanyStore.getDO().getProvince() + baseinfoCompanyStore.getDO().getCity() + baseinfoCompanyStore.getDO().getZone() + baseinfoCompanyStore.getDO().getAddress());
        storeListQueryRespDTO.setStorePhone(baseinfoCompanyStore.getDO().getStorePhone());
        storeListQueryRespDTO.setForbidden(baseinfoCompanyStore.getDO().getForbidden());
        storeListQueryRespDTO.setCreateAt(baseinfoCompanyStore.getDO().getCreatedAt());
        storeListQueryRespDTO.setExpireStatus(baseinfoCompanyStore.getDO().getExpireStatus());
        storeListQueryRespDTO.setExpireDate(baseinfoCompanyStore.getDO().getExpireDate());
        storeListQueryRespDTO.setStoreContact(baseinfoCompanyStore.getDO().getStoreContact());
        return storeListQueryRespDTO;
    }

    public static PersonPageQuery reqToPersonPageQuery(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO) {
        PersonPageQuery personPageQuery = new PersonPageQuery();
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(companyStoreAdminAddReqDTO.getLoginCompId());
        personUserInfoDTO.setPersonId(companyStoreAdminAddReqDTO.getLoginPersonId());
        personPageQuery.setCompId(personUserInfoDTO.getCompId());
        personPageQuery.setLoginPersonId(personUserInfoDTO.getPersonId());
        personPageQuery.setPersonUserInfoDTO(personUserInfoDTO);
        personPageQuery.setDeletedFlag(0);
        personPageQuery.setLimit(100);
        personPageQuery.setOffset(0);
        return personPageQuery;
    }

    public static PersonInfoByPersonIdQuery reqToPersonInfoByPersonIdQuery(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO) {
        PersonInfoByPersonIdQuery personInfoByPersonIdQuery = new PersonInfoByPersonIdQuery();
        personInfoByPersonIdQuery.setComId(companyStoreAdminAddReqDTO.getLoginCompId());
        personInfoByPersonIdQuery.setPersonId(companyStoreAdminAddReqDTO.getLoginPersonId());
        personInfoByPersonIdQuery.setDeletedFlag(0);
        return personInfoByPersonIdQuery;
    }

    public static PersonPageQuery companyStoreAdminUpdateReqDTOToPersonPageQuery(CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO) {
        PersonPageQuery personPageQuery = new PersonPageQuery();
        personPageQuery.setCompId(companyStoreAdminUpdateReqDTO.getLoginCompId());
        personPageQuery.setLoginPersonId(companyStoreAdminUpdateReqDTO.getLoginPersonId());
        personPageQuery.setLoginCompId(companyStoreAdminUpdateReqDTO.getLoginCompId());
        personPageQuery.setDeletedFlag(0);
        personPageQuery.setLimit(100);
        personPageQuery.setOffset(0);
        return personPageQuery;
    }

    public static StoreInfoBO reqToStoreInfoBO(DisableStoreReqDTO disableStoreReqDTO) {
        StoreInfoBO storeInfoBO = new StoreInfoBO();
        storeInfoBO.setCompId(disableStoreReqDTO.getLoginCompId().intValue());
        storeInfoBO.setStoreId(disableStoreReqDTO.getStoreId());
        storeInfoBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        storeInfoBO.setUpdatedPersonId(disableStoreReqDTO.getLoginPersonId());
        return storeInfoBO;
    }

    public static CompanyStoreModel reqToCompanyStoreModel(DisableStoreReqDTO disableStoreReqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setCompId(disableStoreReqDTO.getLoginCompId().intValue());
        baseinfoCompanyStore.setStoreId(disableStoreReqDTO.getStoreId());
        return new CompanyStoreModel(baseinfoCompanyStore);
    }

    public static CompanyStoreModel enableStoreReqDTOToCompanyStoreModel(EnableStoreReqDTO enableStoreReqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setCompId(enableStoreReqDTO.getLoginCompId().intValue());
        baseinfoCompanyStore.setStoreId(enableStoreReqDTO.getStoreId());
        return new CompanyStoreModel(baseinfoCompanyStore);
    }

    public static StoreInfoBO enableStoreReqDTOToStoreInfoBO(EnableStoreReqDTO enableStoreReqDTO) {
        StoreInfoBO storeInfoBO = new StoreInfoBO();
        storeInfoBO.setCompId(enableStoreReqDTO.getLoginCompId().intValue());
        storeInfoBO.setStoreId(enableStoreReqDTO.getStoreId());
        storeInfoBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        storeInfoBO.setUpdatedPersonId(enableStoreReqDTO.getLoginPersonId());
        storeInfoBO.setForbidden(0);
        return storeInfoBO;
    }

    public static StoreInfoQueryBO storePageQueryReqDTOToStoreInfoQueryBO(StorePageQueryReqDTO reqDTO) {
        StoreInfoQueryBO bo = new StoreInfoQueryBO();
        if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() > 0) {
            Long startValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity() - 1);
            Long endValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity());
            bo.setStartValidTime(startValidTime);
            bo.setEndValidTime(endValidTime);
        } else if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() == -1) {
            Long endValidTime = CompanyDateUtil.getTodayStartDate14Long();
            bo.setEndValidTime(endValidTime);
        }
        if (reqDTO.getStartDay() != null) {
            bo.setStartValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getStartDay(), 0)));
        }
        if (reqDTO.getEndDay() != null) {
            bo.setEndValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getEndDay(), 1)));
        }
        if (!StringUtil.isBlank(reqDTO.getRegisterStartTime())) {
            bo.setRegisterStartTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterStartTime())));
        }
        if (!StringUtil.isBlank(reqDTO.getRegisterEndTime())) {
            bo.setRegisterEndTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterEndTime())));
        }
        bo.setCompShortName(reqDTO.getCompShortName());
        bo.setStoreName(reqDTO.getStoreName());
        bo.setBossMobile(reqDTO.getBossMobile());
        bo.setCtIds(reqDTO.getCtIds());
        bo.setExpireStatus(reqDTO.getExpireStatus());
        bo.setStatus(reqDTO.getStatus());
        bo.setCompId(reqDTO.getCompId());
        bo.setStoreId(reqDTO.getStoreId());
        bo.setLimit(reqDTO.getLimit());
        bo.setOffset(reqDTO.getOffset());
        return bo;
    }

    public static StoreInfoQueryBO storeServiceStatusPageQueryReqDTO2StoreInfoQueryBO(StoreServiceStatusPageQueryReqDTO reqDTO) {
        StoreInfoQueryBO bo = new StoreInfoQueryBO();
        if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() > 0) {
            Long startValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity() - 1);
            Long endValidTime = CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(), reqDTO.getPeriodOfValidity());
            bo.setStartValidTime(startValidTime);
            bo.setEndValidTime(endValidTime);
        } else if (reqDTO.getPeriodOfValidity() != null && reqDTO.getPeriodOfValidity() == -1) {
            Long endValidTime = CompanyDateUtil.getTodayStartDate14Long();
            bo.setEndValidTime(endValidTime);
        }
        if (reqDTO.getStartDay() != null) {
            bo.setStartValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getStartDay(), 0)));
        }
        if (reqDTO.getEndDay() != null) {
            bo.setEndValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getEndDay(), 1)));
        }
        if (!StringUtil.isBlank(reqDTO.getRegisterStartTime())) {
            bo.setRegisterStartTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterStartTime())));
        }
        if (!StringUtil.isBlank(reqDTO.getRegisterEndTime())) {
            bo.setRegisterEndTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterEndTime())));
        }
        bo.setCompShortName(reqDTO.getCompShortName());
        bo.setStoreName(reqDTO.getStoreName());
        bo.setBossMobile(reqDTO.getBossMobile());
        bo.setCtIds(reqDTO.getCtIds());
        bo.setExpireStatus(reqDTO.getExpireStatus());
        bo.setStatus(reqDTO.getStatus());
        bo.setCompId(reqDTO.getCompId());
        bo.setStoreId(reqDTO.getStoreId());
        bo.setLimit(reqDTO.getLimit());
        bo.setOffset(reqDTO.getOffset());
        bo.setPayRemarkUserId(reqDTO.getPayRemarkUserId());
        bo.setPayRemarkUserName(reqDTO.getPayRemarkUserName());
        return bo;
    }

    public static List<StorePageQueryRespDTO> storeInfoBOList2StorePageQueryRespDTOList(List<StoreInfoBO> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList<StorePageQueryRespDTO>();
        }
        List<StorePageQueryRespDTO> resList = new ArrayList<StorePageQueryRespDTO>();
        for (StoreInfoBO obj : list) {
            if (null != obj) {
                StorePageQueryRespDTO respDTO = new StorePageQueryRespDTO();
                BeanUtils.copyProperties(obj, respDTO);
                respDTO.setRegisterDateStr(CompanyDateUtil.longDate2String(obj.getCreatedAt(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                respDTO.setExpireDateStr(CompanyDateUtil.longDate2String(obj.getExpireDate(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                if (obj.getStatus() == 2) {
                    respDTO.setPeriodOfValidity("-");
                } else {
                    if (obj.getExpireDate() != null && obj.getExpireDate() != 0L) {
                        Integer periodOfValidity = com.ihappy.company.common.util.DateUtil.differentDays(new Date(), com.ihappy.company.common.util.DateUtil.parseDateYMD(obj.getExpireDate() + ""));
                        if (periodOfValidity < 0) {
                            respDTO.setPeriodOfValidity("已过期" + (-periodOfValidity) + "日");
                        } else {
                            respDTO.setPeriodOfValidity(periodOfValidity + "日");
                        }
                    }
                }
                respDTO.setUpdatedPersonId(obj.getUpdatedPersonId());
                String name = "";
                if (obj.getUpdatedPersonId() != null && obj.getUpdatedPersonId() != 0) {
                    BaseinfoPersonRespDTO dto = SysAndPersonRedisUtil.getUserInfoKey(obj.getUpdatedPersonId(), ConfigCenterUtil.ENV);
                    if (dto != null) {
                        name = dto.getPersonName();
                    }
                }
                respDTO.setUpdatedPersonName(name);
                respDTO.setPayRemark(obj.getPayRemark());
                respDTO.setExpireStatusName(ExpireStatusEnum.getTbcpNatureEnum(obj.getExpireStatus()).getValue());
                respDTO.setUpdatedAt(CompanyDateUtil.longDate2String(obj.getUpdatedAt()));
                respDTO.setStatusName(StatusEnum.getTbcpNatureEnum(obj.getStatus()).getValue());
                respDTO.setCreatedAt(CompanyDateUtil.longDate2String(obj.getCreatedAt()));
                resList.add(respDTO);
            }
        }
        return resList;
    }

    public static List<StoreServiceStatusPageQueryRespDTO> storeInfoBOList2StoreServiceStatusPageQueryRespDTOList(List<StoreInfoBO> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList<StoreServiceStatusPageQueryRespDTO>();
        }
        List<StoreServiceStatusPageQueryRespDTO> resList = new ArrayList<StoreServiceStatusPageQueryRespDTO>();
        for (StoreInfoBO obj : list) {
            if (null != obj) {
                StoreServiceStatusPageQueryRespDTO respDTO = new StoreServiceStatusPageQueryRespDTO();
                BeanUtils.copyProperties(obj, respDTO);
                respDTO.setRegisterDateStr(CompanyDateUtil.longDate2String(obj.getCreatedAt(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                respDTO.setExpireDateStr(CompanyDateUtil.longDate2String(obj.getExpireDate(), CompanyDateUtil.YMDHMS, CompanyDateUtil.Y_M_D_H_M));
                if (obj.getStatus() == 2) {
                    respDTO.setPeriodOfValidity("-");
                } else {
                    if (obj.getExpireDate() != null && obj.getExpireDate() != 0L) {
                        Integer periodOfValidity = com.ihappy.company.common.util.DateUtil.differentDays(new Date(), com.ihappy.company.common.util.DateUtil.parseDateYMD(obj.getExpireDate() + ""));
                        if (periodOfValidity < 0) {
                            respDTO.setPeriodOfValidity("已过期" + (-periodOfValidity) + "日");
                        } else {
                            respDTO.setPeriodOfValidity(periodOfValidity + "日");
                        }
                    }
                }
                respDTO.setUpdatedPersonId(obj.getUpdatedPersonId());
                String name = "";
                if (obj.getUpdatedPersonId() != null && obj.getUpdatedPersonId() != 0) {
                    BaseinfoPersonRespDTO dto = SysAndPersonRedisUtil.getUserInfoKey(obj.getUpdatedPersonId(), ConfigCenterUtil.ENV);
                    if (dto != null) {
                        name = dto.getPersonName();
                    }
                }
                respDTO.setUpdatedPersonName(name);
                respDTO.setPayRemark(obj.getPayRemark());
                respDTO.setExpireStatusName(ExpireStatusEnum.getTbcpNatureEnum(obj.getExpireStatus()).getValue());
                respDTO.setUpdatedAt(CompanyDateUtil.longDate2String(obj.getUpdatedAt()));
                respDTO.setStatusName(StatusEnum.getTbcpNatureEnum(obj.getStatus()).getValue());
                respDTO.setCreatedAt(CompanyDateUtil.longDate2String(obj.getCreatedAt()));
                resList.add(respDTO);
            }
        }
        return resList;
    }


    public static QueryStoreListByCompIdAndStoreIdsBO reqDTOToQueryStoreListByCompIdAndStoreIdsBO(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO = new QueryStoreListByCompIdAndStoreIdsBO();
        queryStoreListByCompIdAndStoreIdsBO.setCompId(companyStoreListQueryReqDTO.getCompId());
        queryStoreListByCompIdAndStoreIdsBO.setStoreIds(companyStoreListQueryReqDTO.getStoreIds());
        queryStoreListByCompIdAndStoreIdsBO.setAvailable(companyStoreListQueryReqDTO.getAvailable());
        queryStoreListByCompIdAndStoreIdsBO.setFilterForbidden(companyStoreListQueryReqDTO.getFilterForbidden());
        return queryStoreListByCompIdAndStoreIdsBO;
    }

    public static QueryStoreListByCompIdAndStoreIdsBO companyStoreListQueryReqDTOToQueryStoreListByCompIdAndStoreIdsBO(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        QueryStoreListByCompIdAndStoreIdsBO queryStoreListByCompIdAndStoreIdsBO = new QueryStoreListByCompIdAndStoreIdsBO();
        queryStoreListByCompIdAndStoreIdsBO.setCompId(companyStoreListQueryReqDTO.getCompId());
        queryStoreListByCompIdAndStoreIdsBO.setStoreIds(companyStoreListQueryReqDTO.getStoreIds());
        queryStoreListByCompIdAndStoreIdsBO.setAvailable(companyStoreListQueryReqDTO.getAvailable());
        return queryStoreListByCompIdAndStoreIdsBO;
    }
}
