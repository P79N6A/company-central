package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.common.domain.dto.BaseRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class FactoryInfoRespDTO extends BaseRespDTO {

    private static final long serialVersionUID = 7831809424165250426L;

    @FieldComment(value = "工厂信息code")
    private String filedCode;
    @FieldComment(value = "工厂信息名称")
    private String filedName;
    @FieldComment(value = "是否启用")
    private boolean enable;

    public String getFiledCode() {

        return filedCode;
    }

    public void setFiledCode(String filedCode) {
        this.filedCode = filedCode;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
