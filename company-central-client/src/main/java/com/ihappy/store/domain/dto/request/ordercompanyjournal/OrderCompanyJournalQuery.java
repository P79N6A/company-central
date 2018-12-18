package com.ihappy.store.domain.dto.request.ordercompanyjournal;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/6/29.
 */
public class OrderCompanyJournalQuery extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 2413052050446927148L;
    /**
     * 付款时间开始
     */
    @FieldComment(value = "付款时间开始", required = false)
    private String payTimeStart;

    /**
     * 付款时间结束
     */
    @FieldComment(value = "付款时间结束", required = false)
    private String payTimeEnd;

    /**
     *  付款方式
     */
    @FieldComment(value = "付款方式", required = false)
    private Integer payType;

    /**
     *  付款人
     */
    @FieldComment(value = "付款人", required = false)
    private String payPersonName;

    /**
     *  生效企业
     */
    @FieldComment(value = "生效企业", required = false)
    private Long compId;

    /**
     *  记录者
     */
    @FieldComment(value = "记录者", required = false)
    private Long momoPersonId;

    /**
     *  审核人
     */
    @FieldComment(value = "审核人", required = false)
    private Long assessorPersonId;

    /**
     *  审核人姓名
     */
    @FieldComment(value = "审核人姓名", required = false)
    private String auditorName;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Long getAssessorPersonId() {
        return assessorPersonId;
    }

    public void setAssessorPersonId(Long assessorPersonId) {
        this.assessorPersonId = assessorPersonId;
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

    public Long getMomoPersonId() {
        return momoPersonId;
    }

    public void setMomoPersonId(Long momoPersonId) {
        this.momoPersonId = momoPersonId;
    }
    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginPersonId() == null || getLoginCompId() == 0 || getLoginPersonId() <=0) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
