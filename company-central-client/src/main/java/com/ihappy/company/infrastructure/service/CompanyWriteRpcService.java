package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusUpdateReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.FactoryInfoConfigReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoAddRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/1.
 */
public interface CompanyWriteRpcService {
    /**
     * PC端-修改企业支付备注
     * @param reqDTO
     * @return
     */
    Result<String> updateCompanyPayRemark(CompanyInfoUpdateReqDTO reqDTO);
    /**
     * 更改企业状态  0-禁用/1-启用
     * @param companyStatusReqDTO
     * @return
     */
    Result<String> updateCompanyStatus(CompanyStatusReqDTO companyStatusReqDTO);
    /**
     * 修改公司基本信息
     * @param companyInfoUpdateReqDTO
     * @return
     */
    Result<String> updateCompanyInfo(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO);
    /**
     * 修改公司基本信息 通过Rpc调用
     * @param companyInfoUpdateReqDTO
     * @return
     */
    Result<Void> updateCompanyInfoByRpc(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO);
    /**
     * 添加公司
     * @param companyInfoAddReqDTO
     * @return CompanyInfoAddRespDTO 公司id
     */
    Result<CompanyInfoAddRespDTO> addCompanyInfo(CompanyInfoAddReqDTO companyInfoAddReqDTO);

    /**
     * 添加公司-通过Rpc调用
     * @param companyInfoAddByRpcReqDTO
     * @return CompanyInfoAddRespDTO 公司id
     */
    Result<CompanyInfoAddRespDTO> addCompanyInfoByRpc(CompanyInfoAddByRpcReqDTO companyInfoAddByRpcReqDTO);

    /**
     * 设置白名单
     * @param companyExpireStatusUpdateReqDTO
     * @return
     */
    Result<Void> updateCompanyExpireStatus(CompanyExpireStatusUpdateReqDTO companyExpireStatusUpdateReqDTO);

    /**
     *
     */
    Result<Void> updateFactoryInfo(FactoryInfoConfigReqDTO factoryInfoConfigReqDTO);

    /**
     * 企业添加品牌
     * @param companyBrandAddReqDTO
     * @return
     */
    Result<CompanyBrandAddRespDTO> addCompanyBrand(CompanyBrandAddReqDTO companyBrandAddReqDTO);

    /**
     * 内部rpc调用新增品牌
     * @param companyBrandAddInsideReqDTO
     * @return
     */
    Result<CompanyBrandAddInsideRespDTO> addCompanyBrandInside(CompanyBrandAddInsideReqDTO companyBrandAddInsideReqDTO);
    /**
     * 删除品牌
     * @param companyBrandDelReqDTO
     * @return
     */
    Result<String> delCompanyBrand(CompanyBrandDelReqDTO companyBrandDelReqDTO);

    /**
     * 批量删除品牌
     * @param companyBrandsDelReqDTO
     * @return
     */
    Result<String> delCompanyBrands(CompanyBrandsDelReqDTO companyBrandsDelReqDTO);
    /**
     * 延长公司服务到期时间,并且生成流水
     * @param req
     * @return
     */
    Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req);
    /**
     * @Description:  更新企业打印设置
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/6/1
     */
    Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO);
    /**
     * 审核公司信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO);

    /**
     * 提交认证--添加审核信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO);

    /**
     * @Description:  管理-打印设置-修改打印模式
     * @Param:companyPrintModeUpdateReqDTO
     * @return:
     * @Author: cy
     * @Date: 2018/11/15
     */
    Result<String> updateCompanyPrintMode(CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO);

}

