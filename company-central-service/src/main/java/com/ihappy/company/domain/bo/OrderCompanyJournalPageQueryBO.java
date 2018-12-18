package com.ihappy.company.domain.bo;

/**
 * Created by liuhc on 2018/6/30.
 */
public class OrderCompanyJournalPageQueryBO {

    /**
     * 付款时间开始
     */
    private String payTimeStart;

    /**
     * 付款时间结束
     */
    private String payTimeEnd;

    /**
     *  付款方式
     */
    private Integer payType;

    /**
     *  付款人
     */
    private String payPersonName;

    /**
     *  生效企业
     */
    private Long compId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     *  记录者
     */
    private Long memoPersonId;
    /**
     *  审核人
     */
    private Long assessorPersonId;

    /**
     *  审核人姓名
     */
    private String auditorName;

    private Integer limit;

    private Integer offset;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayPersonName() {
        return payPersonName;
    }

    public void setPayPersonName(String payPersonName) {
        this.payPersonName = payPersonName;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getMemoPersonId() {
        return memoPersonId;
    }

    public void setMemoPersonId(Long memoPersonId) {
        this.memoPersonId = memoPersonId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Long getAssessorPersonId() {
        return assessorPersonId;
    }

    public void setAssessorPersonId(Long assessorPersonId) {
        this.assessorPersonId = assessorPersonId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
