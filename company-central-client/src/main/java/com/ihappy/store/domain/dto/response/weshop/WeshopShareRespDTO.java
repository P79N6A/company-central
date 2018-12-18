package com.ihappy.store.domain.dto.response.weshop;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/7/7.
 */
public class WeshopShareRespDTO implements Serializable {
    /**
     * 公司id
     */
    private Long compId;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 二维码照片地址
     */
    private String  qrCodePictureUrl;

    /**
     * 分享地址
     */
    private String shareUrl;

    public String getQrCodePictureUrl() {
        return qrCodePictureUrl;
    }

    public void setQrCodePictureUrl(String qrCodePictureUrl) {
        this.qrCodePictureUrl = qrCodePictureUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
