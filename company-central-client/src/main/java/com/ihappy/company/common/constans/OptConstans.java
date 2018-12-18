package com.ihappy.company.common.constans;

/**
 * Created by renyueliang on 2018/3/6.
 */
public class OptConstans {

    //操作类型 增删改查
    public static final String OPERATION_TYPE_TEST_ADD="I" ;
    public static final String OPERATION_TYPE_TEST_UPDATE="U" ;
    public static final String OPERATION_TYPE_TEST_QUERY="Q" ;
    public static final String OPERATION_TYPE_TEST_DELETE="D" ;

    //业务操作
    public static final String BUSS_OPERATION_TYPE_TEST_NEWCATEGORY = "newcategory";
    public static final String BUSS_OPERATION_TYPE_TEST_UPDATECATEGORY = "updatecategory";
    public static final String BUSS_OPERATION_TYPE_TEST_QUERYCATEGORY = "querycategory";
    public static final String BUSS_QUERY_COMPANY_LIST = "queryCompanyList";
    public static final String BUSS_UPDATE_COMPANY_STATUS = "updateCompanyStatus";
    public static final String BUSS_QUERY_COMPANY_INFO = "queryCompanyInfo";
    public static final String BUSS_UPDATE_COMPANY_INFO = "updateCompanyInfo";
    public static final String BUSS_QUERY_PROVIDER_LIST = "queryProviderList";
    public static final String BUSS_QUERY_COMPANY_ROLEID_LIST = "queryProviderList";
    public static final String BUSS_QUERY_COMPNAY_ROLEID_LIST_COUNT = "queryCompanyRoleIdListCount";

    //查询应用是否需要 app store更新或热更新
    public static final String QUEREY_UPDATE_STATUS = "QUEREY_UPDATE_STATUS";

    //禁用会员
    public static final String DISABLE_RETAIL_CUSTOMER="DISABLE_RETAIL_CUSTOMER";
    //启用会员
    public static final String ENABLE_RETAIL_CUSTOMER="ENABLE_RETAIL_CUSTOMER";
    //新增企业门店
    public static final String ADD_COMPANY_STORE = "addCompanyStore";
    //修改企业门店
    public static final String UPDATE_COMPANY_STORE = "updateCompanyStore";
    //删除企业门店
    public static final String DELETE_COMPANY_STORE = "deleteCompanyStore";
//禁用门店
    public static final String DISABLE_STORE="disableStore";
    //启用门店
    public static final String ENABLE_STORE="enableStore";
    public static final String BUSS_ADD_COMPANY_INFO="addCompanyInfo";
    public static final String COMPLETION_COMPANY_INFO="completionCompanyInfo";
    public static final String BUSS_QUERY_COMPANY_INFO_LIST_BY_IDS="queryCompanyInfoListByIds";
    public static final String BUSS_QUERY_QUERY_PROVIDER="queryProvider";
    public static final String FIND_PARTNER_STATISTICS="FIND_PARTNER_STATISTICS";
    public static final String FIND_PARTNER_PAGE="FIND_PARTNER_PAGE";
    public static final String FIND_PARTNER_LIST="FIND_PARTNER_LIST";
    public static final String BUSS_QUERY_CUSTOMER="queryCustomer";
    public static final String BUSS_QUERY_CUSTOMER_LIST="queryCustomerList";
    public static final String BUSS_ADD_PROVIDER="addProvider";
    public static final String BUSS_UPDATE_PROVIDER="updateProvider";
    public static final String BUSS_ADD_CUSTOMER="addCustomer";
    public static final String BUSS_UPDATE_CUSTOMER="updateCustomer";
    public static final String BUSS_QUERY_COMPANY_BRAND_LIST="queryCompanyBrandList";
    public static final String BUSS_ADD_COMPANY_BRAND="addCompanyBrand";
    public static final String BUSS_DEL_COMPANY_BRAND="delCompanyBrand";
    public static final String BUSS_DEL_COMPANY_BRANDS="delCompanyBrands";
    public static final String BUSS_DEL_COMPANY_PARTNER="delCompanyPartner";
    public static final String ADD_PARTNER_BY_INVATE_REGISTER="addPartnerByInvateRegister";
    public static final String BUSS_QUERY_COMPANY_SOTRE_LIST="queryStoreListByCompIdAndStoreIds";
    public static final String QUERY_COMPANY_SOTRE="queryStoreInfo";
    public static final String QUERY_PERFORMANCE_PAGE="queryPerformancePage";
    public static final String QUERY_PERFORMANCE="QUERY_PERFORMANCE";
    public static final String QUERY_PERSON_PERFORMANCE_PAGE="queryPersonPerformancePage";
    public static final String ADD_PERSON_PERFORMANCE="addPersonPerformance";
    public static final String QUERY_STORE_LIST="query_store_list";
    public static final String QUERY_STORE_PAGE = "queryStorePage";
    public static final String QUERY_STORE_MANAGER = "queryStoreManager";
    public static final String QUERY_STORE_SERVICE_STATUS_PAGE = "queryStoreServiceStatusPage";
    public static final String PASS_REVIEW_ORDER = "passReviewOrder";
    public static final String UPDATE_STORE_PAY_REMARK = "updateStorePayRemark";
    public static final String FIND_STORE_LIST = "findStoreList";
    public static final String QUERY_SALE_PERFORMANCE_BY_CONDITION = "QUERY_SALE_PERFORMANCE_BY_CONDITION";
    public static final String FIND_STORE_LIST_BY_CONDITION = "FIND_STORE_LIST_BY_CONDITION";



