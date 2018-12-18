package com.ihappy.company.common.enumtype;

/**
 * Created by renyueliang on 2018/3/20.
 */
public enum CompanyErrorCodeEnum {
    RETAIL_CUSTOMER_IS_NOT_EXISTS("RETAIL_CUSTOMER_IS_NOT_EXISTS","会员不存在"),
    MOBILE_IS_NOT_ELEVEN_BITS("mobile_is_not_eleven_bits","手机号不是11位"),
    PARTNER_NAME_LENTH_GREATER_THAN_15_BITS("PARTNER_NAME_LENTH_GREATER_THAN_15_BITS","会员名称小于等于15位"),
    WECHAT_ACCOUNT_NAME_GREATER_THAN_20_BITS("WECHAT_ACCOUNT_NAME_GREATER_THAN_20_BITS","微信号小于等于20字"),
    //公共错误信息
    PUBLIC_STORE_IS_CAN_NOT_FORBIDDEN("public_store_is_can_not_forbidden","公共门店不能被禁用"),
    DEFAULT_STORE_CAN_NOT_BE_DISABLED("default_store_can_not_be_disabled","默认门店不能被禁用"),
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
    CT_ID_IS_NOT_NULL("ct_id_is_not_null","业务类型不能为空"),
    MOBILE_IS_REPEAT("mobile_is_repeat","该手机号已存在于系统中，无需重复新建"),
    VERSION_IS_EMPTY("VERSION_IS_EMPTY","版本号为空"),
    LAST_APP_STORE_VERSION_IS_NULL("LAST_APP_STORE_VERSION_IS_NULL","最新APP Store版本号 为空"),

    //公司相关
    UPDATE_COMPANY_INFO_ERROR("Update_Company_Info_Error","修改公司错误"),
    UPDATE_COMPANY_PRINT_MODE_ERROR("Update_Company_Print_Mode_Error","修改公司打印模式错误"),

    COMPANY_ID_IS_ILLEGAL("COMPANY_ID_IS_ILLEGAL", "公司id非法"),
    COMPANY_ID_IS_NULL("Company_Id_Is_Null", "公司id为空"),
    COMPANY_STATUS_IS_NULL("Company_Status_Is_Null", "公司状态为空"),
    COMPANY_NAME_IS_EMPTY("Company_Name_Is_Empty", "公司名称为空"),
    COMPANY_NATURE_ILLEGAL("Company_Nature_Ilegal", "公司性质值非法"),
    COMPANY_BUSINESS_CATEGORY_IS_NULL("Company_Business_Category_Is_Null", "公司经营类目为空"),
    COMPANY_CT_NAME_ILLEGAL("Company_Ct_Name_ILLEGAL", "公司业务类型非法"),
    ADMIN_PERSON_ID_NULL_ERROR("Admin_Person_Id_Null_Error", "公司管理员id为空"),
    INSERT_COMPANY_FAILED("Insert_Company_Failed", "插入公司失败"),
    GOODS_CATEGORY_IS_NULL("goods_category_is_null","经营类目为空"),

    UPDATE_COMPANY_STATUS_ERROR("Update_Company_Status_Error", "修改公司状态错误"),
    COMPANY_NAME_REPEAT("Company_Name_Repeat", "公司名称重复"),
    COMPANY_IS_EMPTY("Company_Is_Empty", "公司不存在"),
    INVATE_COMPANY_IS_EMPTY("Invate_Company_Is_Empty", "邀请公司为空"),
    REGISTER_COMPANY_IS_EMPTY("Register_Company_Is_Empty", "注册公司为空"),
    COMPANY_IS_NOT_EXIT("Company_Is_Not_Exit", "注册公司不存在，如有疑问，请联系客服"),
    COMPANY_EXTEND_SERVICE_ORDER_NO_IS_EMPTY("Company_Extend_Service_Order_No_Is_Empty", "公司延期订单号为空"),
    COMPANY_EXTEND_SERVICE_ORDER_TYPE_IS_EMPTY("Company_Extend_Service_Order_Type_Is_Empty", "公司延期类型为空"),
    ADD_COMPANY_EXTEND_JOURNAL_ERROR("add_company_extend_journal_error", "添加公司延期流水错误"),
    FACTORY_INFO_ISNULL_ERROR("FACTORY_INFO_ISNULL_ERROR", "工厂信息为空错误"),
    NO_THIS_PERSON("NO_THIS_PERSON","没有该联系人"),

    //企业认证相关
    COMPANY_IS_VERIFIED("COMPANY_IS_VERIFIED","公司已认证通过，无需认证"),

    ADD_COMPANY_VERIFIED_ERROR("ADD_COMPANY_VERIFIED_ERROR","提交认证出错"),

    VERIFY_STATUS_ILLEGAL("VERIFY_STATUS_ILLEGAL","非法审核状态"),

    PRINTPORT_OR_PRINTIP_IS_NULL("PRINTPORT_OR_PRINTIP_IS_NULL","打印参数非法"),


    KEY_FACTORY_COLUMN_NULL_ERROR("Key_Factory_Column_Null_Error","分片字段为空错误"),

    //品牌相关
    BRAND_ID_IS_NULL("Brand_Id_Is_Null","品牌id为空"),

