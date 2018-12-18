package com.ihappy.company.domain.model.factory;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.CancelOrderCompanyJournalBO;
import com.ihappy.company.domain.bo.OrderCompanyJournalPageQueryBO;
import com.ihappy.company.domain.bo.UpdateOrderCompanyJournalBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyExtendServiceJournal;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.CancelOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.UpdateOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.store.domain.dto.response.store.CompStorePayInfoPageRespDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuhc on 2018/6/28.
 */
public class OrderCompanyJournalFactory {

    public static OrderCompanyJournal orderCompanyJournalReqDTOToDO(OrderCompanyJournalReqDTO orderCompanyJournalReqDTO){
        OrderCompanyJournal orderCompanyJournal = new OrderCompanyJournal();

        orderCompanyJournal.setMemo(orderCompanyJournalReqDTO.getMemo());
        orderCompanyJournal.setMemoPersonId(orderCompanyJournalReqDTO.getLoginPersonId());
        orderCompanyJournal.setIsBill(orderCompanyJournalReqDTO.getBillFlag());
        orderCompanyJournal.setTaxNo(orderCompanyJournalReqDTO.getTaxNo());
        orderCompanyJournal.setIsDeleted(0);
        orderCompanyJournal.setSourceOrderNo(orderCompanyJournalReqDTO.getSourceOrderNo());
        orderCompanyJournal.setPayTitle(orderCompanyJournalReqDTO.getPayTitle());
        orderCompanyJournal.setPayMoney(orderCompanyJournalReqDTO.getPayMoney());
        orderCompanyJournal.setPayPersonLogin(orderCompanyJournalReqDTO.getPayPersonLogin());
        orderCompanyJournal.setPayPersonName(orderCompanyJournalReqDTO.getPayPersonName());
        orderCompanyJournal.setPayContent(orderCompanyJournalReqDTO.getPayContent());
        orderCompanyJournal.setPayTime(CompanyDateUtil.getDate14Long(DateUtil.parseDateY_M_D(orderCompanyJournalReqDTO.getPayTime())));
        orderCompanyJournal.setPayType(orderCompanyJournalReqDTO.getPayType());

        orderCompanyJournal.setStoreId(orderCompanyJournalReqDTO.getStoreId());
        orderCompanyJournal.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        orderCompanyJournal.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        orderCompanyJournal.setCompId(orderCompanyJournalReqDTO.getCompId());
        orderCompanyJournal.setCreatedPersonId(orderCompanyJournalReqDTO.getLoginPersonId());
        orderCompanyJournal.setUpdatedPersonId(orderCompanyJournalReqDTO.getLoginPersonId());


        return orderCompanyJournal;
    }

    public static List<OrderCompanyJournalInfoRespDTO> toOrderCompanyJournalInfoRespDTOList(List<OrderCompanyJournal> orderCompanyJournalList){
        List<OrderCompanyJournalInfoRespDTO> resultDTOS = new ArrayList<OrderCompanyJournalInfoRespDTO>();
        for (OrderCompanyJournal obj : orderCompanyJournalList){
            OrderCompanyJournalInfoRespDTO orderCompanyJournalInfoRespDTO = new OrderCompanyJournalInfoRespDTO();
            if (obj !=null){
                 orderCompanyJournalInfoRespDTO = toOrderCompanyJournalInfoRespDTO(obj);
            }
            resultDTOS.add(orderCompanyJournalInfoRespDTO);
        }
        return resultDTOS;
    }

