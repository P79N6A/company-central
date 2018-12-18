package com.ihappy.stock.domain.dto.request.user;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

/**
 * Created by Administrator on 2018/5/7.
 */
public class UserInfoOutSideByIdQuery extends ICallRequestBaseQuery {

    private static final long serialVersionUID = -5051890984098401827L;

    /**
     * 0：老板角色返回的list前加所有仓库
     */
    private int type=0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void validation() {
        if(getLoginCompId() == null || getLoginPersonId() == null ||
                getLoginCompId() < 0L || getLoginPersonId() < 0L){
            throw new StockException(StockErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    StockErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}


