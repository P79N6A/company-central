package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-05-30 14:20
 */
@Deprecated
public class CompanyDefaultInformationCheckAndSetServiceClient implements CompanyDefaultInformationCheckAndSetService {

    private CompanyDefaultInformationCheckAndSetService companyDefaultInformationCheckAndSetService;

    @Override
    public Result<String> generateDefaultInformation(VoidReqDTO voidReqDTO) {
        return companyDefaultInformationCheckAndSetService.generateDefaultInformation(voidReqDTO);
    }
}