    public static final String QUERY_STORE_LIST_WITH_PUBLIC_BY_COMPID_AND_STOREIDS="findStoreListWithPublicByCompIdAndStoreIds";
    public static final String BUSS_QUERY_WESHOP_VISIT_DETAIL_LIST="queryWeshopVisitDetailList";
    public static final String BUSS_UPDATE_COMPANY_SOTRE="updateCompanyStoreWeshopInfo";
    public static final String BUSS_QUERY_COMPANY_SOTRE_DETAIL = "queryCompanyStoreDetail";
    public static final String QUERY_COMPANY_SOTRE_DETAIL_WITHOUT_LOGIN = "queryCompanyStoreDetailWithoutLogin";
    public static final String BUSS_QUERY_DEF_PROVIDER_LIST="queryDefProviderList";
    public static final String BUSS_QUERY_DEF_CUSTOMER_LIST="queryDefCustomerList";
    public static final String BUSS_QUERY_STORE_STOCK_LIST="queryStoreStockList";
    public static final String BUSS_ADD_STOCK="addStock";
    public static final String ADD_OR_QUERY_STOCK="addOrQueryStock";
    public static final String BUSS_QUERY_STOCK="queryStock";
    public static final String BUSS_UPDATE_STOCK="updateStock";
    public static final String BUSS_UPDATE_STOCK_STATUS="updateStockStatus";
    public static final String BUSS_ADD_PARTNER_ARREARS_ORDER="addPartnerArrearsOrder";
    public static final String BUSS_UPDATE_PARTNER_LAST_CONTACT_TIME="updatePartnerLastContactTime";
    public static final String QUERY_PARTNER_LEVEL="queryPartnerLevel";
    public static final String QUERY_PARTNER_LEVEL_LIST="queryPartnerLevelList";
    public static final String ADD_PARTNER_LEVEL="addPartnerLevel";
    public static final String UPDATE_PARTNER_LEVEL="updatePartnerLevel";
    public static final String DEL_PARTNER_LEVEL="delPartnerLevel";
    public static final String PARTNER_QUERY_OR_ADD="PARTNER_QUERY_OR_ADD";

    public static final String UPDATE_REFERENCE_COUNT="updateReferenceCount";
    public static final String QUERY_STOCK_LIST_BY_IDS="queryStockListByIds";
    public static final String UPDATE_STOCK_INVENTORYING="updateStockInventorying";
    public static final String CLEAR_STOCK_INVENTORYING="clearStockInventorying";
    public static final String QUERY_PARTNER="queryPartner";
    public static final String ADD_RETAIL_CUSTOMER="addRetailCustomer";
    public static final String UPDATE_RETAIL_CUSTOMER="updateRetailCustomer";
    public static final String DEL_RETAIL_CUSTOMER="delRetailCustomer";
    public static final String QUERY_RETAIL_CUSTOMER="queryRetailCustomer";
    public static final String QUERY_RETAIL_CUSTOMER_PAGE="queryRetailCustomerPage";
    public static final String UPDATE_PRINT_IP_AND_PORT="updatePrintIpAndPort";
    public static final String QUERY_PRINT_IP_AND_PORT="queryPrintIpAndPort";
    public static final String SHARE_WESHOP="shareWeshop";
    public static final String GET_STOCK_LIST_BY_STORE_ID_LIST="getStockListByStoreIdList";
    public static final String GET_STOCK_LIST_BY_CONDITION="getStockListByCondition";
    public static final String UPDATE_USER_COLLECTION_STORE="updateWeshopCollection";
    public static final String ADD_WESHOP_VISIT="addWeshopVisit";
    public static final String GET_STOCK_MAP_BY_USER_INFO="getStockMapByUserInfo";
    public static final String GENERATE_DEFAULT_INFORMATION = "generateDefaultInformation";
    public static final String QUERY_SYSCOMPANYFUNCLIST="querySysCompanyFuncList";

