package com.ihappy.store.domain.dto.request.store;

import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/4/16.
 * app查询门店列表
 */
public class CompanyStoreListByUserQueryReqDTO extends UsopRequestBaseQuery {
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 用户id
     */
    private Long personId;
    /**
     * 是否查询公共门店（总店）
     * null 所有 0：不查询总店 1：只查询总店
     */
    @FieldComment(value = "公共门店 0：不查询总店 1：只查询总店",required = false,defaultValue = "")
    private Integer isPublic;

    @FieldComment(value = "门店名称",required = false,defaultValue = "")
    private String storeNameSearch;

    @FieldComment(value = "是否禁用  0:未禁用  1:禁用",required = false,defaultValue = "")
    private Integer forbidden;
    @FieldComment(value = "是否只显示可用门店  0:是  1:否",required = false,defaultValue = "")
    private Integer using;

    public Integer getUsing() {
        return using;
    }

    public void setUsing(Integer using) {
        this.using = using;
    }

    public String getStoreNameSearch() {
        return storeNameSearch;
    }

    public void setStoreNameSearch(String storeNameSearch) {
        this.storeNameSearch = storeNameSearch;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    @Override
    public void validation() {
        //由于目前这个接口都是查的 非禁用，前端都去加forbidden 比较麻烦，故默认为非禁用门店
        if (forbidden == null){
            forbidden = 0;
        }
    }
}
