CREATE TABLE `weshop_collection_journal_0` (
`weshop_collection_journal_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
`visit_user_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '用户id' ,
`visit_token`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '本次访问token' ,
`store_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '商铺id' ,
`comp_id`  int(11) NOT NULL DEFAULT 0 COMMENT '所属公司id' ,
`collected_time`  bigint(20) NOT NULL DEFAULT 0 COMMENT '收藏时间' ,
`created_at`  bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间' ,
`updated_at`  bigint(20) NOT NULL DEFAULT 0 COMMENT '修改时间' ,
`created_person_id`  int(11) NOT NULL DEFAULT 0 COMMENT '创建人ID' ,
`updated_person_id`  int(11) NOT NULL DEFAULT 0 COMMENT '修改人ID' ,
`is_deleted`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否软删除 0 未删除，1已删除' ,
PRIMARY KEY (`weshop_collection_journal_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺收藏流水表(店铺维度)';


ALTER TABLE `baseinfo_company_partner` ADD COLUMN `is_default` tinyint(1) NOT NULL DEFAULT 0 COMMENT '1-是默认，0-不是默认' AFTER `is_can_edit`

CREATE TABLE `baseinfo_company_print_config` (
  `config_id` bigint(14) NOT NULL COMMENT '打印设置id, redis序列+公司id后4位',
  `comp_id` int(11) unsigned NOT NULL COMMENT '企业ID',
  `store_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '门店ID',
  `bill_type` int(11) NOT NULL COMMENT '单据类型, 0:订单 1:出入库单',
  `bill_type_code` int(11) NOT NULL COMMENT '单据详细类型,订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,500-零售单,501-零售预订单，502-零售补录单. 出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单',
  `bill_type_name` varchar(20) NOT NULL COMMENT '单据类型名称',
  `print_bill` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否打印账单   0：否  1：是',
  `print_num` int(11) NOT NULL DEFAULT '1' COMMENT '打印份数',
  `print_size` varchar(20) NOT NULL DEFAULT '' COMMENT '打印尺寸',
  `bill_name` varchar(100) NOT NULL DEFAULT '' COMMENT '单据名称',
  `print_warn` varchar(255) NOT NULL DEFAULT '提醒：钱款、件数请当面点清，离店概不负责，货物如有缺漏、损坏、到货请即通知，次品必需七天调换，不可退款，人为因素或逾期恕不退换，多谢合作！' COMMENT '打印提醒',
  `created_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_at` bigint(14) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `version` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`config_id`),
  UNIQUE KEY `comp_id_bill_type_index` (`comp_id`,`bill_type`,`bill_type_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业打印配置表';


alter table baseinfo_company_store add COLUMN `weshop_province` varchar(30) not null default '' comment '微商铺-省' after `weshop_contact_type`;
alter table baseinfo_company_store add COLUMN `weshop_city` varchar(60) not null default '' comment '微商铺-市' after `weshop_province`;
alter table baseinfo_company_store add COLUMN `weshop_zone` varchar(60) not null default '' comment '微商铺-区' after `weshop_city`;
alter table baseinfo_company_store add COLUMN `weshop_address` varchar(300) not null default '' comment '微商铺-地址' after `weshop_zone`;

alter table baseinfo_company_store modify COLUMN `weshop_status` int(11) not null default 2 comment '微商铺状态 0草稿，1发布, 2下线';


-- 在sysdb数据库中创建下表
CREATE TABLE `sys_company_type_print_bill` (
  `pb_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '打印单据id',
	`bill_type` int(11) not null comment '单据类型, 0:订单 1:出入库单',
	`bill_type_code` int(11) not null comment '单据详细类型,订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,500-零售单,501-零售预订单，502-零售补录单. 出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单',

  `bill_type_name` varchar(10) NOT NULL DEFAULT '' COMMENT '单据类型名称',
  `ct_id` int(11) NOT NULL COMMENT '业务类型id',
  `created_at` bigint(14) NOT NULL COMMENT '创建时间',
  `updated_at` bigint(14) NOT NULL COMMENT '更新时间',
  `created_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `updated_person_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除，1已删除',
  PRIMARY KEY (`pb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务类型-打印单据表';

insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,3,'销售开单',1,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,1,'采购进货单',1,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,2,'采购退货单',1,0,0,0,0,0);

insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,3,'销售开单',2,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,1,'采购进货单',2,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,2,'采购退货单',2,0,0,0,0,0);

insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,500,'零售开单',3,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,1,'采购进货单',3,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,2,'采购退货单',3,0,0,0,0,0);
insert into `sys_company_type_print_bill` (bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,created_person_id,updated_person_id,is_deleted) values (0,6,'零售退货单',3,0,0,0,0,0);

