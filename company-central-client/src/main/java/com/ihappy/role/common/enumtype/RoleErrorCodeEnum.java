package com.ihappy.role.common.enumtype;

/**
 * Created by sunjd on 2018/3/31.
 */
public enum RoleErrorCodeEnum {
    //公共错误信息
    CURRENCY_FEN_REGEX("CURRENCY_FEN_REGEX", "金额格式有误"),
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

    ILLGAL_ARGUMENT("ILLGAL_ARGUMENT","非法参数"),
    EXCUTE_SQL_ERROR("EXCUTE_SQL_ERROR","执行数据库错误"),
    ROLE_ID_IS_NULL_ERROR("ROLE_ID_IS_NULL_ERROR","角色id为null"),
    SHARDING_COLUMN_NULL_ERROR("SHARDING_COLUMN_NULL_ERROR", "分片字段为空错误"),
    COMPANY_ROLE_RIGHTS_IS_NULL("COMPANY_ROLE_RIGHTS_IS_NULL","角色权限为空"),
    INIT_COMPANY_ROLE_ERROR("Init_Company_Role_Error", "初始化公司角色出错"),
    BASEINFO_COMPANY_ROLE_ID_SEQ_FAILED("Baseinfo_Company_Role_Id_sSeq_Failed","企业中心角色主键id获取失败"),
    COMPANY_ROLE_NAME_IS_NULL("company_role_name_is_null","角色名称为空"),

    COMPANY_ROLE_NAME_IS_REPEAT("company_role_name_is_repeat","公司角色名称重复"),

    COMPANY_ROLE_ID_IS_NOT_NULL("company_role_id_is_not_null","公司角色id不能为空"),

    COMPANY_ROLE_RIGHTS_IS_NOT_NULL("company_role_rights_is_not_null","公司角色菜单必填"),

    COMPANY_ROLE_NO_IS_NOT_NULL("company_role_no_is_not_null","角色类型不为空"),
    PLEASE_CHANGE_ROLE_TYPE("please_change_role_type","请选择角色类型"),
    SYSTEM_ROLE_NAME_IS_CAN_NOT_UPDATE("system_role_name_is_can_not_update","系统给的角色名称不能修改"),

    SYSTEM_ROLE_NAME_IS_CAN_NOT_DELETED("system_role_name_is_can_not_deleted","系统给的角色名称不能删除"),
    ROLE_NOT_EXISTS("role_not_exists","角色不存在"),

    SYS_ROLE_NOT_CAN_UPDATE("sys_role_not_can_update","系统角色不能修改"),

    SYS_ROLE_NOT_CAN_DELETED("sys_role_not_can_deleted","系统角色不能删除"),

    ROLE_IS_DELETED("role_is_deleted","角色被删除"),

    SYS_ROLE_IS_DELETED("sys_role_is_deleted","系统角色不能删除"),

    COMPANY_ROLE_MENU_LIST_IS_NOT_NULL("company_role_menu_list_is_not_null","公司角色菜单列表不能为空"),

    SYS_COMPANY_ROLE_IS_CAN_NOT_DELETED("sys_company_role_is_can_not_deleted","系统公司角色不能删除"),

    SYS_COMPANY_ROLE_IS_CAN_NOT_UPDATED("sys_company_role_is_can_not_updated","系统公司角色不能修改"),
    ROLE_NAME_IS_LIMIT_10("role_name_is_limit_10","角色名称不超过10位"),

    ROLE_MEMO_MAX_LENGTH("role_memo_max_length","角色描述最大长度不超过30"),

    ROLE_RIGHTS_IS_JSON_ARRAY("role_rights_is_json_array","角色权限必须是JSON数组形式"),

    COMPANY_ROLE_NAME_IS_LIMIT_50("company_role_name_is_limit_50","角色名称不超过50位"),

    COMPANY_ROLE_NO_IS_LIMIT_6("company_role_name_is_limit_10","角色编号不超过6位"),

    //运营后台菜单相关
    CT_FUNC_ID_IS_NOT_NULL("ct_func_id_is_not_null","业务分类id不能为空"),

    FUNC_TYPE_IS_NOT_NULL("func_type_is_not_null","类型不为空"),

    CT_FUNC_NAME_IS_NOT_NULL("ct_func_name_is_not_null","业务分类功能菜单名称不为空"),

    CT_FUNC_NO_IS_NOT_NULL("ct_func_no_is_not_null","编码不为空"),

    PARENT_CT_FUNC_ID_IS_NOT_NULL("parent_ct_func_id_is_not_null","所属菜单不为空"),

    MENU_IS_NOT_EXIST("menu_is_not_exist","菜单不存在"),

    MENU_IS_DELETED("menu_is_deleted","菜单已被删除"),

    MENU_NAME_IS_REPEAT("menu_name_is_repeat","菜单名称重复"),

    MENU_NO_IS_REPEAT("menu_no_is_repeat","菜单编号重复"),

    //运营后台角色相关
    ROLE_NAME_IS_NOT_NULL("role_name_is_not_null","名称不能为空"),

    ROLE_RIGHTS_IS_NOT_NULL("system.role_rights_is_not_null","角色权限不能为空"),

    IS_SYS_NOT_NULL("is_sys_is_not_null","isSys不能为空"),

    ROLE_NAME_IS_REPEAT("role_name_is_repeat","角色名称重复"),

    CT_ID_IS_NOT_NULL("client_id_is_not_null","分类ID不为空"),

    CL_ID_IS_NOT_NULL("cl_id_is_not_null","客户端ID不为空"),

    SYS_COMPANY_TYPE_INFO_IS_NOT_NULL("sys_company_type_info_is_not_null","系统公司类型信息不能为空"),

    SYS_CLIENT_LIST_IS_NOT_NULL("sys_client_list_is_not_null","系统客户端列表不为空"),

    SYS_COMPANY_TYPE_is_DELETED("sys_company_type_is_deleted","系统公司类型已被删除"),

    ROLE_IS_USED("role_is_used","角色已被使用，无法删除"),

    SYS_COMPANY_FUNC_LIST_IS_NOT_NULL("sys_company_func_list_is_not_null","系统公司功能菜单列表不能为空"),

    SYS_COMPANY_ROLE_LIST_IS_NOT_NULL("sys_company_role_list_is_not_null","系统公司角色列表不能为空"),

    SYS_COMPANY_TYPE_LIST_IS_NOT_NULL("sys_company_type_list_is_not_null","系统公司类型列表不能为空"),

    IS_HIDE_IS_NOT_NULL("is_hide_is_not_null","是否隐藏不能为空"),
    ;

    private String errMsg;

    private String errCode;

    private RoleErrorCodeEnum(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private RoleErrorCodeEnum(String errCode){
        this.errCode = errCode;
    }

    public static RoleErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        for(RoleErrorCodeEnum x: RoleErrorCodeEnum.values()) {
            if(x.getErrCode().equals(code)) {
                return x;
            }
        }
        return null;
    }

    public String getErrCode(){
        return this.errCode;
    }

    public String getErrMsg(){
        return this.errMsg;
    }
}
