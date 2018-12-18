#增加公司过期时间  sunjd  2018-06-28
ALTER TABLE `baseinfo_company`
ADD COLUMN `expire_date`  bigint(14) NOT NULL DEFAULT 0 COMMENT '公司过期时间' AFTER `allow_negative_on_hand_sell`;

#增加 公司服务期限延长流水表 sunjd  2018-06-28
CREATE TABLE `baseinfo_company_extend_service_journal` (
  `journal_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '公司服务延长流水id',
  `comp_id` int(11) NOT NULL DEFAULT '0' COMMENT '企业id ',
  `order_no` varchar(64) NOT NULL COMMENT '来源订单号',
  `money` bigint(16) NOT NULL DEFAULT '0' COMMENT '金额-单位分',
  `source_type` tinyint(4) unsigned NOT NULL COMMENT '来源  0、充值',
  `time` int(11) NOT NULL DEFAULT '0' COMMENT '延长时间 单位（天）',
  `order_type` varchar(16) NOT NULL DEFAULT '' COMMENT '来源订单的原始类型',
  `created_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '修改时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人ID',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人ID',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否软删除 0 未删除，1已删除',
  PRIMARY KEY (`journal_id`),
  UNIQUE KEY `order_no_source_type_unique_index` (`order_no`,`source_type`) USING BTREE,
  KEY `comp_id_index` (`comp_id`) USING BTREE,
  KEY `source_type_index` (`source_type`) USING BTREE,
  KEY `order_type_index` (`order_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司服务期限延长流水表';

#增加 企业支付记录表 sunjd  2018-06-29
CREATE TABLE `order_company_journal` (
  `order_id` bigint(20) NOT NULL /*!50606 COLUMN_FORMAT DYNAMIC */ AUTO_INCREMENT COMMENT '编号',
  `order_no` varchar(512) NOT NULL COMMENT '交易流水号',
  `pay_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付时间',
  `pay_person_login` varchar(256) NOT NULL DEFAULT '' COMMENT '支付账户',
  `pay_person_name` varchar(256) NOT NULL DEFAULT '' COMMENT '付款人',
  `pay_type` int(11) NOT NULL COMMENT '支付类型',
  `pay_money` bigint(20) NOT NULL DEFAULT '0' COMMENT '付款金额',
  `comp_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '公司id',
  `ct_id` int(11) NOT NULL DEFAULT '0' COMMENT '业务类型',
  `pay_content` varchar(256) NOT NULL DEFAULT '' COMMENT '购买内容',
  `is_bill` int(11) NOT NULL DEFAULT '0' COMMENT '是否开票',
  `pay_title` varchar(256) NOT NULL DEFAULT '' COMMENT '开票抬头',
  `tax_no` varchar(64) NOT NULL DEFAULT '' COMMENT '税号',
  `invite_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '邀请人',
  `invite_person_mobile` varchar(255) NOT NULL DEFAULT '' COMMENT '邀请人手机号',
  `service_due_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '服务到期时间',
  `momo` varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
  `momo_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '备注人id',
  `memo_person_name` varchar(128) NOT NULL DEFAULT '' COMMENT '备注人名称',
  `register_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '注册时间',
  `register_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '注册人',
  `register_person_mobile` varchar(32) NOT NULL DEFAULT '' COMMENT '注册人手机号',
  `created_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `updated_at` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `source_order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单来源单号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='企业支付记录表';

#企业表 增加版本号 version sunjd  2018-06-29
ALTER TABLE `baseinfo_company`
ADD COLUMN `version`  int(11) NOT NULL DEFAULT 0 COMMENT '版本号' AFTER `expire_date`;

#企业表增加  若干字段  sunjd  2018-06-29
ALTER TABLE `baseinfo_company`
ADD COLUMN `pay_remark`  varchar(255) NOT NULL DEFAULT '' COMMENT '付款备注' AFTER `version`,
ADD COLUMN `pay_remark_user_name`  varchar(128) NOT NULL DEFAULT '' COMMENT '付款备注者 姓名' AFTER `pay_remark`,
ADD COLUMN `pay_remark_user_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '付款备注者 id' AFTER `pay_remark_user_name`,
ADD COLUMN `pay_remark_time`  bigint(14) NOT NULL DEFAULT 0 COMMENT '付款备注时间' AFTER `pay_remark_user_id`;

# 公司服务期限延长流水表 增加一个字段 sunjd 2018-07-03
ALTER TABLE `baseinfo_company_extend_service_journal`
ADD COLUMN `fund_status`  int(11) NOT NULL DEFAULT 1 COMMENT '资金状态 1-支付，2-收入' AFTER `is_deleted`;

#增加字段 liuhc
ALTER TABLE `order_company_journal`
ADD COLUMN `is_cancel`  int(11) NOT NULL DEFAULT 0 COMMENT '0:正常 1作废' AFTER `source_order_no`;

