package com.ihappy.store.domain.dto.request.weshop;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-11 14:07
 */
public class WeshopDetailQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 4577038121233970034L;

        /**
     * 门店所属公司id
     */
    private Integer compId;
    /**
     * 门店id
     */
    private Long storeId;

    /**
     *  登陆用户token
     */
    private String loginTokenId;
    /**
     * 访问ip
     */
    private String remoteIp;

    /**
     * 查询请求来源, 用来判断是否要增加访问量
     * 请求来源 查询详情时需要传入这个字段, 用来判断是否需要增加店铺访问量, 从已收藏商铺列表请求传入collection, 全部商铺列表页面请求传入all
     */
    private String from;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getLoginTokenId() {
        return loginTokenId;
    }

    public void setLoginTokenId(String loginTokenId) {
        this.loginTokenId = loginTokenId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }
}
