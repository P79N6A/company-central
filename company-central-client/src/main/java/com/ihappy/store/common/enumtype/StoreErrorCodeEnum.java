package com.ihappy.store.common.enumtype;

/**
 * Created by sunjd on 2018/9/20.
 */
public enum StoreErrorCodeEnum {
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

    //门店相关
    ADD_COMPANY_STORE_ERROR("add_company_store_error", "新增企业门店失败"),
    CAN_NOT_PUBLIC_STORE_DELETE("CAN_NOT_PUBLIC_STORE_DELETE", "总仓不能删除"),
    STORE_ID_IS_ILLEGAL("STORE_ID_IS_ILLEGAL","门店id非法"),
    STORE_ID_IS_NULL("Store_Id_Is_Null","门店id为空"),
    STORE_NAME_IS_NULL("Store_Name_Is_Null","门店名称为空"),
    STORE_QUERY_IS_FAIL("STORE_QUERY_IS_FAIL","门店查询失败"),
    NO_PUBLIC_STORE("NO_PUBLIC_STORE","没有总仓"),
    STORE_NAME_IS_EXIST("Store_Name_Is_Exist","门店名称已存在"),
    UPDATE_PRINT_IP_AND_PORT("UPDATE_PRINT_IP_AND_PORT","修改门店打印ip和端口出错"),
    NO_STORE_FIND("NO_STORE_FIND","没有门店"),
    ADD_DEF_STORE_ERROR("ADD_DEF_STORE_ERROR","添加默认门店错误"),
    ADD_PUBLIC_STORE_ERROR("ADD_PUBLIC_STORE_ERROR","添加公共门店错误"),
    SET_PERFORMANCE_ERROR("SET_PERFORMANCE_ERROR","设置业绩出错"),
    SOTRE_NAME_IS_NULL("store_name_is_null","名称为空"),
    BASEINFO_COMPANY_STORE_ID_SEQ_FAILED("Baseinfo_Company_Store_Id_Seq_Failed","企业中心门店主键id获取失败"),
    WESHOP_COLLECTION_STORE_IS_NULL("weshop_collection_store_is_null","收藏店铺不能为空"),
    WESHOP_COLLECTION_STORE_COMP_IS_NULL("weshop_collection_store_comp_is_null","收藏店铺所属公司为空"),
    CAN_NOT_STORE_DELETEE("CAN_NOT_STORE_DELETEE", "该门店已被使用，无法删除"),
    UPDATE_STORE_EXPIRE_DATE_ERROR("UPDATE_STORE_EXPIRE_DATE_ERROR","修改门店到期时间出错"),
    UPDATE_STORE_INFO_ERROR("UPDATE_STORE_INFO_ERROR","修改门店信息出错")
    ;

    private String errMsg;

    private String errCode;

    private StoreErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private StoreErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public static StoreErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        for (StoreErrorCodeEnum x : StoreErrorCodeEnum.values()) {
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
