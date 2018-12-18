package com.ihappy.partner.domain.dto.request.level;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 2945783972675981358L;
    /**
     * 获取修改创建人id
     * @return
     */
    public Long personId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getPersonId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getPersonId();
        }else{
            throw new PartnerException(PartnerErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     * 获取用户公司id
     * @return
     */
    public Long userCompId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getCompId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getCompId();
        }else{
            throw new PartnerException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     * 客户等级id
     */
    private Long partnerLevelId;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 会员等级
     */
    private String partnerLevel;
    /**
     * 会员等级说明
     */
    private String partnerMemo;
    /**
     * 伙伴分类 0、供应商 1、客户
     */
    private Integer partnerType;
    /**
     * 折扣率 1-99 整数
     */
    private Integer discount;

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPartnerLevel() {
        return partnerLevel;
    }

    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    public String getPartnerMemo() {
        return partnerMemo;
    }

    public void setPartnerMemo(String partnerMemo) {
        this.partnerMemo = partnerMemo;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public void validation() {
        if (partnerLevelId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_ID_IS_NULL.getErrMsg());
        }
        if(StringUtil.isBlank(partnerLevel)){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_IS_NULL.getErrMsg());
        }
        if (partnerLevel.length() > 6){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_TOO_LONG.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_TOO_LONG.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
