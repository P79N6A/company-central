#Partner 增加交易总额  待发货总数  总交易件数  交易单数  最长欠款时间  2018-08-09 孙缙东  所有数据库已更新
ALTER TABLE `baseinfo_company_partner_0`
ADD COLUMN `due_amount`  bigint(20) NOT NULL DEFAULT 0 COMMENT '交易总额  单位分' AFTER `is_default`,
ADD COLUMN `ontheway_number`  bigint(20) NOT NULL DEFAULT 0 COMMENT '待发货总数' AFTER `due_amount`,
ADD COLUMN `total_number`  bigint(20) NOT NULL DEFAULT 0 COMMENT '总交易件数' AFTER `ontheway_number`,
ADD COLUMN `order_count`  bigint(20) NOT NULL DEFAULT 0 COMMENT '交易单数' AFTER `total_number`,
ADD COLUMN `debt_date`  bigint(14) NOT NULL DEFAULT 0 COMMENT '最长欠款时间' AFTER `order_count`;
ADD COLUMN `prepaid_deposit`  bigint(14) NOT NULL DEFAULT 0 COMMENT '预存款' AFTER `debt_date`;

#欠款流水表 增加 操作类型  2018-08-09 孙缙东  所有数据库已更新
ALTER TABLE `baseinfo_partner_arrears_order_0`
ADD COLUMN `type`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '操作类型   0：保留值   null/1：欠款   2：预存款' AFTER `order_type`;

#企业表增加attributes 字段  所有数据库已更新
ALTER TABLE `baseinfo_company`
ADD COLUMN `attributes`  varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '相关属性' AFTER `expire_status`;

#欠款流水表唯一索引增加 type 所有数据库已更新
ALTER TABLE `baseinfo_partner_arrears_order_0`
DROP INDEX `order_num_type_unique_index` ,
ADD UNIQUE INDEX `order_num_type_unique_index` (`order_num`, `income_type`, `type`) USING BTREE ;

