package com.ihappy.communal.infrastructure.service.outside.impl;

import com.ihappy.communal.infrastructure.service.outside.CompanyBaseInfoGrantService;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.item.domain.dto.request.DefaultInfoGrantReqDTO;
import com.ihappy.item.infrastructure.service.CompanyBaseInfoGrantRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/9.
 */
public class CompanyBaseInfoGrantServiceImpl implements CompanyBaseInfoGrantService {
    private final static org.apache.log4j.Logger logger = CompanyLoggerUtil.getLogger();

    @Autowired
    private CompanyBaseInfoGrantRpcService companyBaseInfoGrantRpcServiceClient;

    @Override
    public Boolean defaultInfoGrant(DefaultInfoGrantReqDTO defaultInfoGrantReqDTO) {
        Result<Void> result = null;
        int times = CompanyConstant.ERROR_RETRY;
        for(; times > 0;times--){
            try{
                result = companyBaseInfoGrantRpcServiceClient.defaultInfoGrant(defaultInfoGrantReqDTO);
            }catch (Throwable e){
                logger.error(e.getMessage(),e);
            }
            if(result == null || !result.isSuccess()){
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e1) {
                    logger.error(e1.getMessage(),e1);
                    Thread.currentThread().interrupt();
                }
            }else {
                break;
            }
        }
        return result == null?false:result.isSuccess();
    }
}
