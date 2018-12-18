package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -8958329233949318432L;
    /**
     * 获取修改创建人id
     * @return
     */
    public Long personId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getPersonId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getPersonId();
        }else{
            throw new StockException(StockErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     * 获取用户公司id
     * @return
     */
    public Long userCompId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getCompId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getCompId();
        }else{
            throw new StockException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
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
     *仓库面积
     */
    private Integer stockAcreage;

    /**
     *最小地区id
     */
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
    private Integer storeId;

    /**
     *是否公共仓库  1：公共仓库  0：非公共仓库
     */
    private Integer isPublic;

    /**
     *仓库介绍
     */
    private String stockMemo;

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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
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

    @Override
    public void validation() {
        if (stockId == null) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_ID_IS_NULL.getErrMsg());
        }
        if (stockName != null && stockName.trim().equals("")) {
            throw new StockException(StoreErrorCodeEnum.
                    STORE_NAME_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_NAME_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
