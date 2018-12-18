package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.partner.domain.dto.response.partner.CustomerInfoListQueryRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/4/12.
 */
public class DefCustomerListQueryRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "收藏客户列表",required = false,defaultValue = "")
    private List<CustomerInfoListQueryRespDTO> favorList;

    @FieldComment(value = "最近往来客户列表",required = false,defaultValue = "")
    private List<CustomerInfoListQueryRespDTO> lastContactList;

    public List<CustomerInfoListQueryRespDTO> getFavorList() {
        return favorList;
    }

    public void setFavorList(List<CustomerInfoListQueryRespDTO> favorList) {
        this.favorList = favorList;
    }

    public List<CustomerInfoListQueryRespDTO> getLastContactList() {
        return lastContactList;
    }

    public void setLastContactList(List<CustomerInfoListQueryRespDTO> lastContactList) {
        this.lastContactList = lastContactList;
    }
}
