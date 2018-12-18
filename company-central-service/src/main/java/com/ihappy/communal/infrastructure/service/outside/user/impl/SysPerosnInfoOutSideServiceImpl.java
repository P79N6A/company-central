package com.ihappy.communal.infrastructure.service.outside.user.impl;
import com.ihappy.communal.infrastructure.service.outside.user.SysPerosnInfoOutSideService;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.sys.SysPersonRespDTO;
import com.ihappy.user.domain.query.sys.SysUserBasicInfoByPersonIdQuery;
import com.ihappy.user.service.sys.SysCenterInsideRpcReadServiceClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by chenying on 2018/9/28.
 */
public class SysPerosnInfoOutSideServiceImpl implements SysPerosnInfoOutSideService {

    Logger logger = CompanyLoggerUtil.getUserLogger();

    @Autowired
    private SysCenterInsideRpcReadServiceClient sysCenterInsideRpcReadServiceClient;

    @Override
    public SysPersonRespDTO querySysPerson(SysUserBasicInfoByPersonIdQuery reqDTO, boolean throwException) {
        SysPersonRespDTO resultDTO = new SysPersonRespDTO();

        try {
            SysUserBasicInfoByPersonIdQuery sysUserBasicInfoByPersonIdQuery = new SysUserBasicInfoByPersonIdQuery();
            sysUserBasicInfoByPersonIdQuery.setCompId(reqDTO.getCompId());
            sysUserBasicInfoByPersonIdQuery.setPersonId(reqDTO.getPersonId());
            sysUserBasicInfoByPersonIdQuery.setDeletedFlag(0);
            Result<SysPersonRespDTO> result = sysCenterInsideRpcReadServiceClient.querySysPersonByPersonId(sysUserBasicInfoByPersonIdQuery);
            if (result.isSuccess() && result.getModule() != null) {
                resultDTO = result.getModule();
            }
            return resultDTO;
        } catch (Exception e) {
            logger.error("SysPerosnInfoOutSideService_querySysPerson外部服务调用失败", e);
            if (throwException) {
                throw e;
            }
            return resultDTO;
        }
    }
}