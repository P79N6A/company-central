package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by chenying on 2018/6/28.
 */
public class CompanyExpireDateQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -4689856010064463843L;

    /**
     * 企业id
     */
    @com.konglong.dubbo.annotation.FieldComment(value = "企业id",required = true,defaultValue = "678328211")
    private Integer compId;

    @com.konglong.dubbo.annotation.FieldComment(value = "门店id",required = true,defaultValue = "678328211")
    private Long storeId;
    /**
     * 剩余有效天数
     */
    @com.konglong.dubbo.annotation.FieldComment(value = "剩余有效天数",required = true,defaultValue = "678328211")
    private Integer compVaildDays;


    /**
     * 过期时间
     */
    @com.konglong.dubbo.annotation.FieldComment(value = "过期时间",required = true,defaultValue = "678328211")
    private Long compExpireDate;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getCompVaildDays() {
        return compVaildDays;
    }

    public void setCompVaildDays(Integer compVaildDays) {
        this.compVaildDays = compVaildDays;
    }

    public Long getCompExpireDate() {
        return compExpireDate;
    }

    public void setCompExpireDate(Long compExpireDate) {
        this.compExpireDate = compExpireDate;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
