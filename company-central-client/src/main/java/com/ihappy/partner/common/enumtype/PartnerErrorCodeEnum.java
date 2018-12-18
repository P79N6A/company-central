package com.ihappy.partner.common.enumtype;

/**
 * Created by sunjd on 2018/9/20.
 */
public enum PartnerErrorCodeEnum {
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
    QUERY_PARTNER_IS_FAIL("QUERY_PARTNER_IS_FAIL", "查询失败"),

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

    //Partner相关
    PARTNER_ARREARS_ORDER_ID_SEQ_FAILED("Partner_Arrears_Order_Id_Seq_Failed","企业中心合作伙伴欠款订单流水主键id获取失败"),
    PARTNER_LEVEL_ID_SEQ_FAILED("Partner_Level_Id_Seq_Failed","企业中心会员客户等级主键id获取失败"),
    //PARTNER_ARREARS_LESS_THAN_ZERO("Partner_Arrears_Less_Than_Zero","欠款小于零"),
    PARTNER_NAME_IS_NULL("Partner_Name_Is_Null","伙伴企业名空"),
    PARTNER_ID_IS_NULL("Partner_Id_Is_Null","合作伙伴id为空"),
    PARTNER_COMPANY_ID_IS_NULL("Partner_Company_Id_Is_Null","合作伙伴公司id为空"),
    COMPANY_ID_IS_NULL("COMPANY_ID_IS_NULL","公司id为空"),


    PARTNER_MOBILE_IS_NULL("PARTNER_MOBILE_IS_NULL","合作伙伴手机号为空"),
    QUERY_TYPE_IS_NULL("QUERY_TYPE_IS_NULL","类型为空"),



    PARTNER_TYPE_IS_NULL("Partner_Type_Is_Null","Partner类型为空"),
    DELETE_COMPANY_PARTNER_ERROR("Delete_Company_Partner_Error","删除合作伙伴错误"),
    UPDATE_COMPANY_PROVIDER_ERROR("Update_Company_Provider_Error","修改企业供应商出错"),
    PREPAID_DEPOSIT_LESS_THEN_ZERO("PREPAID_DEPOSIT_LESS_THEN_ZERO","修改后预存款将小于0"),
    UPDATE_PARTNER_ARREARS_ERROR("UPDATE_PARTNER_ARREARS_ERROR","修改欠款错误"),
    UPDATE_PARTNER_PREPAID_DEPOSIT_ERROR("UPDATE_PARTNER_PREPAID_DEPOSIT_ERROR","修改预存款错误"),
    UPDATE_PARTNER_LAST_CONTACT_TIME_ERROR("UPDATE_PARTNER_LAST_CONTACT_TIME_ERROR","更新最近往来时间出错"),
    PARTNER_LEVEL_ID_IS_NULL("PARTNER_LEVEL_ID_IS_NULL","客户分类id为空"),
    PARTNER_LEVEL_IS_NULL("PARTNER_LEVEL_IS_NULL","分类名称不能为空"),
    PARTNER_LEVEL_DISCOUNT_IS_NULL("PARTNER_LEVEL_DISCOUNT_IS_NULL","客户分类折扣率为空"),
    PARTNER_LEVEL_TOO_LONG("PARTNER_LEVEL_TOO_LONG","客户分类名称太长"),
    ADD_PARTNER_LEVEL_ERROR("ADD_PARTNER_LEVEL_ERROR","添加客户分类出错"),
    UPDATE_PARTNER_LEVEL_ERROR("UPDATE_PARTNER_LEVEL_ERROR","修改客户分类出错"),
    DEL_PARTNER_LEVEL_ERROR("DEL_PARTNER_LEVEL_ERROR","该分类已被使用，无法删除"),
    PARTNER_LEVEL_IS_USED("PARTNER_LEVEL_IS_USED","该客户分类已被使用，无法删除"),
    PARTNER_LEVEL_IS_DEFAULT("PARTNER_LEVEL_IS_DEFAULT","默认存在，不允许删除"),
    PARTNER_OPERATION_ILLEGALITY("PARTNER_OPERATION_ILLEGALITY","该客户分类引用计数变更操作参数非法"),
    UPDATE_PARTNER_LEVEL_REFERENCE_COUNT_ERROR("UPDATE_PARTNER_LEVEL_REFERENCE_COUNT_ERROR","修改客户分类引用计数出错"),
    UPDATE_RETAIL_CUSTOMER_ERROR("UPDATE_RETAIL_CUSTOMER_ERROR","编辑零售会员错误"),
    ADD_RETAIL_CUSTOMER_ERROR("ADD_RETAIL_CUSTOMER_ERROR","添加零售会员错误"),
    PARTNER_LINK_MAN_IS_NULL("PARTNER_LINK_MAN_IS_NULL","会员名称为空"),
    PARTNER_MOBILE_REPETITION("PARTNER_MOBILE_REPETITION","手机号重复"),
    PARTNER_IS_NULL("PARTNER_IS_NULL","不存在对应供应商或客户或会员"),
    ADD_PARTNER_ERROR("Add_Partner_Error","添加Partner错误"),
    UPDATE_PARTNER_ERROR("Update_Partner_Error","修改Partner错误"),
    NO_DEFAULT_PARTNER("NO_DEFAULT_PARTNER","没有默认Partner"),
    ADD_PARTNER_LEVEL_NAME_ERROR("ADD_PARTNER_LEVEL_NAME_ERROR","该分类已存在，请重新输入"),
    ADD_PARTNER_LEVEL_OVER_ERROR("ADD_PARTNER_LEVEL_OVER_ERROR","超过10个分类，无法新建"),
    BASEINFO_COMPANY_PARTNER_ID_SEQ_FAILED("Baseinfo_Company_Partner_Id_sSeq_Failed","企业中心Partner主键id获取失败"),
    PARTENR_HAVE_ORDER("Partenr_Have_Order","已关联订单，不能删除"),
    UPDATE_COMPANY_CUSTOMER_ERROR("Update_Company_Customer_Error","修改企业客户出错"),
    ADD_PARTNER_ARREARS_ERROR("Add_Partner_Arrears_Error","添加欠款订单错误"),

    PARTNER_MOBILE_MAN_NAME_WECHAT_IS_NULL("PARTNER_MOBILE_MAN_NAME_WECHAT_IS_NULL","名称、负责人、手机号、微信号至少需要一项信息"),
    PARTNER_MOBILE_LINKMAN_NAME_WECHAT_IS_NULL("PARTNER_MOBILE_LINKMAN_NAME_WECHAT_IS_NULL","名称、联系人、手机号、微信号至少需要一项信息"),
    RETAIL_CUSTOMER_IS_NOT_EXISIT("RETAIL_CUSTOMER_IS_NOT_EXISIT","会员信息不存在"),
    DISABLE_RETAIL_CUSTOMER("","禁用会员失败"),
    ENABLE_RETAIL_CUSTOMER("","启用会员失败"),
    ;

    private String errMsg;

    private String errCode;

    private PartnerErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private PartnerErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public static PartnerErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        for (PartnerErrorCodeEnum x : PartnerErrorCodeEnum.values()) {
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
