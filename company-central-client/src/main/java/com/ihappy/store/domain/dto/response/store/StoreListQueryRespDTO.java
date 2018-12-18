package com.ihappy.store.domain.dto.response.store;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/12 13:36
 * @Version
 */
public class StoreListQueryRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "过期时间")
    private Long  expireDate;
   @FieldComment(value = "公司id",defaultValue = "" ,required = false)
    private Integer compId;
   @FieldComment(value = "是否删除")
    private  Integer isDeleted;
   @FieldComment(value = "是否公共门店（总店） 0：不是  1：是")
    private Integer isPublic;
   @FieldComment(value = "门店id")
    private Long storeId;
   @FieldComment(value = "门店名称")
    private String storeName;
   @FieldComment(value = "门店电话")
    private String storePhone;
   @FieldComment(value = "地址")
   private String area;
   @FieldComment(value = "联系人")
   private String storeContact;
   @FieldComment(value = "门店状态 0 待续费 1使用中")
   private Integer storeStatus;
   @FieldComment(value = "是否禁用  0:未禁用  1:禁用")
   private Integer forbidden;
    /**
     * 创建时间
     */
   private Long createAt;

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    @FieldComment(value =  "0:体验;1:付费")

   private Integer expireStatus;

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStoreContact() {
        return storeContact;
    }

    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
}
