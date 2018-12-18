package com.ihappy.partner.domain.dto.request.level;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelDelReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 3544364561586780447L;
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

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    @Override
    public void validation() {
        if (partnerLevelId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_ID_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
