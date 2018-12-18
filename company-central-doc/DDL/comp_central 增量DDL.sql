#2018-05-22 sunjd 修改注释  baseinfo_partner_arrears_order 所有表都要改
ALTER TABLE `baseinfo_partner_arrears_order_0`
MODIFY COLUMN `income_type`  tinyint(4) UNSIGNED NOT NULL COMMENT '收入类型  1、欠款增加 2、欠款减少' AFTER `source_type`;

#2018-05-22 sunjd 修正拼写错误  baseinfo_company_partner 所有表都要改
ALTER TABLE `baseinfo_company_partner_8`
CHANGE COLUMN `menber_no` `member_no`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会员编号' AFTER `forbidden`;

#2018-06-04 sunjd 增加 allow_negative_on_hand_sell 字段
ALTER TABLE `baseinfo_company`
ADD COLUMN `allow_negative_on_hand_sell`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '允许负库存销售标志    0：不允许  1：允许   默认：1' AFTER `print_warn`;

#2018-06-06 sunjd 增加 企业认证历史记录表
CREATE TABLE `baseinfo_company_verified_history` (
  `verified_history_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '企业认证历史记录id',
  `comp_id` int(11) unsigned NOT NULL COMMENT '企业ID',
  `nature` tinyint(1) NOT NULL DEFAULT '1' COMMENT '公司性质(1 企业 2 个体户)',
  `comp_short_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `legal_man` varchar(30) NOT NULL DEFAULT '' COMMENT '法人代表姓名',
  `card_front_url` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证正面url',
  `card_back_url` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证反面url',
  `license` varchar(20) NOT NULL DEFAULT '' COMMENT '营业执照号(企业/个体户号)',
  `license_picurl` varchar(50) NOT NULL DEFAULT '' COMMENT '营业执照照片地址(企业/个体户号的照片)',
  `is_verified` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否审核(0:未认证 1:待审核 2:审核通过 3:审核不通过)',
  `verified_reason` varchar(255) NOT NULL DEFAULT '' COMMENT '审核原因',
  `created_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`verified_history_id`),
  KEY `comp_id_index` (`comp_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业认证历史记录表';