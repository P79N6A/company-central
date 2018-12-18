package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/1.
 */
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerWriteGatewayService",memo = "接口迁移注解:value为迁移接口,方法不变")

public interface PartnerWriteRpcService {
    /**
     * 添加供应商
     * @param providerInfoAddReqDTO
     * @return
     */
    Result<ProviderInfoAddRespDTO> addProvider(ProviderInfoAddReqDTO providerInfoAddReqDTO);

    /**
     * 修改供应商
     * @param providerInfoUpdateReqDTO
     * @return
     */
    Result<String> updateProvider(ProviderInfoUpdateReqDTO providerInfoUpdateReqDTO);

    /**
     * 添加客户
     * @param customerInfoAddReqDTO
     * @return
     */
    Result<CustomerInfoAddRespDTO> addCustomer(CustomerInfoAddReqDTO customerInfoAddReqDTO);

    /**
     * 编辑客户
     * @param customerInfoUpdateReqDTO
     * @return
     */
    Result<String> updateCustomer(CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO);

    /**
     * 删除Partner
     * @param companyPartnerDelReqDTO
     * @return
     */
    Result<String> delCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO);

    /**
     * 邀请注册添加 Partner
     * Rpc内部调用
     * 用户中心 客户/供应商 邀请注册成功时调用
     * @param reqDTO
     * @return
     */
    Result<AddInvateRegisterPartnerRespDTO> addPartnerByInvateRegister(AddInvateRegisterPartnerReqDTO reqDTO);
    /**
     * 添加欠款订单-内部调用
     * @param req
     * @return
     */
    Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req);
    /**
     * 会员等级引用计数回调
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO);
    /**
     * 添加会员等级
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO);

    /**
     * 修改会员等级
     * @param reqDTO
     * @return
     */
    Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO);

    /**
     * 删除会员等级
     * @param reqDTO
     * @return
     */
    Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO);


    /**
     *  合伙人查询 无则新建
     * @param partnerQueryOrAddReqDTO
     * @return
     */
    Result<PartnerInfoQueryRespDTO> partnerQueryOrAdd(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO);

}
