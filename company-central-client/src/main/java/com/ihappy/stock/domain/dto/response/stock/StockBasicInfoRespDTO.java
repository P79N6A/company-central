package com.ihappy.stock.domain.dto.response.stock;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by Administrator on 2018/5/7.
 */
public class StockBasicInfoRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 9080606091162210793L;
    /**
     *仓库id
     */
    private Long stockId;
    /**
     *企业id
     */
    private Integer compId;

    /**
     *仓库编号
     */
    private String stockNo;

    /**
     *仓库名
     */
    private String stockName;

    /**
     *是否公共仓库  1：公共仓库  0：非公共仓库
     */
    private Integer isPublic;

    /**
     *门店id
     */
    private Long storeId;
    /**
     * 门店名称
     */
    private String storeName;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
