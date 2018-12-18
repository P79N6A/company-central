package com.ihappy.stock.domain.dto.response.stock;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.usop.client.annotation.FieldComment;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 9080606091162210793L;
    /**
     *仓库id
     */
    @FieldComment("仓库id")
    private Long stockId;
    /**
     *企业id
     */
    @FieldComment("企业id")
    private Integer compId;

    /**
     *仓库编号
     */
    @FieldComment("仓库编号")
    private String stockNo;

    /**
     *仓库名
     */
    @FieldComment("仓库名")
    private String stockName;

    /**
     *仓库面积
     */
    @FieldComment("仓库面积")
    private Integer stockAcreage;

    /**
     *地区id
     */
    @FieldComment("地区id")
    private Integer areaId;

    /**
     *省
     */
    private String province;

    /**
     *市
     */
    private String city;

    /**
     *区县
     */
    private String zone;

    /**
     *具体地址
     */
    private String address;

    /**
     *联系电话
     */
    private String stockTel;

    /**
     *联系人
     */
    private String stockLinkman;

    /**
     *门店id
     */
    @FieldComment("门店id")
    private Long storeId;

    /**
     *是否公共仓库  1：公共仓库  0：非公共仓库
     */
    private Integer isPublic;

    /**
     *仓库介绍
     */
    private String stockMemo;
    /**
     * 是否禁用 1：禁用 0：启用
     */
    private Integer forbidden;
    /**
     * 门店名称
     */
    @FieldComment("门店名称")
    private String storeName;
    /**
     * 盘点锁定  记录盘点单id 表示被此盘点单锁定
     */
    @FieldComment(value = "盘点锁")
    private Long inventorying;
    @FieldComment(value = "更新时间")
    private Long updatedAt;

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

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

    public Integer getStockAcreage() {
        return stockAcreage;
    }

    public void setStockAcreage(Integer stockAcreage) {
        this.stockAcreage = stockAcreage;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStockTel() {
        return stockTel;
    }

    public void setStockTel(String stockTel) {
        this.stockTel = stockTel;
    }

    public String getStockLinkman() {
        return stockLinkman;
    }

    public void setStockLinkman(String stockLinkman) {
        this.stockLinkman = stockLinkman;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getStockMemo() {
        return stockMemo;
    }

    public void setStockMemo(String stockMemo) {
        this.stockMemo = stockMemo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getInventorying() {
        return inventorying;
    }

    public void setInventorying(Long inventorying) {
        this.inventorying = inventorying;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
