#会员等级增加 是否默认、是否可编辑  2018-06-25  孙缙东 范围 baseinfo_company_partner_level_0-8
ALTER TABLE `baseinfo_company_partner_level_0`
ADD COLUMN `is_default`  tinyint(2) NOT NULL DEFAULT 0 COMMENT '1-是默认，0-不是默认' AFTER `reference_count`,
ADD COLUMN `is_can_edit`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '是否可编辑，0-不可以，1-可以' AFTER `is_default`;

#微商铺访问量表 增加字段 sunjd 2018-07-04
ALTER TABLE `weshop_visit_0`
ADD COLUMN `uid`  varchar(64) NOT NULL DEFAULT '' COMMENT '用户身份标识' AFTER `comp_id`,
ADD COLUMN `uid_type`  int(11) NOT NULL DEFAULT 0 COMMENT '表示 uid 存储的内容类型  0-无  1-用户id  2-访问ip' AFTER `uid`;

ALTER TABLE `weshop_visit_journal_0`
ADD COLUMN `uid`  varchar(64) NOT NULL DEFAULT '' COMMENT '用户身份标识' AFTER `is_deleted`,
ADD COLUMN `uid_type`  int(11) NOT NULL DEFAULT 0 COMMENT '表示 uid 存储的内容类型  0-无  1-用户id  2-访问ip' AFTER `uid`;

#门店增加属性字段
ALTER TABLE `baseinfo_company_store`
ADD COLUMN `attributes`  varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '属性，json字符串' AFTER `is_default`;

