package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :  检查所有公司的默认信息是否存在, 存在就将is_default设为1, 不存在就添加默认信息
 *                           包括 1. 默认供应商 2. 默认客户(散客) 3. 默认门店 4. 默认门店仓库 5. 总仓/总店
 * @create : 2018-05-30 14:15
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.BackdoorRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyDefaultInformationCheckAndSetService {
     /**
       * @Description: 生成默认信息,插入数据库
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/5/30
       */
    Result<String> generateDefaultInformation(VoidReqDTO voidReqDTO);
    
}
