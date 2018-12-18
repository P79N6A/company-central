package com.ihappy.company.domain.dto.request.sys;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.RegexUtil;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.usop.client.dto.UsopRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/12/3.
 */
public class UpdateStatusReqDTO extends UsopRequestBaseDTO {
    @FieldComment(value = "版本号",required = true,defaultValue = "")
    private String version;
    @FieldComment(value = "操作系统  ios  android",required = true,defaultValue = "")
    private String os;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public void validation() {
        if (StringUtil.isBlank(version) || !RegexUtil.isVersion(version)){
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        if (os == null){
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
