package com.ihappy.store.domain.dto.request.store;

import com.ihappy.usop.client.dto.UsopRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/8/30.
 */
public class AddPersonPerformanceReqDTO extends UsopRequestBaseDTO {
    private static final long serialVersionUID = 6925289053165254569L;
    @FieldComment(value = "门店id",required = true,defaultValue = "678328211")
    private Long storeId;
    @FieldComment(value = "年月",required = true,defaultValue = "2018-08")
    private String yearMonth;
    @FieldComment(value = "业绩目标",required = true,defaultValue = "154825522")
    private Long aimAmount;
    @FieldComment(value = "员工id",required = true,defaultValue = "512133")
    private Long personId;
    @FieldComment(value = "id",required = false,defaultValue = "1498211")
    private Long salePerformanceId;

    public Integer generateIntYearMonth(){
        if (yearMonth != null && !yearMonth.trim().equals("")){
            return Integer.valueOf(yearMonth.replace("-",""));
        }else {
            return null;
        }
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Long getAimAmount() {
        return aimAmount;
    }

    public void setAimAmount(Long aimAmount) {
        this.aimAmount = aimAmount;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getSalePerformanceId() {
        return salePerformanceId;
    }

    public void setSalePerformanceId(Long salePerformanceId) {
        this.salePerformanceId = salePerformanceId;
    }

    @Override
    public void validation() {
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
