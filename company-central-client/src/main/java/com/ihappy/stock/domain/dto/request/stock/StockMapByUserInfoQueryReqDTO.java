package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

/**
 * Created by sunjd on 2018/5/23.
 */
public class StockMapByUserInfoQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -5935722074496569543L;
    /**
     * 用户id
     */
    private Long personId;
    /**
     * 公司id
     */
    private Long compId;
    /**
     * 是否公共仓库  1：公共仓库  0：非公共仓库  null:全部
     */
    private Integer isPublic;
    /**
     * 禁用 1 禁用 0未禁用  null:全部
     */
    private Integer forbidden;
    /**
     * 是否过滤服务过期门店的仓库  true：过滤  false:不过滤  null:不过滤
     */
    private Boolean filterUnvalidStore;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
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

    public Boolean getFilterUnvalidStore() {
        return filterUnvalidStore;
    }

    public void setFilterUnvalidStore(Boolean filterUnvalidStore) {
        this.filterUnvalidStore = filterUnvalidStore;
    }

    @Override
    public void validation() {
        if (personId == null){
            throw new StockException(StockErrorCodeEnum.
                    PERSON_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.PERSON_ID_IS_NULL.getErrMsg());
        }
        if (compId == null){
            throw new StockException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