    //查询默认Partner
    public static final String QUERY_DEF_PROVIDER="QUERY_DEF_PROVIDER";

    public static final String QUERY_PRINT_CONFIG = "queryPrintConfig";
    public static final String UPDATE_PRINT_CONFIG = "updatePrintConfig";
    public static final String QUERY_PRINT_CONFIG_LIST = "queryPrintConfigList";
    //查询企业认证信息
    public static final String QUERY_VERIFY_COMPANY_INFO = "queryVerifyCompanyInfo";
    //添加企业认证信息
    public static final String ADD_VERIFY_COMPANY_INFO = "addVerifyCompanyInfo";
    //审核企业信息
    public static final String VERIFY_COMPANY_INFO = "verifyCompanyInfo";

    //审核企业信息
    public static final String QUERY_COMPANY_INFO_WITHOUT_LOGIN = "queryCompanyInfoWithoutLogin";
    //查询公司有效期
    public static final String QUERY_COMPANY_EXPIRE_INFO = "queryCompanyExpireInfo";
    //查询用户缴费记录
    public static final String QUERY_ORDER_COMPANY_JOURNAL = "queryOrderCompanyJournal";
    public static final String UPDATE_COMPANY_PAY_REMARK = "updateCompanyPayRemark";

    //修改企业条码打印设置
    public static final String UPDATE_COMPANY_BAR_CODE_CONFIG = "updateCompanyBarCodeConfig";
    public static final String QUERY_COMPANY_BAR_CODE_CONFIG = "queryCompanyBarCodeConfig";


    public final static Long DEMO_ACCOUNT_1=181L;
    public final static Long DEMO_ACCOUNT_2=182L;
    public final static Long DEMO_ACCOUNT_3=183L;
    //添加公司角色
    public static final String ADD_COMPANY_ROLE = "addCompanyRole";
    //修改公司角色信息
    public static final String UPDATE_COMPANY_ROLE_INFO = "updateCompanyRoleInfo";
    //修改系统公司角色信息
    public static final String UPDATE_SYS_COMPANY_ROLE_INFO = "updateSysCompanyRoleInfo";
    //删除公司角色信息
    public static final String DELETE_COMPANY_ROLE_INFO = "deleteCompanyRoleInfo";
    //删除公司角色信息
    public static final String DELETE_SYS_COMPANY_ROLE_INFO = "deleteSysCompanyRoleInfo";
    //查询公司角色详情
    public static final String QUERY_COMPANY_ROLE_INFO = "queryCompanyRoleInfo";
    //查询公司角色列表角色ID数量
    public static final String QUERY_COMPANY_ROLE_ID_COUNT = "queryCompanyRoleIdCount";
    //查询公司角色菜单列表
    public static final String QUERY_COMPANY_ROLE_MENU_LIST="queryCompanyRoleMenuList";
    //查询公司角色类型列表
    public static final String QUERY_COMPANY_ROLE_TYPE_LIST="queryCompanyRoleTypeList";
    //复制角色
    public static final String COPY_ROLE="copyRole";
    //查询运营后台角色列表
    public static final String QUERY_ROLE_LIST = "queryRoleidList";
    //查询运营后台角色详情
    public static final String QUERY_ROLE_INFO = "queryRoleInfo";
    //修改运营后台角色信息
    public static final String UPDATE_ROLE_INFO = "updateRoleInfo";
    //删除运营后台角色信息
    public static final String DELETE_ROLE_INFO = "deleteRoleInfo";
    //添加运营后台角色信息
    public static final String ADD_SYS_ROLE_INFO = "addSysRoleInfo";
    //查询系统客户端列表
    public static final String QUEY_SYS_CLIENT_LIST="querySysClientList";
    //查询系统公司类型列表
    public static final String QUERY_SYS_COMPANY_TYPE_LIST="querySysCompanyTypeList";
    //查询系统公司角色详情应用配置类型列表
    public static final String QUERY_SYS_COMPANY_ROLE_INFO_CLIENT_TYPE_LIST="querySysCompanyRoleInfoClientTypeList";
    //查询运营后台平台设定角色配置角色添加应用配置类型列表
    public static final String QUERY_SYS_COMPANY_ROLE_ADD_CLIENT_TYPE_LIST="querySysCompanyRoleAddClientTypeList";
    //查询运营后台平台设定角色配置角色添加应用配置类型功能列表
    public static final String QUERY_SYS_COMPANY_ROLE_ADD_CLIENT_TYPE_FUNC_LIST="querySysCompanyRoleAddClientTypeFuncList";
    //分页常量
    public static final Integer PAGE_LIMIT_MAX = 200;
    //ct_ids 分界符
    public static final String CT_IDS_SEPARATOR = ",";
    //默认公司名称
    public static final String DEFAULE_COMP_NAME = "默认企业";
    //供应商/客户默认列表 收藏列表大小
    public static final Integer DEFAULT_PARTNER_FAVOR_SIZE = 5;
    //供应商/客户默认列表 最近往来列表大小
    public static final Integer DEFAULT_PARTNER_LAST_CONTACT_SIZE = 10;
    //仓库列表 公共仓库显示名称
    public static final String PUBLIC_STOCK_NAME = "总仓(门店公用)";
    //map初始容量
    public static final Integer MAP_INITIALCAPACITY = 16;
    //已关联商品的品牌无法删除
    public static final String CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS = "已关联商品的品牌无法删除";
    //锁库存
    public static final Integer STOCK_LOCK = 1;
    //默认会员名称
    public static final String DEF_PARTNER_LEVEL_NAME = "VIP1";
    //默认会员折扣率
    public static final Integer DEF_PARTNER_LEVEL_DISCOUNT = 100;
    //默认会员名称
    public static final String DEF_PARTNER_COM_LEVEL_NAME = "散客";

