package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/11/15.
 */
public class CompanyPrintModeUpdateReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = 7575772326134319985L;

    @FieldComment(value = "公司id")
    private Long compId;  // 公司id
    @FieldComment(value = "打印模式0-蓝牙 1-服务")
    private Integer printMode;  // 打印模式0-蓝牙 1-服务

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getPrintMode() {
        return printMode;
    }

    public void setPrintMode(Integer printMode) {
        this.printMode = printMode;
    }

    @Override
    public void validation() {
        if (this.getLoginCompId() ==null ||this.getLoginPersonId() ==null ||
                this.getLoginCompId() <=0 || this.getLoginPersonId() <=0 ){
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        if (printMode == null){
            throw new CompanyException(CompanyErrorCodeEnum.PRINT_MODE_IS_NULL);
        }
    }
}
