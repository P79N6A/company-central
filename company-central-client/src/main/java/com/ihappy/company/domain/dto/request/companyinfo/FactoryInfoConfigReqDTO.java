package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.usop.client.dto.UsopRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class FactoryInfoConfigReqDTO  extends UsopRequestBaseDTO {

    @FieldComment(value = "工厂信息json串")
    private String factoryInfo;

    public String getFactoryInfo() {
        return factoryInfo;
    }

    public void setFactoryInfo(String factoryInfo) {
        this.factoryInfo = factoryInfo;
    }

    @Override
    public void validation() {

        if(getPersonUserInfoDTOV2()==null || getPersonUserInfoDTOV2().getCompId()==null || getPersonUserInfoDTOV2().getCompId()<=0){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }

        if(StringUtil.isBlank(factoryInfo)){
            throw new CompanyException(CompanyErrorCodeEnum.FACTORY_INFO_ISNULL_ERROR);
        }
    }
}
