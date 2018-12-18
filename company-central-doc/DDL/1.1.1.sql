#修改字 partnre 名称字符集 以支持 表情符号  所有环境已更新
ALTER TABLE `baseinfo_company_partner_0`
MODIFY COLUMN `partner_name`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '合伙人企业名称' AFTER `partner_comp_id`,
MODIFY COLUMN `partner_linkman`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '联系人  当partner_type = 0(供应商) 时此字段有意义，客户和零售会员与partnerName保持一致' AFTER `is_deleted`;

ALTER TABLE `baseinfo_company_store`
MODIFY COLUMN `store_name`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '门店名称' AFTER `store_no`,
MODIFY COLUMN `province`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '省 可以没有片区，直接从省开始' AFTER `area_id`,
MODIFY COLUMN `city`  varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '市' AFTER `province`,
MODIFY COLUMN `zone`  varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '区' AFTER `city`,
MODIFY COLUMN `address`  varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '门店地址' AFTER `zone`,
MODIFY COLUMN `weshop_name`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商铺名称' AFTER `is_deleted`,
MODIFY COLUMN `weshop_city`  varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微商铺-市' AFTER `weshop_province`,
MODIFY COLUMN `weshop_zone`  varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微商铺-区' AFTER `weshop_city`,
MODIFY COLUMN `weshop_address`  varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微商铺-地址' AFTER `weshop_zone`;

