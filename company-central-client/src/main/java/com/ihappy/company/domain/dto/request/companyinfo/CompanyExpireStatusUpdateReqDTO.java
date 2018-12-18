package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/7/12.
 */
public class CompanyExpireStatusUpdateReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = 7715558403805800625L;

    /**
     * 公司id
     */
    @FieldComment(value = "公司id",required = true,defaultValue = "")
    private Integer compId;

    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;

    /**
     * 公司状态1白名单 0 黑名单 2普通
     */
    @FieldComment(value = "公司状态1白名单 0 黑名单 2普通",required = true,defaultValue = "")
    private Integer status;

    /**
     * 备注
     */
    @FieldComment(value = "备注",required = false,defaultValue = "")
    private String memo;

    /**
     * 延长时长
     */
    @FieldComment(value = "延长时长",required = false,defaultValue = "")
    private Integer experienceDate;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExperienceDate() {
        return experienceDate;
    }

    public void setExperienceDate(Integer experienceDate) {
        this.experienceDate = experienceDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if(compId == null || compId <= 0L ||  experienceDate == null || status == null
                || this.getLoginPersonId() == null || this.getLoginPersonId() <=0L){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
