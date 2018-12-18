package com.ihappy.company.domain.dto.request;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/16.
 */
public class CompanyBrandsDelReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -6557776465144127070L;

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
     * 品牌id字符串以逗号隔开
     */
    private String brandIds;

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public void validation() {
        if (brandIds == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    BRAND_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.BRAND_ID_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
