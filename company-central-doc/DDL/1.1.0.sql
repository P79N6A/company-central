#企业角色表 把唯一索引改为普通索引  所有表/环境已修改  sunjd  2018-08-29
ALTER TABLE `baseinfo_company_role_0`
DROP INDEX `comp_no_unique_index` ,
ADD INDEX `comp_no_index` (`comp_id`, `role_no`) USING BTREE ;

-- cy 修改创建人和修改人类型 2018.09.11
ALTER TABLE `comp_central`.`baseinfo_company_store` CHANGE COLUMN `created_person_id` `created_person_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
CHANGE COLUMN `updated_person_id` `updated_person_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '修改人';
