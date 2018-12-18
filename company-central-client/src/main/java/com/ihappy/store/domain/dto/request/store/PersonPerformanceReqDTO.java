package com.ihappy.store.domain.dto.request.store;


import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/8/29.
 */
public class PersonPerformanceReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = -4579836141817701377L;
    @FieldComment(value = "门店id",required = true,defaultValue = "678328211")
    private Long storeId;
    @FieldComment(value = "年月",required = true,defaultValue = "2018-08")
    private String yearMonth;

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

    @Override
    public void validation() {
        if (storeId == null || storeId == 0L){
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_ID_IS_ILLEGAL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_ILLEGAL.getErrMsg());
        }
    }
}
