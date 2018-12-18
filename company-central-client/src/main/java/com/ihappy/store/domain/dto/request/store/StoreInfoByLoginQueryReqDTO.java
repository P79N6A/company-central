package com.ihappy.store.domain.dto.request.store;

import com.ihappy.common.domain.CommonQuery;
import com.ihappy.gateway.annotation.FieldComment;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;

/**
 * Created by liuhc on 2018/8/27.
 */
public class StoreInfoByLoginQueryReqDTO extends CommonQuery {

    @FieldComment("登录人公司id")
    private Long compId;

    @FieldComment("登录人id")
    private Long personId;

    @FieldComment("查询类型，1:老板只显示总店 2:老板看所有门店")
    private Integer type;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public void validation() {
        if(compId == null || compId <= 0L || personId == null || personId <= 0L || type == null ){
            throw new StoreException(StoreErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    StoreErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
