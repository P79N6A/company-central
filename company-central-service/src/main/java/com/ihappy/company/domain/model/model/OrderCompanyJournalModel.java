package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;

/**
 * Created by liuhc on 2018/6/28.
 */
public class OrderCompanyJournalModel  extends BaseModel<OrderCompanyJournal> {

    private OrderCompanyJournal orderCompanyJournal;

    public OrderCompanyJournalModel(OrderCompanyJournal doObject) {
        super(doObject);
        orderCompanyJournal = doObject;
    }

    public Integer getCancelFlag(){
        return orderCompanyJournal.getIsCancel();
    }

    public Integer getVersion(){
        return orderCompanyJournal.getVersion();
    }

    public Long getCompId(){
        return orderCompanyJournal.getCompId();
    }

    public Long getPayMoney(){
        return orderCompanyJournal.getPayMoney();
    }

    public String getOrderNo(){
        return orderCompanyJournal.getOrderNo();
    }

    public Integer getPayType(){
        return orderCompanyJournal.getPayType();
    }

    public Long getInvitePersonId(){
        return orderCompanyJournal.getInvitePersonId();
    }
}