    public static final String QUERY_COMPANY_TYPE = "QUERY_COMPANY_TYPE";

    //后门
    public static final String REFRESH_PARTNER_STATICS = "REFRESH_PARTNER_STATICS";
    public static final String DELETE_REDIS = "DELETE_REDIS";
    //部门信息
    public static final String GET_SYS_ORG_INFO = "GET_SYS_ORG_INFO";
    public static final String GET_SYS_ORG_INFO_QUERY = "GET_SYS_ORG_INFO_QUERY";
    //查询部门信息
    public static final String QUERY_SYS_ORG_BY_ORG_ID_LIST = "QUERY_SYS_ORG_BY_ORG_ID_LIST";
    public static final String GET_ALL_CHILD_SYS_ORG_BY_ID = "GET_ALL_CHILD_SYS_ORG_BY_ID";
    //延长公司服务到期时间,并且生成流水
    public static final String ADD_COMPANY_EXTEND_SERVICE_JOURNAL = "ADD_COMPANY_EXTEND_SERVICE_JOURNAL";

    public static final String ADD_ORDER_COMPANY_SERVICE_JOURNAL = "ADD_ORDER_COMPANY_SERVICE_JOURNAL";
    public static final String UPDATE_ORDER_COMPANY_SERVICE_JOURNAL = "UPDATE_ORDER_COMPANY_SERVICE_JOURNAL";
    public static final String QUERY_ORDER_COMPANY_SERVICE_JOURNAL = "QUERY_ORDER_COMPANY_SERVICE_JOURNAL";
    public static final String QUERY_COMPANY_SERVICE_STATUS_PAGE = "queryCompanyServiceStatusPage";

    //默认公司服务到期天数
    public static final Integer DEFAULT_COMPANY_SERVICE_TIME = 15;
    //查询菜单列表
    public static final String QUERY_MENU_LIST="queryMenuList";
    //删除菜单
    public static final String DELETE_MENU="deleteMenu";
    //添加菜单
    public static final String ADD_MENU="addMenu";
    //查询菜单详情
    public static final String QUERY_MENU_INFO="queryMenuInfo";
    //修改菜单
    public static final String UPDATE_MENU="updateMenu";
    //查询类型列表
    public static final String QUERY_TYPE_LIST="queryTypeList";
    //查询类型菜单列表
    public static final String QUERY_TYPE_MENU_LIST="queryTypeMenuList";
    //查询类型菜单详情
    public static final String QUERY_TYPE_MENU_INFO="queryTypeMenuInfo";
    //微商铺分享二维码图片地址键值
    public static final String WESHOP_SHARE_QRCODE_URL_KEY = "WESHOP_SHARE_QRCODE_URL_KEY";

    public static final String UPDATE_FACTORY_INFO ="UPDATE_FACTORY_INFO";

    //动作 查询工厂信息返回list
    public static final String QUERY_COMPANY_FACTORYINFO_LIST ="QUERY_COMPANY_FACTORYINFO_LIST";

    //动作 查询工厂信息返回 object
    public static final String QUERY_COMPANY_FACTORYINFO_OBJECT ="QUERY_COMPANY_FACTORYINFO_OBJECT";
    //年树
    public static final Integer ADD_DEFAULT_YEAR_TIME = 365;
    public static final Integer REDUCE_DEFAULT_YEAR_TIME = -365;
    //根据不同的权限查询角色列表
    public static final String QUERY_APP_ROLE_LIST_BY_DIFF_POWER="QUERY_APP_ROLE_LIST_BY_DIFF_POWER";
}
