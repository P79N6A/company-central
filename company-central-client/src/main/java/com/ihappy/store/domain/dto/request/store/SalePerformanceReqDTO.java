package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/11/3.
 */
public class SalePerformanceReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = 3730614163797296165L;
    @FieldComment(value = "业绩目标id",required = false,defaultValue = "12502")
    private Long salePerformanceId;
    @FieldComment(value = "公司id",required = false,defaultValue = "")
    private Long compId;
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;
    @FieldComment(value = "门店id列表")
    private List<Long> storeIds;
    @FieldComment(value = "员工id")
    private Long personId;
    @FieldComment(value = "年月",required = false,defaultValue = "2018-08")
    private Integer yearMonth;
    @FieldComment(value = "是否删除 0：未删除 1：已删除")
    private Integer isDelete;

    public Long getSalePerformanceId() {
        return salePerformanceId;
    }

    public void setSalePerformanceId(Long salePerformanceId) {
        this.salePerformanceId = salePerformanceId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public void validation() {
        if (compId == null || compId == 0L){
            throw new StoreException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
