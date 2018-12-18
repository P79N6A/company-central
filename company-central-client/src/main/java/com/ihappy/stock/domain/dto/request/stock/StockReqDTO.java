package com.ihappy.stock.domain.dto.request.stock;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/8/6.
 */
public class StockReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -2477176272341101906L;
    /**
     *仓库id
     */
    @FieldComment(value = "仓库id",required = false,defaultValue = "681258165")
    private Long stockId;
    /**
     *企业id
     */
    @FieldComment(value = "企业id",required = false,defaultValue = "")
    private Integer compId;

    /**
     *仓库编号
     */
    @FieldComment(value = "仓库编号",required = false,defaultValue = "")
    private String stockNo;

    /**
     *仓库名
     */
    @FieldComment(value = "仓库名",required = false,defaultValue = "")
    private String stockName;

    /**
     *仓库面积
     */
    @FieldComment(value = "仓库面积",required = false,defaultValue = "")
    private Integer stockAcreage;

    /**
     *地区id
     */
    @FieldComment(value = "地区id",required = false,defaultValue = "")
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
    @FieldComment(value = "门店id",required = false,defaultValue = "")
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
    @FieldComment(value = "门店名称",required = false,defaultValue = "")
    private String storeName;
    /**
     * 盘点锁定  记录盘点单id 表示被此盘点单锁定
     */
    private Long inventorying;
    /**
     * 查看id列表
     */
    private List<Long> stockIds;
    /**
     * 门店id列表
     */
    private List<Long> storeIds;

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("stockId",stockId);
        map.put("compId",compId);
        map.put("stockNo",stockNo);
        map.put("stockName",stockName);
        map.put("stockAcreage",stockAcreage);
        map.put("areaId",areaId);
        map.put("province",province);
        map.put("city",city);
        map.put("zone",zone);
        map.put("address",address);
        map.put("stockLinkman",stockLinkman);
        map.put("storeId",storeId);
        map.put("isPublic",isPublic);
        map.put("stockMemo",stockMemo);
        map.put("forbidden",forbidden);
        map.put("storeName",storeName);
        map.put("inventorying",inventorying);
        map.put("stockIds",stockIds);
        map.put("storeIds",storeIds);
        map.put("limit",getLimit());
        map.put("offset",getOffset());
        return map;
    }

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
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
}
