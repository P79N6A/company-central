package com.ihappy.store.domain.dto.request.store;

import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/8/27.
 */
public class StorePerformanceReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = 2258435391034807072L;
    @FieldComment(value = "年-月  示例：2018-08",required = true,defaultValue = "2018-08")
    private String yearMonth;
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;

    public Long toStartLongDate(){
        if (yearMonth.trim() != null){
            String dateTime = yearMonth.replace("-","")+"00000000";
            return Long.valueOf(dateTime);
        }
        return null;
    }

    public Long toEndLongDate(){
        if (yearMonth.trim() != null){
            String dateTime = yearMonth.replace("-","")+"32000000";
            return Long.valueOf(dateTime);
        }
        return null;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
