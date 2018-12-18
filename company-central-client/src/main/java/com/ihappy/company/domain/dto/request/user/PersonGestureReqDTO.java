package com.ihappy.company.domain.dto.request.user;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

import java.util.List;

/**
 * @program: company-central
 * @description: 用户行为信息表（收藏、购买等）
 * @author: 汪正
 * @create: 2018-05-18 10:22
 **/
public class PersonGestureReqDTO extends ICallRequestBaseQuery {

    private static final long serialVersionUID = -3796353666045456952L;

    /**
     *  用户ID
     */
    private Long personId;

    /**
     *  用户做出行为的商铺集
     */
    private List<Long> weshopIds;

    /**
     *   是否收藏
     */
    private Integer isCollected;

    /**
     *   是否购买
     */
    private Integer isPurchased;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<Long> getWeshopIds() {
        return weshopIds;
    }

    public void setWeshopIds(List<Long> weshopIds) {
        this.weshopIds = weshopIds;
    }

    public Integer getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Integer isCollected) {
        this.isCollected = isCollected;
    }

    public Integer getIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(Integer isPurchased) {
        this.isPurchased = isPurchased;
    }
}
