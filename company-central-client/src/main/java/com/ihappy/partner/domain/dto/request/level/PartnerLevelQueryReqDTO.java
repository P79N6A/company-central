package com.ihappy.partner.domain.dto.request.level;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -7827125065561371150L;
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
            return null;
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
            throw new PartnerException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }

}
