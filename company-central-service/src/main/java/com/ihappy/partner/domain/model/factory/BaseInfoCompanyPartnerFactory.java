package com.ihappy.partner.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.communal.infrastructure.util.NumberUtil;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.bo.partner.PartnerBO;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.trade.domain.dto.response.order.OrderStatisticRespDTO;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class BaseInfoCompanyPartnerFactory {
    public static List<PartnerInfoQueryRespDTO> partnerList2PartnerInfoQueryRespDTOList(List<BaseinfoCompanyPartner> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<PartnerInfoQueryRespDTO> res = new ArrayList<PartnerInfoQueryRespDTO>();
        list.forEach((obj) -> {
            res.add(partner2PartnerInfoQueryRespDTO(obj));
        });
        return res;
    }

    public static PartnerInfoQueryRespDTO partner2PartnerInfoQueryRespDTO(BaseinfoCompanyPartner obj) {
        PartnerInfoQueryRespDTO respDTO = new PartnerInfoQueryRespDTO();
        BeanUtils.copyProperties(obj, respDTO);
        respDTO.setDueAmount(obj.getDueAmount());
        respDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
        respDTO.setOnthewayNumber(obj.getOnthewayNumber());
        respDTO.setTotalNumber(obj.getTotalNumber());
        respDTO.setOrderCount(obj.getOrderCount());
        respDTO.setDebtDate(obj.getDebtDate());
        respDTO.setDebtDay(DateUtil.differentDays(obj.getDebtDate()) + "天");
        respDTO.setPrepaidDeposit(obj.getPrepaidDeposit());
        respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
        respDTO.setPartnerId(obj.getPartnerId());
        respDTO.setPartnerCompId(obj.getPartnerCompId());
        respDTO.setIsFavor(obj.getIsFavor());
        respDTO.setCompId(obj.getCompId());
        respDTO.setCompName(obj.getCompName());
        respDTO.setPartnerName(obj.getPartnerName());
        respDTO.setWechatAccountName(obj.getWechatAccountName());
        respDTO.setPartnerType(obj.getPartnerType());
        respDTO.setMobile(obj.getMobile());
        respDTO.setPartnerLinkman(obj.getPartnerLinkman());
        respDTO.setHeadPortraitAddress(obj.getHeadPortraitAddress());
        respDTO.setPartnerArrears(obj.getPartnerArrears());
        respDTO.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
        respDTO.setForbidden(obj.getForbidden());
        respDTO.setWechatNickname(obj.getWechatNickname());
        respDTO.setSex(obj.getSex());
        respDTO.setBirthday(obj.getBirthday());
        if (obj.getLastContactTime() != null && obj.getLastContactTime() > 0) {
            respDTO.setLastContactDate(DateUtil.formatDateYmdhsm(obj.getLastContactTime()));
        } else {
            respDTO.setLastContactDate("-");
        }
        //partnerName 为空时 填入 供应商（手机号）
        if (StringUtil.isBlank(obj.getPartnerName())) {
            String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
            if (!StringUtil.isBlank(obj.getMobile())) {
                partnerName = partnerName + "(" + obj.getMobile() + ")";
            }
            respDTO.setPartnerName(partnerName);
        }
        return respDTO;
    }

    public static PartnerStatisticsRespDTO partnerBO2StatisticsRespDTO(PartnerBO bo) {
        if (bo == null) {
            return null;
        }
        PartnerStatisticsRespDTO respDTO = new PartnerStatisticsRespDTO();
        respDTO.setDueAmount(bo.getDueAmount());
        respDTO.setDueAmountY(AmountUtils.changeF2YValue(bo.getDueAmount()));
        respDTO.setOnthewayNumber(bo.getOnthewayNumber());
        respDTO.setPrepaidDeposit(bo.getPrepaidDeposit());
        respDTO.setPrepaidDepositY(AmountUtils.changeF2YValue(bo.getPrepaidDeposit()));
        respDTO.setPartnerArrears(bo.getPartnerArrears());
        respDTO.setPartnerArrearsY(AmountUtils.changeF2YValue(bo.getPartnerArrears()));
        respDTO.setTotalPartnerNum(bo.getTotalPartnerNum());
        respDTO.setPartnerArrearsNum(bo.getPartnerArrearsNum());
        respDTO.setOnthewayPartnerNumber(bo.getOnthewayPartnerNumber());
        respDTO.setPrepaidDepositNum(bo.getPrepaidDepositNum());
        respDTO.setTotalNumber(bo.getTotalNumber());
        return respDTO;
    }

    public static BaseinfoCompanyPartner statisticsReqDTO2DO(PartnerStatisticsReqDTO dto) {
        BaseinfoCompanyPartner partner = new BaseinfoCompanyPartner();
        partner.setPartnerType(dto.getPartnerType());
        partner.setCompId(Integer.valueOf(dto.getLoginCompId().toString()));
        partner.setSearchStr(dto.getSearchStr());
        return partner;
    }

    public static BaseinfoCompanyPartner providerInfoListQueryReqDTOToModel(ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO) {
        if (null == providerInfoListQueryReqDTO) {
            return new BaseinfoCompanyPartner();
        }
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(providerInfoListQueryReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setCompId(Integer.parseInt(providerInfoListQueryReqDTO.getLoginCompId().toString()));
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
        return baseinfoCompanyPartner;
    }

    public static List<ProviderInfoListQueryRespDTO> modelListToProviderInfoQueryRespDTOList(List<BaseinfoCompanyPartner> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList<ProviderInfoListQueryRespDTO>();
        }
        List<ProviderInfoListQueryRespDTO> resList = new ArrayList<ProviderInfoListQueryRespDTO>();
        for (BaseinfoCompanyPartner obj : list) {
            if (null != obj) {
                ProviderInfoListQueryRespDTO respDTO = new ProviderInfoListQueryRespDTO();
                BeanUtils.copyProperties(obj, respDTO);
                if (obj.getLastContactTime() != null) {
                    respDTO.setLastContactTimeShow(CompanyDateUtil.lastContactTime(obj.getLastContactTime()));
                }
                //partnerName 为空时 填入 供应商（手机号）
                if (StringUtil.isBlank(obj.getPartnerName())) {
                    String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
                    if (!StringUtil.isBlank(obj.getMobile())) {
                        partnerName = partnerName + "(" + obj.getMobile() + ")";
                    }
                    respDTO.setPartnerName(partnerName);
                }
                respDTO.setPrepaidDeposit(obj.getPrepaidDeposit());
                respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
                respDTO.setPartnerArrears(obj.getPartnerArrears());
                respDTO.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
                resList.add(respDTO);
            }
        }
        return resList;
    }


    public static CompanyPartnerModel providerInfoQueryReqDTOToModel(ProviderInfoQueryReqDTO providerInfoQueryReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(providerInfoQueryReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static ProviderInfoQueryRespDTO modelToProviderInfoQueryRespDTO(BaseinfoCompanyPartner obj) {
        ProviderInfoQueryRespDTO respDTO = new ProviderInfoQueryRespDTO();
        BeanUtils.copyProperties(obj, respDTO);
        respDTO.setDueAmount(obj.getDueAmount());
        respDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
        respDTO.setOnthewayNumber(obj.getOnthewayNumber());
        respDTO.setTotalNumber(obj.getTotalNumber());
        respDTO.setOrderCount(obj.getOrderCount());
        respDTO.setDebtDate(obj.getDebtDate());
        respDTO.setDebtDay(DateUtil.differentDays(obj.getDebtDate()) + "天");
        respDTO.setPrepaidDeposit(obj.getPrepaidDeposit());
        respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
        respDTO.setPartnerId(obj.getPartnerId());
        respDTO.setPartnerCompId(obj.getPartnerCompId());
        respDTO.setIsFavor(obj.getIsFavor());
        respDTO.setCompId(obj.getCompId());
        respDTO.setCompName(obj.getCompName());
        respDTO.setPartnerName(obj.getPartnerName());
        respDTO.setPartnerType(obj.getPartnerType());
        respDTO.setMobile(obj.getMobile());
        respDTO.setPartnerLinkman(obj.getPartnerLinkman());
        respDTO.setHeadPortraitAddress(obj.getHeadPortraitAddress());
        respDTO.setPartnerArrears(obj.getPartnerArrears());
        respDTO.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
        if (obj.getLastContactTime() > 0) {
            respDTO.setLastContactDate(DateUtil.formatDateYmdhsm(obj.getLastContactTime()));
        } else {
            respDTO.setLastContactDate("-");
        }
        //partnerName 为空时 填入 供应商（手机号）
        if (StringUtil.isBlank(obj.getPartnerName())) {
            String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
            if (!StringUtil.isBlank(obj.getMobile())) {
                partnerName = partnerName + "(" + obj.getMobile() + ")";
            }
            respDTO.setPartnerName(partnerName);
        }
        return respDTO;
    }

    public static PartnerInfoQueryRespDTO modelToPartnerInfoQueryRespDTO(CompanyPartnerModel companyPartnerModel) {
        PartnerInfoQueryRespDTO partnerInfoQueryRespDTO = new PartnerInfoQueryRespDTO();
        BeanUtils.copyProperties(companyPartnerModel.getDO(), partnerInfoQueryRespDTO);
        BaseinfoCompanyPartner obj = companyPartnerModel.getDO();
        //partnerName 为空时 填入 供应商（手机号）
        if (StringUtil.isBlank(obj.getPartnerName())) {
            String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
            if (!StringUtil.isBlank(obj.getMobile())) {
                partnerName = partnerName + "(" + obj.getMobile() + ")";
            }
            partnerInfoQueryRespDTO.setPartnerName(partnerName);
            partnerInfoQueryRespDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
            partnerInfoQueryRespDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
            partnerInfoQueryRespDTO.setDebtDay(DateUtil.differentDays(obj.getDebtDate()) + "天");
        }
        return partnerInfoQueryRespDTO;
    }

    public static BaseinfoCompanyPartner customerInfoListQueryReqDTOToModel(CustomerInfoListQueryReqDTO customerInfoListQueryReqDTO) {
        if (null == customerInfoListQueryReqDTO) {
            return new BaseinfoCompanyPartner();
        }
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(customerInfoListQueryReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setCompId(Integer.parseInt(customerInfoListQueryReqDTO.getLoginCompId().toString()));
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.CUSTOMER.getKey());
        return baseinfoCompanyPartner;
    }

    public static List<CustomerInfoListQueryRespDTO> modelListToCustomerInfoQueryRespDTOList(List<BaseinfoCompanyPartner> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList<CustomerInfoListQueryRespDTO>();
        }
        List<CustomerInfoListQueryRespDTO> resList = new ArrayList<CustomerInfoListQueryRespDTO>();
        for (BaseinfoCompanyPartner obj : list) {
            if (null != obj) {
                CustomerInfoListQueryRespDTO respDTO = new CustomerInfoListQueryRespDTO();
                BeanUtils.copyProperties(obj, respDTO);
                respDTO.setPartnerType(obj.getPartnerType());
                if (obj.getLastContactTime() != null) {
                    respDTO.setLastContactTimeShow(CompanyDateUtil.lastContactTime(obj.getLastContactTime()));
                }
                //partnerName 为空时 填入 供应商（手机号）
                if (StringUtil.isBlank(obj.getPartnerName())) {
                    String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
                    if (!StringUtil.isBlank(obj.getMobile())) {
                        partnerName = partnerName + "(" + obj.getMobile() + ")";
                    }
                    respDTO.setPartnerName(partnerName);
                }

                respDTO.setPrepaidDeposit(obj.getPrepaidDeposit());
                respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
                respDTO.setPartnerArrears(obj.getPartnerArrears());
                respDTO.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
                resList.add(respDTO);
            }
        }
        return resList;
    }

    public static CustomerInfoQueryRespDTO modelToCustomerInfoQueryRespDTO(BaseinfoCompanyPartner obj) {
        CustomerInfoQueryRespDTO respDTO = new CustomerInfoQueryRespDTO();
        BeanUtils.copyProperties(obj, respDTO);
        respDTO.setDueAmount(obj.getDueAmount());
        respDTO.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
        respDTO.setOnthewayNumber(obj.getOnthewayNumber());
        respDTO.setTotalNumber(obj.getTotalNumber());
        respDTO.setOrderCount(obj.getOrderCount());
        respDTO.setDebtDate(obj.getDebtDate());
        respDTO.setDebtDay(DateUtil.differentDays(obj.getDebtDate()) + "天");
        respDTO.setPrepaidDeposit(obj.getPrepaidDeposit());
        respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
        respDTO.setPartnerId(obj.getPartnerId());
        respDTO.setPartnerCompId(obj.getPartnerCompId());
        respDTO.setIsFavor(obj.getIsFavor());
        respDTO.setCompId(obj.getCompId());
        respDTO.setCompName(obj.getCompName());
        respDTO.setPartnerName(obj.getPartnerName());
        respDTO.setPartnerType(obj.getPartnerType());
        respDTO.setMobile(obj.getMobile());
        respDTO.setPartnerLinkman(obj.getPartnerLinkman());
        respDTO.setHeadPortraitAddress(obj.getHeadPortraitAddress());
        respDTO.setPartnerArrears(obj.getPartnerArrears());
        respDTO.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
        if (obj.getLastContactTime() > 0) {
            respDTO.setLastContactDate(DateUtil.formatDateYmdhsm(obj.getLastContactTime()));
        } else {
            respDTO.setLastContactDate("-");
        }
        //partnerName 为空时 填入 供应商（手机号）
        if (StringUtil.isBlank(obj.getPartnerName())) {
            String partnerName = CompanyPartnerTypeEnum.getEnum(obj.getPartnerType()).getValue();
            if (!StringUtil.isBlank(obj.getMobile())) {
                partnerName = partnerName + "(" + obj.getMobile() + ")";
            }
            respDTO.setPartnerName(partnerName);
        }
        return respDTO;
    }


    public static CompanyPartnerModel providerInfoAddReqDTOToModel(ProviderInfoAddReqDTO providerInfoAddReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(providerInfoAddReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
        baseinfoCompanyPartner.setWechatAccountName(providerInfoAddReqDTO.getWechatNo());
        baseinfoCompanyPartner.setPartnerId(DistributedPrimaryKeyFactory.generateCompanyPartnerId(providerInfoAddReqDTO.getCompId()));
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(providerInfoAddReqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setCreatedAt(CompanyDateUtil.getDate14Long(providerInfoAddReqDTO.getCreateTime()));
        baseinfoCompanyPartner.setCreatedPersonId(providerInfoAddReqDTO.personId());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel customerInfoAddReqDTOToModel(CustomerInfoAddReqDTO customerInfoAddReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(customerInfoAddReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.CUSTOMER.getKey());
        baseinfoCompanyPartner.setPartnerId(DistributedPrimaryKeyFactory.generateCompanyPartnerId(customerInfoAddReqDTO.getCompId()));
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(customerInfoAddReqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setCreatedAt(CompanyDateUtil.getDate14Long(customerInfoAddReqDTO.getCreateTime()));
        baseinfoCompanyPartner.setCreatedPersonId(customerInfoAddReqDTO.personId());
        if (baseinfoCompanyPartner.getPartnerName() == null) {
            baseinfoCompanyPartner.setPartnerName(customerInfoAddReqDTO.getPartnerLinkman());
        }
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel providerInfoUpdateReqDTOToModel(ProviderInfoUpdateReqDTO providerInfoUpdateReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(providerInfoUpdateReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setWechatAccountName(providerInfoUpdateReqDTO.getWechatNo());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(providerInfoUpdateReqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setUpdatedPersonId(providerInfoUpdateReqDTO.personId());
        baseinfoCompanyPartner.setCompId(Integer.parseInt(providerInfoUpdateReqDTO.userCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel customerInfoUpdateReqDTOToModel(CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(customerInfoUpdateReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.CUSTOMER.getKey());
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(customerInfoUpdateReqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setUpdatedPersonId(customerInfoUpdateReqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setCompId(Integer.parseInt(customerInfoUpdateReqDTO.getLoginCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel companyPartnerDelReqDTOToModel(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(companyPartnerDelReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(companyPartnerDelReqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setUpdatedPersonId(companyPartnerDelReqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setCompId(Integer.valueOf(companyPartnerDelReqDTO.getLoginCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel defProviderListQueryReqDTOToModel(DefProviderListQueryReqDTO defProviderListQueryReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(defProviderListQueryReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.PROVIDER.getKey());
        baseinfoCompanyPartner.setCompId(Integer.parseInt(defProviderListQueryReqDTO.getLoginCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel defCustomerListQueryReqDTOToModel(DefCustomerListQueryReqDTO defCustomerListQueryReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(defCustomerListQueryReqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.CUSTOMER.getKey());
        baseinfoCompanyPartner.setCompId(Integer.parseInt(defCustomerListQueryReqDTO.getLoginCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel partnerLastContactTimeReqDTOToModel(PartnerLastContactTimeReqDTO dto) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(dto, baseinfoCompanyPartner);
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static ProviderInfoInsideAddRespDTO toProviderInfoInsideAddRespDTO(BaseinfoCompanyPartner baseinfoCompanyPartner) {
        ProviderInfoInsideAddRespDTO respDTO = new ProviderInfoInsideAddRespDTO();
        respDTO.setPartnerDiscount(baseinfoCompanyPartner.getPartnerDiscount() == null ? 0 : baseinfoCompanyPartner.getPartnerDiscount());
        respDTO.setMobile(baseinfoCompanyPartner.getMobile() == null ? "" : baseinfoCompanyPartner.getMobile());
        respDTO.setPartnerId(baseinfoCompanyPartner.getPartnerId());
        respDTO.setPartnerLevelId(baseinfoCompanyPartner.getPartnerLevelId() == null ? 0 : baseinfoCompanyPartner.getPartnerLevelId());
        respDTO.setPartnerLevelName("");
        respDTO.setPartnerLinkman(baseinfoCompanyPartner.getPartnerLinkman() == null ? "" : baseinfoCompanyPartner.getPartnerLinkman());
        respDTO.setPartnerName(baseinfoCompanyPartner.getPartnerName());
        respDTO.setPartnerType(baseinfoCompanyPartner.getPartnerType());
        return respDTO;
    }

    public static CompanyPartnerModel retailCustomerUpdateReqDTOToModel(RetailCustomerUpdateReqDTO reqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        BeanUtils.copyProperties(reqDTO, baseinfoCompanyPartner);
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        baseinfoCompanyPartner.setUpdatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel retailCustomerQueryReqDTOToModel(RetailCustomerQueryReqDTO reqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        baseinfoCompanyPartner.setPartnerId(reqDTO.getPartnerId());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static BaseinfoCompanyPartner orderStatisticRespDTO2BaseInfoCompanyPartner(OrderStatisticRespDTO orderStatisticRespDTO) {
        BaseinfoCompanyPartner partner = new BaseinfoCompanyPartner();
        partner.setPartnerId(orderStatisticRespDTO.getPartnerId());
        partner.setDueAmount(orderStatisticRespDTO.getDueAmount());
        partner.setOnthewayNumber(orderStatisticRespDTO.getOnTheWayNumber());
        partner.setTotalNumber(orderStatisticRespDTO.getTotalNumber());
        partner.setOrderCount(orderStatisticRespDTO.getOrderCount());
        partner.setDebtDate(orderStatisticRespDTO.getDebtDate() == null ? 0 : orderStatisticRespDTO.getDebtDate());
        partner.setSellerRefundTimes(orderStatisticRespDTO.getRetailRefundTimes());
        return partner;
    }

    public static CompanyPartnerModel reqDTOToModel(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompId(Integer.valueOf(companyPartnerDelReqDTO.getLoginCompId().toString()));
        baseinfoCompanyPartner.setPartnerId(companyPartnerDelReqDTO.getPartnerId());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel reqDTOToCompanyPartnerModel(RetailCustomerInfoEnableReqDTO reqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        baseinfoCompanyPartner.setPartnerId(reqDTO.getPartnerId());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel retailCustomerAddReqDTOToModule(RetailCustomerAddReqDTO reqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompName(reqDTO.getCompName());
        baseinfoCompanyPartner.setShoppingGuideId(reqDTO.getShoppingGuideId());
        baseinfoCompanyPartner.setStoreId(reqDTO.getStoreId());
        baseinfoCompanyPartner.setPartnerId(DistributedPrimaryKeyFactory.generateCompanyPartnerId(reqDTO.getLoginCompId()));
        baseinfoCompanyPartner.setPartnerName(reqDTO.getPartnerName());
        baseinfoCompanyPartner.setCompId(reqDTO.getLoginCompId().intValue());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        baseinfoCompanyPartner.setMobile(reqDTO.getMobile());
        Date date = new Date();
        baseinfoCompanyPartner.setCreatedAt(CompanyDateUtil.getDate14Long(date));
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(date));
        baseinfoCompanyPartner.setCreatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setUpdatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setHeadPortraitAddress(reqDTO.getHeadPortraitAddress());
        baseinfoCompanyPartner.setWechatAccountName(reqDTO.getWechatAccountName());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static CompanyPartnerModel retailCustomerUpdateReqDTOToModule(RetailCustomerUpdateReqDTO reqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setStoreId(reqDTO.getStoreId());
        baseinfoCompanyPartner.setPartnerId(reqDTO.getPartnerId());
        baseinfoCompanyPartner.setPartnerName(reqDTO.getPartnerName());
        baseinfoCompanyPartner.setCompId(reqDTO.getLoginCompId().intValue());
        baseinfoCompanyPartner.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        baseinfoCompanyPartner.setMobile(reqDTO.getMobile());
        Date date = new Date();
        baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(date));
        baseinfoCompanyPartner.setUpdatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyPartner.setHeadPortraitAddress(reqDTO.getHeadPortraitAddress());
        baseinfoCompanyPartner.setWechatAccountName(reqDTO.getWechatAccountName());
        baseinfoCompanyPartner.setShoppingGuideId(reqDTO.getShoppingGuideId());
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    public static RetailCustomerQueryRespDTO modelToRetailCustomerQueryReqDTO(CompanyPartnerModel resModel) {
        RetailCustomerQueryRespDTO respDTO = new RetailCustomerQueryRespDTO();
        BaseinfoCompanyPartner baseinfoCompanyPartner=resModel.getDO();
        respDTO.setHeadPortraitAddress(baseinfoCompanyPartner.getHeadPortraitAddress());
        respDTO.setPartnerName(baseinfoCompanyPartner.getPartnerName());
        respDTO.setWechatAccountName(baseinfoCompanyPartner.getWechatAccountName());
        respDTO.setMobile(baseinfoCompanyPartner.getMobile());
        respDTO.setStoreId(baseinfoCompanyPartner.getStoreId());
        respDTO.setShoppingGuideId(baseinfoCompanyPartner.getShoppingGuideId());
        respDTO.setOrderCount(baseinfoCompanyPartner.getOrderCount().intValue());//消费次数（即交易单数）
        respDTO.setTotalNumber(baseinfoCompanyPartner.getTotalNumber());//消费件数（总交易件数）
        respDTO.setDueAmountY(AmountUtils.changeF2Y(baseinfoCompanyPartner.getDueAmount()));//消费金额元 由分转成元(交易总额  单位分')
        respDTO.setSellerRefundTimes(baseinfoCompanyPartner.getSellerRefundTimes());//退款次数(零售退货次数)
        respDTO.setAssociatedPurchaseRate(String.valueOf(NumberUtil.divideWith2ScaleUp(respDTO.getTotalNumber(),
                respDTO.getOrderCount().longValue())));//连带率(消费件数/消费次数)
        respDTO.setPerTicketSales(String.valueOf(NumberUtil.divideWith2ScaleUp(baseinfoCompanyPartner.getDueAmount(),
                baseinfoCompanyPartner.getOrderCount(), 100L)));//客单价(消费金额分/消费次数)
        respDTO.setUnitPrice(String.valueOf(NumberUtil.divideWith2ScaleUp(baseinfoCompanyPartner.getDueAmount(),
                baseinfoCompanyPartner.getTotalNumber(), 100L)));//件单价(消费金额分/消费件数)
        respDTO.setPrepaidDeposit(baseinfoCompanyPartner.getPrepaidDeposit());
        respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(baseinfoCompanyPartner.getPrepaidDeposit()));
        respDTO.setIsDefault(baseinfoCompanyPartner.getIsDefault());
        respDTO.setForbidden(baseinfoCompanyPartner.getForbidden());
        return respDTO;
    }
}
