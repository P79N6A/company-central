package com.ihappy.partner.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerReadGatewayService",memo = "接口迁移注解:value为迁移接口,方法不变")

public interface PartnerReadRpcService {
    /**
     * 供应商列表查询
     * @param providerInfoListQueryReqDTO
     * @return
     */
    Result<List<ProviderInfoListQueryRespDTO>> findProviderList(ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO);

    /**
     * 查询单个供应商
     * @param providerInfoQueryReqDTO
     * @return
     */
    Result<ProviderInfoQueryRespDTO> findProvider(ProviderInfoQueryReqDTO providerInfoQueryReqDTO);

    /**
     * 客户列表查询
     * @param customerInfoQueryReqDTO
     * @return
     */
    Result<List<CustomerInfoListQueryRespDTO>> findCustomerList(CustomerInfoListQueryReqDTO customerInfoQueryReqDTO);

    /**
     * 查询客户(单个)
     * @param customerInfoQueryReqDTO
     * @return
     */
    Result<CustomerInfoQueryRespDTO> findCustomer(CustomerInfoQueryReqDTO customerInfoQueryReqDTO);

    /**
     * 默认供应商列表查询
     * @param defProviderListQueryReqDTO
     * @return
     */
    Result<DefProviderListQueryRespDTO> findDefProviderList(DefProviderListQueryReqDTO defProviderListQueryReqDTO);

    /**
     * 默认客户列表查询
     * @param defCustomerListQueryReqDTO
     * @return
     */
    Result<DefCustomerListQueryRespDTO> findDefCustomerList(DefCustomerListQueryReqDTO defCustomerListQueryReqDTO);

    /**
     * 查询合作伙伴(单个)
     * @param partnerInfoQueryReqDTO
     * @return
     */
    Result<PartnerInfoQueryRespDTO> findPartner(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO);

    /**
     * 查询默认Partner
     * @param reqDTO
     * @return
     */
    Result<PartnerInfoQueryRespDTO> findDefaultPartner(PartnerDefQueryReqDTO reqDTO);

    /**
     * 查询客户/供应商列表 对账头部统计信息
     * @return
     */
    Result<PartnerStatisticsRespDTO> findPartnerStatistics(PartnerStatisticsReqDTO reqDTO);

    /**
     * 查询Partner分页列表
     * @param reqDTO
     * @return
     */
    Result<Page<PartnerInfoQueryRespDTO>> findPartnerPage(PartnerPageReqDTO reqDTO);

    /**
     * @Author sunjd
     * @Description 查询partner列表
     * @Date 11:21 2018/10/31
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<com.ihappy.common.domain.Page<com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO>>
     **/
    Result<List<PartnerInfoQueryRespDTO>> findPartnerList(PartnerListQueryReqDTO reqDTO);
    /**
     * 查询单个会员等级
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO);

    /**
     * 查询会员等级列表
     * @param reqDTO
     * @return
     */
    Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO);
}
