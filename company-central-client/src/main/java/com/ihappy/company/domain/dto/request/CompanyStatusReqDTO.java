package com.ihappy.company.domain.dto.request;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * Created by sunjd on 2018/3/30.
 * 修改公司状态
 */
public class CompanyStatusReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 415049586670064449L;

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
     * 公司id
     */
    private Integer compId;
    /**
     * 公司状态(1使用中 0 已禁用)
     */
    private Integer  status;


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

    @Override
    public void validation() {
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (status == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_STATUS_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_STATUS_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
