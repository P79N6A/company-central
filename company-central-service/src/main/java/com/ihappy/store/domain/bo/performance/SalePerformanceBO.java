package com.ihappy.store.domain.bo.performance;

import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.domain.dto.request.store.PersonPerformanceReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePerformanceReqDTO;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/8/28.
 */
public class SalePerformanceBO extends SalePerformance {
    /**
     * 门店id列表
     */
    private List<Long> storeIds;
    /**
     * 分片
     */
    private int shardingNum;

    private Integer limit;

    private Integer offset;
    /**
     * 操作类型
     * 1：重复不更新
     */
    private Integer insertType;

    public SalePerformanceBO(){

    }

    public SalePerformanceBO(SalePerformance record){
        BeanUtils.copyProperties(record,this);
    }

    public SalePerformanceBO(StorePerformanceReqDTO reqDTO, List<Long> storeIds){
        this.setCompId(reqDTO.getLoginCompId());
        this.setYearMonth(Integer.valueOf(reqDTO.getYearMonth().replace("-","")));
        this.setStoreIds(storeIds);
    }

    public SalePerformanceBO(PersonPerformanceReqDTO reqDTO){
        this.setCompId(reqDTO.getLoginCompId());
        this.setYearMonth(Integer.valueOf(reqDTO.getYearMonth().replace("-","")));
        this.setStoreIds(Arrays.asList(reqDTO.getStoreId()));
    }

    public Integer getInsertType() {
        return insertType;
    }

    public void setInsertType(Integer insertType) {
        this.insertType = insertType;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public int getShardingNum() {
        return shardingNum;
    }

    public void setShardingNum(int shardingNum) {
        this.shardingNum = shardingNum;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