    BRAND_NAME_IS_NULL("Brand_Name_Is_Null","品牌名称为空"),

    DELETE_COMPANY_BRAND_ERROR("Delete_Company_Brand_Error","删除品牌错误"),

    CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS("Can_Not_Delete_Company_Brand_Use_By_Goods","已关联商品的品牌无法删除"),

    BRAND_NAME_REPEAT("Brand_Name_Repeat","品牌名称重复"),

    NO_COMPANY_BRAND_SELECT_ERROR("NO_COMPANY_BRAND_SELECT_ERROR","未选择品牌"),

    //微商铺相关报错
    WESHOP_COLLECTION_OPERATE_TYPE_IS_NULL("weshop_collection_operate_type_is_null","操作类型为空"),

    PERSION_WESHOP_COLLECTION_SEQ_FAILED("person_weshop_collecttion_seq_failed","企业中心商铺的用户收藏表获取主键失败"),

    WESHOP_COLLECTION_JOURNAL_SEQ_FAILED("weshop_collection_journal_seq_failed","企业中心店铺收藏流水表获取主键失败"),

    WESHOP_VISIT_JOURNAL_SEQ_FAILED("weshop_visit_journal_seq_failed","企业中心店铺访问流水表获取主键失败"),

    SALE_PERFORMANCE_SEQ_FAILED("sale_performance_seq_failed","门店销售业绩表获取主键失败"),

    LOGIN_TOKEN_ID_IS_BLANK("LOGIN_TOKEN_ID_IS_BLANK","登陆token为空"),

    WESHOP_IS_OFFLINE("WESHOP_IS_OFFLINE","微商铺已下架"),

    //打印相关
    BILL_TYPE_IS_NULL("bill_type_is_null","单据类型为空"),

    BILL_TYPE_CODE_IS_NULL("bill_type_code_is_null","单据详细类型为空"),

    CONFIG_ID_IS_NULL("config_id_is_null","打印配置id为空"),

    PRINT_MODE_IS_NULL("print_mode_is_null","打印模式为空"),

    COMPANY_PRINT_CONFIG_SEQ_FAILED("company_print_config_seq_failed","企业中心打印设置表获取主键失败"),

    //缴费
    COMPANY_ISEXIST("COMPANY_ISEXIST","公司不存在"),

    ORDER_COMPANY_JOURNAL_OPERATE_ERROR("ORDER_COMPANY_JOURNAL_OPERATE","新增缴费记录是吧"),

    //组织架构相关 baseinfo_company_org
    ORG_IS_NULL("org_is_null","组织架构为空"),

    ORG_ID_IS_NULL("org_id_is_null","组织架构id为空"),

    OPERATE_ERROR("operate_error","操作失败"),

    COMPANY_ORDER_JOURNAL_NOT_ISEXIST("company_order_journal_not_isexist","单据不存在"),

    COMPANY_ORDER_JOURNAL_USE_CANCEL("company_order_journal_use_cancel","单据已被其他管理员作废"),

    COMPANY_ORDER_JOURNAL_USE_PASS("company_order_journal_use_pass","  单据已被审核通过"),

    COMPANY_ORDER_JOURNAL_CANCEL_UPDATE("company_order_journal_cancel_update","单据已被作废，不允许进行编辑"),

    COMPANY_ORDER_JOURNAL_CANCEL_ERROR("company_order_journal_cancel_error","单据作废失败"),

    COMPANY_ORDER_JOURNAL_SOURCE_NO_ERROR("company_order_journal_source_no_error","来源单号已存在"),

    IS_HIDE_IS_NOT_NULL("is_hide_is_not_null","是否隐藏不能为空"),

    INSERT_FAIL("insert_fail","插入失败"),

    UPDATE_FAIL("update_fail","修改失败"),

    DELETE_FAIL("delete_fail","修改失败"),
    //门店相关
    COMPANY_STORE_LIST_IS_NULL("company_store_list_is_null","公司门店列表为空"),
    EMPLOYEE_LIST_IS_NULL("employee_list_is_null","员工列表为空"),
    USER_IS_NULL("user_is_null","用户为空"),
    CONCAT_IS_NOT_EXIT("concat_is_not_exit","联系人不存在"),
    STORE_ID_IS_NULL("store_id_is_null","门店id为空"),
    STORE_IS_NOT_EXIT("store_is_not_exit","门店不存在"),
    STORE_IS_NOT_EXIT_OR_DELETED("store_is_not_exit_or_deleted","门店不存在或已被删除"),
    THIS_SOTRE_IS_BE_BANNED("this_store_is_be_banned","该门店已被禁用"),
    EMPLOYEE_IS_NOT_EXIT("employee_is_not_exit","员工不存在"),
    USER_NOT_EXISIT_OR_DELETED("user_not_exisit_or_deleted","用户不存在或已被删除"),
    MENU_IS_NULL("menu_is_null","菜单为空"),
    STORE_NAME_IS_NOT_EXISTS("STORE_NAME_IS_NOT_EXISTS","开卡门店不存在")
    ;

    private String errMsg;

    private String errCode;

    private CompanyErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private CompanyErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public static CompanyErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        for (CompanyErrorCodeEnum x : CompanyErrorCodeEnum.values()) {
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
