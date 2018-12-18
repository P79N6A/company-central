package com.ihappy.partner.domain.dto.request.level;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -8623879789206040108L;
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
     * 会员等级
     */
    private String partnerLevel;

    public String getPartnerLevel() {
        return partnerLevel;
    }

    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    @Override
    public void validation() {
    }
}
