package com.ihappy.company.common.enumtype;

/**
 * @author : zhangtengpo
 * @Description : 单据类型枚举
 * @create : 2018-06-04 11:17
 */
public enum BillTypeEnum {
    PURCHASE_BILL(0,1,"采购进货单"),
    PURCHASE_RETURN_BILL(0,2,"采购退货单"),
    SALE_BILL(0,3, "销售开单"),
    SALE_RETURN_BILL(0,4,"销售退货单"),
    RETAIL_RETURN_BILL(0,6,"零售退货单"),
    RETAIL_BILL(0,500,"零售开单"),
    RETAIL_PREORDER_BILL(0,501, "零售预订单"),
    RETAIL_ADDITIONAL_BILL(0,502, "零售补录单"),
    STOCK_IN_BILL(1, 1, "入库单"),
    STOCK_OUT_BILL(1, 2, "出库单"),
    STOCK_ALLOCATE_BILL(1, 101, "调拨单"),
    STOCK_INVENTORY_BILL(1, 102, "盘点单"),
    RECONCILIATION_BILL(2, 1, "对账单"),
    BAR_CODE(2, 2, "标签")
    ;
    BillTypeEnum(Integer billType, Integer billTypeCode, String billTypeName){
        this.billType = billType;
        this.billTypeCode = billTypeCode;
        this.billTypeName = billTypeName;
    }

    private Integer billType;  // 单据类型 0: 出入库单 1: 订单
    /**
     * 单据详细类型,
     * 订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,
     *        500-零售单,501-零售预订单，502-零售补录单.
     *  出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单
     */
    private Integer billTypeCode;
    private String billTypeName;  // 单据名称

     /**
       * @Description: 根据单据编码,找到单据名称
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/6/4
       */
    public static String getBillTypeNameByTypeCode(int billType, int billTypeCode){
        for(BillTypeEnum billTypeEnum : BillTypeEnum.values()){
            if(billTypeEnum.getBillType().equals(billType) && billTypeEnum.getBillTypeCode().equals(billTypeCode)){
                return billTypeEnum.getBillTypeName();
            }
        }
        return null;
    }
    public Integer getBillType() {
        return billType;
    }

    public Integer getBillTypeCode() {
        return billTypeCode;
    }

    public String getBillTypeName() {
        return billTypeName;
    }
}
