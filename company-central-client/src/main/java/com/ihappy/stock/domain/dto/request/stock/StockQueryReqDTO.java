package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 6143663907755382138L;
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
    }
}
