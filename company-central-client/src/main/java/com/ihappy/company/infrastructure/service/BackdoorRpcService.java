package com.ihappy.company.infrastructure.service;


import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/8/11.
 * 一些后门接口
 */
public interface BackdoorRpcService {
    /**
     * 刷新Partner 统计数据
     * @param reqDTO
     * @return
     */
    Result<String> refreshPartnerStatics(VoidReqDTO reqDTO);

    /**
     * 填充公司数据
     * @param reqDTO
     * @return
     */
    Result<String> completionInfo(CompanyCompletionInfoReqDTO reqDTO);
    /**
     * @Description: 生成默认信息,插入数据库
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/5/30
     */
    /**
     * @author : zhangtengpo
     * @Description :  检查所有公司的默认信息是否存在, 存在就将is_default设为1, 不存在就添加默认信息
     *                           包括 1. 默认供应商 2. 默认客户(散客) 3. 默认门店 4. 默认门店仓库 5. 默认公共仓库
     * @create : 2018-05-30 14:15
     */
    Result<String> generateDefaultInformation(VoidReqDTO voidReqDTO);
    
    /**
        * @Description: 删除redis缓存, 目前只删打印设置信息
        * @Param:
        * @return:
        * @Author: zhangtengpo
        * @Date: 18-10-19 上午11:07
        */
    Result<String> deleteRedisInfo(VoidReqDTO voidReqDTO);
}
