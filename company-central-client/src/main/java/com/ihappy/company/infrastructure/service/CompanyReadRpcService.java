package com.ihappy.company.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.*;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.*;
import com.ihappy.company.domain.dto.response.companyinfo.*;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;

import java.util.List;

/**
 * Created by sunjd on 2018/3/29.
 */
public interface CompanyReadRpcService {

    /**
     * PC端-查询企业列表
     * status 公司状态1白名单 0 黑名单 2普通
     * @param baseinfoCompanyReqDTO
     * @return List<BaseinfoCompanyRespDTO>
     */
    Result<Page<BaseinfoCompanyRespDTO>> findBaseinfoCompanyPage(BaseinfoCompanyReqDTO baseinfoCompanyReqDTO);

    /**
     * 查询单个企业信息
     * @param companyInfoQueryReqDTO
     * @return
     */
    Result<CompanyInfoQueryRespDTO> findCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO);

    /**
     * 根据企业id列表查询企业信息列表
     * @param companyInfoListQueryReqDTO
     * @return
     */
    Result<List<CompanyInfoListQueryRespDTO>> findCompanyInfoListByIds(CompanyInfoListQueryReqDTO companyInfoListQueryReqDTO);

    /**
     * 查询单个企业信息 无需登陆
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoWithoutLoginQueryRespDTO> findCompanyInfoWithoutLogin(CompanyInfoWithoutLoginQueryReqDTO reqDTO);


    /**
     * 查询企业有效期
     *
     * @param companyInfoByCompIdQuery
     * @return CompanyExpireDateQueryRespDTO
     */
    Result<CompanyExpireDateQueryRespDTO> queryCompanyExpireDate(CompanyInfoByCompIdQuery companyInfoByCompIdQuery);

    /**
     * 运营后台查询企业白名单
     * @param companyExpireStatusByCompIdQuery
     * @return
     */
    Result<CompanyExpireStatusRespDTO> queryCompanyExpireStatue(CompanyExpireStatusByCompIdQuery companyExpireStatusByCompIdQuery);
    /**
     * 查询公司到期及缴费情况分页列表
     * @param reqDTO
     * @return
     */
    Result<Page<CompanyServiceStatusPageQueryRespDTO>> queryCompanyServiceStatusPage(CompanyServiceStatusPageQueryReqDTO reqDTO);


    /**
     * 查询工厂信息  返回list
     * @return
     */
    Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForList(UsopRequestBaseQuery usopRequestBaseQuery);


    /**
     * 通过
     * @param factoryInfoConfigQuery
     * @return
     */
    Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForListByCompId(FactoryInfoConfigQuery factoryInfoConfigQuery);



    /**
     * 查询工厂信息 返回对象FactoryInfosRespDTO
     * @return
     */
    Result<FactoryInfosRespDTO> queryFactoryInfosRespDTO(UsopRequestBaseQuery usopRequestBaseQuery);

    /**
     * 根据企业查询品牌列表
     * @param companyBrandListQueryReqDTO
     * @return
     */
    Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO);
    /**
     * @Description: 查询企业打印配置详情
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/6/1
     */
    Result<CompanyPrintConfigInfoRespDTO> findCompanyPrintConfigInfo(CompanyPrintConfigInfoQueryReqDTO companyPrintConfigInfoQeuryReqDTO);

    /**
     * @Description: 查询企业打印配置列表
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/6/4
     */
    Result<List<CompanyPrintConfigListRespDTO>> findCompanyPrintConfigList(CompanyPrintConfigListQueryReqDTO companyPrintConfigListQueryReqDTO);
    /**
     * 查询企业认证信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO);
    /**
     * Created by liuhc on 2018/5/16.
     */
    Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery);


}
