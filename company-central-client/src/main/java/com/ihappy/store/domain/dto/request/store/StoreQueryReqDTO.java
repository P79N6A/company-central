package com.ihappy.store.domain.dto.request.store;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/16.
 */
public class StoreQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 3946072931671625250L;
    /**
     * 门店id
     */
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;
    /**
     * 企业id
     */
    @FieldComment(value = "企业id",required = false,defaultValue = "")
    private Long compId;

    @FieldComment(value = "是否 0:未删除，1:已删除",required = false,defaultValue = "0")
    private Integer isDeleted = 0;

    @FieldComment(value = "是否禁用  0:未禁用  1:禁用",required = false,defaultValue = "")
    private Integer forbidden;

    @FieldComment(value = "是否公共门店  0-否 1-是",required = false,defaultValue = "")
    private Integer isPublic;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public void validation() {
    }
}
