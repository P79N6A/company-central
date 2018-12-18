package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 13:09
 */
public class CompanyPrintConfigInfoQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 4494451396198976760L;
    @FieldComment(value = "公司id",required = true,defaultValue = "")
    private Integer compId;  // 公司id
    @FieldComment(value = "单据类型 0: 订单 1: 出入库单 2:其他",required = true,defaultValue = "")
    private Integer billType; // 单据类型 0: 订单 1: 出入库单
    /**
     * 单据详细类型,
     * 订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,
     *        500-零售单,501-零售预订单，502-零售补录单.
     *  出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单
     */
    @FieldComment(value = "单据详细类型 订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,500-零售单,501-零售预订单，502-零售补录单. 出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单 1-对账单2-商品标签",required = true,defaultValue = "")
    private Integer billTypeCode;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getBillTypeCode() {
        return billTypeCode;
    }

    public void setBillTypeCode(Integer billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    @Override
    public void validation() {
        if(billType == null){
            throw new CompanyException(CompanyErrorCodeEnum.BILL_TYPE_IS_NULL);
        }
        if(billTypeCode == null || billTypeCode.equals(0)){
            throw new CompanyException(CompanyErrorCodeEnum.BILL_TYPE_CODE_IS_NULL);
        }
    }
}
