package com.ihappy.stock.application.process.query.stock;

import com.ihappy.stock.domain.dto.request.user.UserInfoOutSideByIdQuery;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.stock.domain.bo.stock.StockInfoByPersonRoleDO;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/7.
 */
public class GetStockListByPersonIdProcess extends DefaultQueryProcess<UserInfoOutSideByIdQuery,List<StockBasicInfoRespDTO>> {

    @Autowired
    private StockService stockService;

    @Override
    public void process(Context<UserInfoOutSideByIdQuery, List<StockBasicInfoRespDTO>> context) {

        UserInfoOutSideByIdQuery stockListQueryReqDTO = context.getParam();

        StockInfoByPersonRoleDO roleDO = new StockInfoByPersonRoleDO();
        roleDO.setLoginCompId(stockListQueryReqDTO.getLoginCompId().intValue());
        roleDO.setLoginPersonId(stockListQueryReqDTO.getLoginPersonId());
        roleDO.setType(stockListQueryReqDTO.getType());
        List<StockBasicInfoRespDTO> stockList = stockService.getStockListByPersonRole(roleDO);

        //总仓放到最前
        List<StockBasicInfoRespDTO> notPublicStock = new ArrayList<>();
        List<StockBasicInfoRespDTO> stock = new ArrayList<>();
        for(StockBasicInfoRespDTO stockBasicInfoRespDTO : stockList){
            if(stockBasicInfoRespDTO != null && stockBasicInfoRespDTO.getIsPublic() == 1){
                stock.add(stockBasicInfoRespDTO);
            }else{
                notPublicStock.add(stockBasicInfoRespDTO);
            }
        }

        if(!CollectionUtil.isEmpty(notPublicStock)){
            stock.addAll(notPublicStock);
        }

        context.getResult().setModule(stock);

    }
}
