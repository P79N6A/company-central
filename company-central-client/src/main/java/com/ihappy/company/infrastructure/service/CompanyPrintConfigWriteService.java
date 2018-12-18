package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoUpdateReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 12:53
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyPrintConfigWriteService {

     /**
       * @Description:  更新企业打印设置
       * @Param:
       * @return:
       * @Author: zhangtengpo
       * @Date: 2018/6/1
       */
    Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO);
}