    public static OrderCompanyJournalInfoRespDTO toOrderCompanyJournalInfoRespDTO(OrderCompanyJournal dto){
        if (dto == null) {
            return null;
        }
        OrderCompanyJournalInfoRespDTO obj = new OrderCompanyJournalInfoRespDTO();
        obj.setOrderNo(dto.getOrderNo());
        obj.setPayTime(CompanyDateUtil.parseDate(dto.getPayTime(),CompanyDateUtil.Y_M_D_H_M));
        obj.setPayPersonName(dto.getPayPersonName());
        obj.setPayType(dto.getPayType());
        obj.setPayPersonLogin(dto.getPayPersonLogin());
        obj.setPayMoney(dto.getPayMoney());
        obj.setPayMoneyY(AmountUtils.changeF2Y(dto.getPayMoney()));
        obj.setCompId(dto.getCompId());
        obj.setCtId(dto.getCtId());
        obj.setPayContent(dto.getPayContent());
        obj.setBillFlag(dto.getIsBill());
        obj.setPayTitle(dto.getPayTitle());
        obj.setTaxNo(dto.getTaxNo());
        obj.setInvitePersonMobile(dto.getInvitePersonMobile());
        obj.setMomoPersonId(dto.getMemoPersonId());
        obj.setMemoPersonName(dto.getMemoPersonName());
        obj.setUpdatedAt(CompanyDateUtil.parseDate(dto.getUpdatedAt(),CompanyDateUtil.Y_M_D_H_M));
        obj.setCreatedAt(CompanyDateUtil.parseDate(dto.getCreatedAt(),CompanyDateUtil.Y_M_D_H_M));
        obj.setMemo(dto.getMemo());
        obj.setOrderId(dto.getOrderId());
        obj.setCancelFlag(dto.getIsCancel());
        obj.setVersion(dto.getVersion());
        obj.setSourceOrderNo(dto.getSourceOrderNo());
        obj.setStoreId(dto.getStoreId());
        obj.setStoreName("");
        obj.setAuditorName(dto.getAuditorName());
        return obj;
    }

    public static OrderCompanyJournalPageQueryBO toOrderCompanyJournalPageQueryBO(OrderCompanyJournalQuery orderCompanyJournalQuery) {
        OrderCompanyJournalPageQueryBO orderCompanyJournalPageQueryBO = new OrderCompanyJournalPageQueryBO();
        orderCompanyJournalPageQueryBO.setCompId(orderCompanyJournalQuery.getCompId());
        orderCompanyJournalPageQueryBO.setMemoPersonId(orderCompanyJournalQuery.getMomoPersonId());
        orderCompanyJournalPageQueryBO.setPayPersonName(orderCompanyJournalQuery.getPayPersonName());
        orderCompanyJournalPageQueryBO.setPayTimeEnd(orderCompanyJournalQuery.getPayTimeEnd());
        orderCompanyJournalPageQueryBO.setPayTimeStart(orderCompanyJournalQuery.getPayTimeStart());
        orderCompanyJournalPageQueryBO.setPayType(orderCompanyJournalQuery.getPayType());
        orderCompanyJournalPageQueryBO.setAssessorPersonId(orderCompanyJournalQuery.getAssessorPersonId());
        orderCompanyJournalPageQueryBO.setAuditorName(orderCompanyJournalQuery.getAuditorName());
        orderCompanyJournalPageQueryBO.setOffset(orderCompanyJournalQuery.getOffset());
        orderCompanyJournalPageQueryBO.setLimit(orderCompanyJournalQuery.getLimit());
        return orderCompanyJournalPageQueryBO;
    }

    public static UpdateOrderCompanyJournalBO toUpdateOrderCompanyJournalBO(UpdateOrderCompanyJournalReqDTO updateOrderCompanyJournalReqDTO) {
        UpdateOrderCompanyJournalBO updateOrderCompanyJournalBO = new UpdateOrderCompanyJournalBO();
        updateOrderCompanyJournalBO.setMemo(updateOrderCompanyJournalReqDTO.getMemo());
        updateOrderCompanyJournalBO.setSourceOrderNo(updateOrderCompanyJournalReqDTO.getSourceOrderNo());
        updateOrderCompanyJournalBO.setVersion(updateOrderCompanyJournalReqDTO.getVersion());
        updateOrderCompanyJournalBO.setBillFlag(updateOrderCompanyJournalReqDTO.getBillFlag());
        updateOrderCompanyJournalBO.setCompId(updateOrderCompanyJournalReqDTO.getCompId());
        updateOrderCompanyJournalBO.setPayContent(updateOrderCompanyJournalReqDTO.getPayContent());
        updateOrderCompanyJournalBO.setPayMoney(updateOrderCompanyJournalReqDTO.getPayMoney());
        updateOrderCompanyJournalBO.setPayPersonName(updateOrderCompanyJournalReqDTO.getPayPersonName());
        updateOrderCompanyJournalBO.setPayPersonLogin(updateOrderCompanyJournalReqDTO.getPayPersonLogin());
        updateOrderCompanyJournalBO.setPayTime(CompanyDateUtil.getDate14Long(DateUtil.parseDateY_M_D(updateOrderCompanyJournalReqDTO.getPayTime())));
        updateOrderCompanyJournalBO.setTaxNo(updateOrderCompanyJournalReqDTO.getTaxNo());
        updateOrderCompanyJournalBO.setPayType(updateOrderCompanyJournalReqDTO.getPayType());
        updateOrderCompanyJournalBO.setOrderId(updateOrderCompanyJournalReqDTO.getOrderId());
        updateOrderCompanyJournalBO.setUpdatedPersonId(updateOrderCompanyJournalReqDTO.getLoginPersonId());
        updateOrderCompanyJournalBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        updateOrderCompanyJournalBO.setMemo(updateOrderCompanyJournalReqDTO.getMemo());
        updateOrderCompanyJournalBO.setPayTitle(updateOrderCompanyJournalReqDTO.getPayTitle());
        updateOrderCompanyJournalBO.setStoreId(updateOrderCompanyJournalReqDTO.getStoreId());
        return updateOrderCompanyJournalBO;
    }

