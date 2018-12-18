package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.*;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;

import java.util.List;

/**
 * Created by liuhc on 2018/6/28.
 */
public interface OrderCompanyJournalService {

    /**
     * 新增缴费记录
     * @param reqDTO
     * @return
     */
    int addOrderCompanyJournal(OrderCompanyJournal reqDTO);

    /**
     * 通过订单ID查看详情
     * @param orderCompanyJournalByIdBO
     * @return
     */
    OrderCompanyJournalModel getOrderCompanyJournalDetailById(OrderCompanyJournalByIdBO orderCompanyJournalByIdBO);

    List<OrderCompanyJournalModel> getOrderCompanyJournalDetailByCompId(OrderCompanyJournalByCompIdBO orderCompanyJournalByCompIdBO);

    /**
     * 统计
     * @param queryBO
     * @return
     */
    int getOrderCompanyJournalCount(OrderCompanyJournalPageQueryBO queryBO);
    /**
     * 查询分页列表
     * @param queryBO
     * @return
     */
    List<OrderCompanyJournalModel> getOrderCompanyJournalList(OrderCompanyJournalPageQueryBO queryBO);

    /**
     * 修改备注信息
     * @param updateOrderCompanyJournalBO
     * @return
     */
    int updateOrderCompanyJournalById(UpdateOrderCompanyJournalBO updateOrderCompanyJournalBO);

    /**
     * 作废单据
     * @param cancelOrderCompanyJournalBO
     * @return
     */
    int cancelOrderCompanyJournalById(CancelOrderCompanyJournalBO cancelOrderCompanyJournalBO);
}
