package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :  公司打印设置查询接口
 * @create : 2018-06-01 12:53
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyPrintConfigReadService {
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
}
