#系统参数表 孙缙东  2018-12-3 dev sit
CREATE TABLE `sys_param` (
  `param_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_key` varchar(50) NOT NULL COMMENT '键',
  `param_value` varchar(255) NOT NULL COMMENT '值',
  `param_name` varchar(50) NOT NULL COMMENT '名称',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '修改时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否软删除 0 未删除，1已删除',
  PRIMARY KEY (`param_id`),
  UNIQUE KEY `unique_k` (`param_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='系统参数表';

-- 增加是否通知供应商/客户字段
-- 张腾坡 dev sit
alter table comp_central.baseinfo_company add column order_seller_notify tinyint(1) not null default 0 comment '销售单是否通知客户, 0-不通知,1-通知';
alter table comp_central.baseinfo_company add column order_buyer_notify tinyint(1) not null default 0 comment '采购单是否通知供应商, 0-不通知,1-通知';