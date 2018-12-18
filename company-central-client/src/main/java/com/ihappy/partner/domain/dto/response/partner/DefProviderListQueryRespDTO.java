package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/4/11.
 */
public class DefProviderListQueryRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "收藏供应商列表",required = false,defaultValue = "")
    private List<ProviderInfoListQueryRespDTO> favorList;
    @FieldComment(value = "最近往来供应商列表",required = false,defaultValue = "")
    private List<ProviderInfoListQueryRespDTO> lastContactList;


    public List<ProviderInfoListQueryRespDTO> getFavorList() {
        return favorList;
    }

    public void setFavorList(List<ProviderInfoListQueryRespDTO> favorList) {
        this.favorList = favorList;
    }

    public List<ProviderInfoListQueryRespDTO> getLastContactList() {
        return lastContactList;
    }

    public void setLastContactList(List<ProviderInfoListQueryRespDTO> lastContactList) {
        this.lastContactList = lastContactList;
    }
}
