package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.sys.UpdateStatusReqDTO;
import com.ihappy.company.domain.dto.response.sys.UpdateStatusRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/10/11.
 * 企业查询接口-面向网关
 */
public interface CompanyReadGatewayService {
    /**
     * @Author sunjd
     * @Description 查询应用是否需要 app store更新或热更新
     * @Date 14:04 2018/12/3
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<com.ihappy.company.domain.dto.response.sys.UpdateStatusRespDTO>
     **/
    Result<UpdateStatusRespDTO> quereyUpdateStatus(UpdateStatusReqDTO reqDTO);
}
