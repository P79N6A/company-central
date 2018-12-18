package com.ihappy.company.domain.dto.request.companyinfo;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/6/28.
 */
public class CompanyInfoByCompIdQuery extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 4573545766478906257L;
    /**
     * 公司id
     */
    @com.konglong.dubbo.annotation.FieldComment(value = "公司id",required = true,defaultValue = "678328211")
    private Integer compId;

    /**
     * 门店Id
     */
    @FieldComment(value = "门店id",required = true,defaultValue = "678328211")
    private Long storeId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public void setLongCompId(Long compId){
        this.compId=compId.intValue();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (getLoginCompId()==null || getLoginPersonId()==null || getLoginCompId()<=0 || getLoginPersonId()<=0){
                throw new CompanyException(CompanyErrorCodeEnum.
                        ILLGAL_ARGUMENT.getErrCode(),
                        CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