    public static CancelOrderCompanyJournalBO toCancelOrderCompanyJournalBO(CancelOrderCompanyJournalReqDTO cancelOrderCompanyJournalReqDTO) {
        CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO = new CancelOrderCompanyJournalBO();
        cancelOrderCompanyJournalBO.setOrderId(cancelOrderCompanyJournalReqDTO.getOrderId());
        cancelOrderCompanyJournalBO.setUpdatedPersonId(cancelOrderCompanyJournalReqDTO.getLoginPersonId());
        cancelOrderCompanyJournalBO.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        return cancelOrderCompanyJournalBO;
    }

    public static BaseinfoCompanyExtendServiceJournal toBaseinfoCompanyExtend(OrderCompanyJournalModel orderCompanyJournalModel) {
        BaseinfoCompanyExtendServiceJournal companyExtendServiceJournal = new BaseinfoCompanyExtendServiceJournal();
        companyExtendServiceJournal.setMoney(orderCompanyJournalModel.getPayMoney());
        companyExtendServiceJournal.setOrderNo(orderCompanyJournalModel.getOrderNo());
        companyExtendServiceJournal.setOrderType(orderCompanyJournalModel.getPayType()+"");
        companyExtendServiceJournal.setSourceType(0);
        companyExtendServiceJournal.setTime(OptConstans.ADD_DEFAULT_YEAR_TIME);
        companyExtendServiceJournal.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        companyExtendServiceJournal.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        companyExtendServiceJournal.setCompId(Integer.parseInt(orderCompanyJournalModel.getDO().getCompId()+""));
        companyExtendServiceJournal.setFundStatus(1);
        companyExtendServiceJournal.setStoreId(orderCompanyJournalModel.getDO().getStoreId());
        return companyExtendServiceJournal;
    }

    public static CompStorePayInfoPageRespDTO toCompStorePayInfoPageRespDTO(OrderCompanyJournal orderCompanyJournal) {
        CompStorePayInfoPageRespDTO storePayInfoPageRespDTO = new CompStorePayInfoPageRespDTO();
        storePayInfoPageRespDTO.setStoreId(orderCompanyJournal.getStoreId());
        storePayInfoPageRespDTO.setStoreName("");
        storePayInfoPageRespDTO.setPayMoneyY(AmountUtils.changeF2Y(orderCompanyJournal.getPayMoney()));
        storePayInfoPageRespDTO.setOrderNo(orderCompanyJournal.getOrderNo());
        storePayInfoPageRespDTO.setPayType(orderCompanyJournal.getPayType());
        storePayInfoPageRespDTO.setPayTime(com.ihappy.common.util.DateUtil.dateFormat(orderCompanyJournal.getPayTime(),"yyyy-MM-dd HH:mm"));
        storePayInfoPageRespDTO.setPayPersonName(orderCompanyJournal.getPayPersonName());

        return storePayInfoPageRespDTO;
    }
}
