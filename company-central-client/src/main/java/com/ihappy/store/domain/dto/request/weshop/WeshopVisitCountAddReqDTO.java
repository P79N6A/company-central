package com.ihappy.store.domain.dto.request.weshop;

import com.ihappy.store.exception.StoreException;
import com.ihappy.gateway.annotation.FieldComment;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * @author : zhangtengpo
 * @Description :  微商铺访问量增加请求
 * @create : 2018-06-06 16:22
 */
public class WeshopVisitCountAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5706523828470312503L;

    private String loginTokenId;  // 用户登录token
    private Long goodsId;  // 访问商品id
    private Long personId;  // 访问用户id
    private Long storeId;  // 门店id
    private Long compId;  // 公司id
    @FieldComment("用户身份标识")
    private String uid;
    @FieldComment("表示 uid 存储的内容类型  0-未知  1-用户id  2-访问ip")
    private Integer uidType;

    public String getLoginTokenId() {
        return loginTokenId;
    }

    public void setLoginTokenId(String loginTokenId) {
        this.loginTokenId = loginTokenId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getUidType() {
        return uidType;
    }

    public void setUidType(Integer uidType) {
        this.uidType = uidType;
    }

    @Override
    public void validation() {
        if(storeId == null || storeId.equals(0L)){
            throw new StoreException(StoreErrorCodeEnum.STORE_ID_IS_ILLEGAL);
        }
    }
}
