package com.ihappy.company.domain.dto.request;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * 删除品牌
 * Created by sunjd on 2018/4/4.
 */
public class CompanyBrandDelReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -370620634235387956L;

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
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
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
     * 品牌id
     */
    private Integer brandId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public void validation() {
        if (brandId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    BRAND_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.BRAND_ID_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
