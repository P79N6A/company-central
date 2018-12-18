#comp_central 数据库
#公司
SELECT * from baseinfo_company where comp_id in (233,234,235);
#仓库
SELECT * FROM baseinfo_company_stock where comp_id in (233,234,235);
#门店
SELECT * from baseinfo_company_store where comp_id in (233,234,235);
#品牌
SELECT * from baseinfo_company_brand where comp_id in (233,234,235);
#客户/供应商
SELECT * from baseinfo_company_partner_8 where comp_id in (233,234,235);
SELECT * from baseinfo_company_partner_0 where comp_id in (233,234,235);
SELECT * from baseinfo_company_partner_1 where comp_id in (233,234,235);
#会员等级
SELECT * from baseinfo_company_partner_level_8 where comp_id in (233,234,235);
SELECT * from baseinfo_company_partner_level_0 where comp_id in (233,234,235);
SELECT * from baseinfo_company_partner_level_1 where comp_id in (233,234,235);
#打印配置
SELECT * from baseinfo_company_print_config where comp_id in (233,234,235);
#角色
SELECT * from baseinfo_company_role_5 where comp_id in (233,234,235);
SELECT * from baseinfo_company_role_0 where comp_id in (233,234,235);
SELECT * from baseinfo_company_role_1 where comp_id in (233,234,235);

#删除
#公司
DELETE from baseinfo_company where comp_id in (233,234,235);
#仓库
DELETE FROM baseinfo_company_stock where comp_id in (233,234,235);
#门店
DELETE from baseinfo_company_store where comp_id in (233,234,235);
#品牌
DELETE from baseinfo_company_brand where comp_id in (233,234,235);
#客户/供应商
DELETE from baseinfo_company_partner_8 where comp_id in (233,234,235);
DELETE from baseinfo_company_partner_0 where comp_id in (233,234,235);
DELETE from baseinfo_company_partner_1 where comp_id in (233,234,235);
#会员等级
DELETE from baseinfo_company_partner_level_8 where comp_id in (233,234,235);
DELETE from baseinfo_company_partner_level_0 where comp_id in (233,234,235);
DELETE from baseinfo_company_partner_level_1 where comp_id in (233,234,235);
#打印配置
DELETE from baseinfo_company_print_config where comp_id in (233,234,235);
#角色
DELETE from baseinfo_company_role_5 where comp_id in (233,234,235);
DELETE from baseinfo_company_role_0 where comp_id in (233,234,235);
DELETE from baseinfo_company_role_1 where comp_id in (233,234,235);