package com.ihappy.stock.domain.bo.stock;

import com.ihappy.usop.client.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/10/29.
 */
public class StockBO {
    @FieldComment("仓库id列表")
    private List<Long> stockIds;

    @FieldComment("仓库id")
    private Long stockId;

    @FieldComment("企业id")
    private Integer compId;

    @FieldComment("仓库编号")
    private String stockNo;

    @FieldComment("仓库名")
    private String stockName;

    @FieldComment("仓库面积")
    private Integer stockAcreage;

    @FieldComment("地区id")
    private Integer areaId;

    @FieldComment("省")
    private String province;

    @FieldComment("市")
    private String city;

    @FieldComment("区")
    private String zone;

    @FieldComment("具体地址")
    private String address;

    @FieldComment("联系电话")
    private String stockTel;

    @FieldComment("联系人")
    private String stockLinkman;

    @FieldComment("门店id")
    private Long storeId;

    @FieldComment("是否公共仓库  1：公共仓库  0：非公共仓库")
    private Integer isPublic;

    @FieldComment("仓库介绍")
    private String stockMemo;

    @FieldComment("是否禁用 1：禁用 0：启用")
    private Integer forbidden;

    @FieldComment("门店名称")
    private String storeName;

    @FieldComment("盘点锁  记录盘点单id 表示被此盘点单锁定")
    private Long inventorying;

    @FieldComment("盘点锁列表")
    private List<Long> stockChangeIds;

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
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

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
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

    public List<Long> getStockChangeIds() {
        return stockChangeIds;
    }

    public void setStockChangeIds(List<Long> stockChangeIds) {
        this.stockChangeIds = stockChangeIds;
    }
}
