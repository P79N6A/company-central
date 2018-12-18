package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockStatusReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5029425942031067701L;
    /**
     * 获取修改创建人id
     * @return
     */
    public Long personId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getPersonId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getPersonId();
        }else{
            throw new StockException(StockErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     * 获取用户公司id
     * @return
     */
    public Long userCompId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getCompId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getCompId();
        }else{
            throw new StockException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     *仓库id
     */
    private Long stockId;
    /**
     * 是否禁用 1：禁用 0：启用
     */
    private Integer forbidden;

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Override
    public void validation() {
        if (stockId == null) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_ID_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
