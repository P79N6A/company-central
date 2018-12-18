package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.domain.bo.*;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.OrderCompanyJournalMapper;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by liuhc on 2018/6/28.
 */
public class OrderCompanyJournalServiceImpl implements OrderCompanyJournalService {

    @Autowired
    private OrderCompanyJournalMapper orderCompanyJournalMapper;

    @Override
    public int addOrderCompanyJournal(OrderCompanyJournal record) {
        return orderCompanyJournalMapper.insertSelective(record);
    }

    @Override
    public OrderCompanyJournalModel getOrderCompanyJournalDetailById(OrderCompanyJournalByIdBO orderCompanyJournalByIdBO) {
        OrderCompanyJournal orderCompanyJournal =  orderCompanyJournalMapper.getOrderCompanyJournalDetailById(orderCompanyJournalByIdBO);
        return new OrderCompanyJournalModel(orderCompanyJournal);
    }

    @Override
    public List<OrderCompanyJournalModel> getOrderCompanyJournalDetailByCompId(OrderCompanyJournalByCompIdBO orderCompanyJournalByCompIdBO) {
        List<OrderCompanyJournal> resultDo =  orderCompanyJournalMapper.getOrderCompanyJournalDetailByCompId(orderCompanyJournalByCompIdBO);
        if(CollectionUtil.isEmpty(resultDo)){
            return new ArrayList<OrderCompanyJournalModel>();
        }
        return transform(resultDo, (orderCompanyJournal) -> new OrderCompanyJournalModel(orderCompanyJournal));
    }

    @Override
    public List<OrderCompanyJournalModel> getOrderCompanyJournalList(OrderCompanyJournalPageQueryBO queryBO){
        List<OrderCompanyJournal> resultDo =  orderCompanyJournalMapper.getOrderCompanyJournalList(queryBO);
        if(CollectionUtil.isEmpty(resultDo)){
            return new ArrayList<OrderCompanyJournalModel>();
        }
        return transform(resultDo, (orderCompanyJournal) -> new OrderCompanyJournalModel(orderCompanyJournal));
    }

    @Override
    public int updateOrderCompanyJournalById(UpdateOrderCompanyJournalBO updateOrderCompanyJournalBO) {
        return orderCompanyJournalMapper.updateOrderCompanyJournalById(updateOrderCompanyJournalBO);
    }

    @Override
    public int cancelOrderCompanyJournalById(CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO) {
        return orderCompanyJournalMapper.cancelOrderCompanyJournalById(cancelOrderCompanyJournalBO);
    }

    @Override
    public int getOrderCompanyJournalCount(OrderCompanyJournalPageQueryBO queryBO) {
        int count = orderCompanyJournalMapper.getOrderCompanyJournalCount(queryBO);
        return count;
    }

}
