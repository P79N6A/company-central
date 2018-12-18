package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;
import com.ihappy.usop.client.annotation.FieldComment;
import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 8399961791054341359L;

    /**
     * 获取修改创建人id
     * @return
     */
    public Long personId(){
        if (super.getPerson() && super.getLoginPersonId() != null ){
            return super.getLoginPersonId();
        }else if (super.getPerson() && super.getLoginPersonId() == null){
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
        if (super.getPerson() && super.getLoginCompId() != null) {
            return super.getLoginCompId();
        }else if (super.getPerson() && super.getLoginCompId() == null){
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
     *门店id
     */
    @FieldComment("门店id")
    private Long storeId;
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
    @NotNull
    @FieldComment("仓库名")
    private String stockName;

    /**
     *仓库面积
     */
    @FieldComment("仓库面积")
    private Integer stockAcreage;


    /**
     *省
     */
    @FieldComment("省")
    private String province;

    /**
     *市
     */
    @FieldComment("市")
    private String city;

    /**
     *区县
     */
    @FieldComment("区县")
    private String zone;

    /**
     *具体地址
     */
    @FieldComment("具体地址")
    private String address;

    /**
     *联系电话
     */
    @FieldComment("联系电话")
    private String stockTel;

    /**
     *联系人
     */
    @FieldComment("联系人")
    private String stockLinkman;

    /**
     *仓库介绍
     */
    @FieldComment("仓库介绍")
    private String stockMemo;

    /**
     * 是否默认仓库  0：否   1：是
     */
    @FieldComment("是否默认仓库  0：否   1：是")
    private Integer isDefault;
    /**
     * 查询类型--addOrQueryStock接口
     * null：根据公司id/门店id/仓库名称查询仓库，没有的话新建
     * 1：根据公司id/仓库名称，查询总店下的仓库
     */
    @FieldComment("查询类型(addOrQueryStock接口);null：根据公司id/门店id/仓库名称查询仓库，没有的话新建;1：根据公司id/仓库名称，查询总店下的仓库")
    private Integer queryType;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getStockMemo() {
        return stockMemo;
    }

    public void setStockMemo(String stockMemo) {
        this.stockMemo = stockMemo;
    }

    @Override
    public void validation() {
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
