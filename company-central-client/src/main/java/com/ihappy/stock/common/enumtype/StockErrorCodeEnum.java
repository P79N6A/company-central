package com.ihappy.stock.common.enumtype;

/**
 * Created by sunjd on 2018/9/20.
 */
public enum StockErrorCodeEnum {
    //公共错误信息
    CURRENCY_FEN_REGEX("CURRENCY_FEN_REGEX", "金额格式有误"),
    ILLGAL_ARGUMENT("ILLGAL_ARGUMENT", "非法参数"),
    NETWORK_IDEMPOTENT_INVOKE("NETWORK_IDEMPOTENT_INVOKE", "网络异常，请稍后重试"),
    EXCUTE_SQL_ERROR("EXCUTE_SQL_ERROR", "执行数据库错误"),
    SHARDING_COLUMN_NULL_ERROR("Sharding_Column_Null_Error", "分片字段为空错误"),
    PAGE_LIMIT_IS_NULL("Page_Limit_Is_Null", "分页条数为空"),
    OFFSET_IS_NULL("offset_is_null", "分页起始为空"),
    UPDATE_PERSON_ID_IS_NULL("Update_Person_Id_Is_Null", "修改人id为空"),
    FILL_DEFAULT_VALUE_ERROR("Fill_Default_Value_Error", "填充默认值出错"),
    PERSON_ID_IS_NULL("Person_Id_Is_Null", "用户id为空"),
    MONEY_IS_NULL("Money_Is_Null", "金额为空"),
    TIME_IS_NULL("Time_Is_Null", "时间为空"),
    TIME_IS_ZERO("time_is_zero", "时间为零"),
    GET_USER_INFO_ERROR("Get_User_Info_Error", "获取用户信息出错"),
    MOBILE_IS_NULL("MOBILE_IS_NULL", "手机号为空"),
    TO_MANY_RESULT("TO_MANY_RESULT", "查询的结果过多"),
    GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH("GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH", "组织机构名称过长"),
    GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH("GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH", "个体名称过长"),
    MOBILE_ILLLEGAL("MOBILE_ILLLEGAL", "请输入正确手机号"),
    ILLEGAL_PARAMETER("illegal_parameter", "非法参数"),
    IDEMPOTENT_INVOKE("IDEMPOTENT_INVOKE","幂等异常"),
    DELETE_FAILED("deleted_failed","删除失败"),
    CAN_NOT_EDIT_ERROR("CAN_NOT_EDIT_ERROR", "此条目受限不可编辑"),
    UP_TO_TEN_CHARATERS_CAN_BE_ENTERED("up_to_ten_characters_can_be_entered.","最多可输入10个字符"),

    //仓库相关
    STOCK_ID_IS_NULL("STOCK_ID_IS_NULL","仓库id为空"),
    STOCK_LOCK_IS_NULL("STOCK_LOCK_IS_NULL","仓库锁为空"),
    ADD_STOCK_ERROR("Add_Stock_Error","添加仓库出错"),
    UPDATE_STOCK_ERROR("Update_Stock_Error","修改仓库出错"),
    CAN_NOT_FORBIDEN_STOCK("Can_Not_Forbiden_Stock","不能禁用此仓库"),
    STOCK_NAME_IS_NULL("Stock_Name_Is_Null","仓库名称为空"),
    STOCK_CHANGE_IS_NULL("STOCK_CHANGE_IS_NULL","盘点单id为空"),
    NO_STOCK("NO_STOCK","没有对应仓库"),
    UPDATE_STOCK_INVENTORYING_ERROR("UPDATE_STOCK_INVENTORYING_ERROR","更新仓库锁出错"),
    CLEAR_STOCK_INVENTORYING_ERROR("CLEAR_STOCK_INVENTORYING_ERROR","清除仓库锁出错"),
    REPETITION_STOCK_NAME_ERROR("REPETITION_STOCK_NAME_ERROR","仓库名称重复"),
    BASEINFO_COMPANY_STOCK_ID_SEQ_FAILED("Baseinfo_Company_Stock_Id_Seq_Failed","企业中心仓库主键id获取失败"),
    ADD_DEF_STOCK_ERROR("ADD_DEF_STOCK_ERROR","添加默认仓库失败")
    ;

    private String errMsg;

    private String errCode;

    private StockErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private StockErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public static StockErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        for (StockErrorCodeEnum x : StockErrorCodeEnum.values()) {
            if (x.getErrCode().equals(code)) {
                return x;
            }
        }
        return null;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
