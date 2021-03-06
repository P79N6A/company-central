package com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop;


import com.ihappy.store.domain.dbdo.weshop.WeshopVisitJournal;

import java.util.Map;

public interface WeshopVisitJournalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    int deleteByPrimaryKey(Long weshopVisitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    int insert(WeshopVisitJournal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    int insertSelective(WeshopVisitJournal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    WeshopVisitJournal selectByPrimaryKey(Long weshopVisitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    int updateByPrimaryKeySelective(WeshopVisitJournal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weshop_visit_journal_0
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    int updateByPrimaryKey(WeshopVisitJournal record);

    /**
     *  查询店铺在某个时间段的访问量
     * @return
     */
    int queryWeshopVisitCountTimeRange(Map reqMap);

    /**
     *  查询店铺在某个时间段的访问的用户数
     * @return
     */
    int queryWeshopVisitUserCountTimeRange(Map reqMap);
}