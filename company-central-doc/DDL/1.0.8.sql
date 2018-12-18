#门店表增加字段 用以标识是否是总店
ALTER TABLE `baseinfo_company_store`
MODIFY COLUMN `store_id`  bigint(20) UNSIGNED NOT NULL COMMENT 'id' FIRST ,
ADD COLUMN `is_public`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否默认门店（总店） 0：不是  1：是' AFTER `attributes`;

#欠款流水唯一索引更改 2018-08-01
ALTER TABLE `baseinfo_partner_arrears_order_0`
DROP INDEX `order_num_unique_index` ,
ADD UNIQUE INDEX `order_num_type_unique_index` (`order_num`, `income_type`) USING BTREE ;