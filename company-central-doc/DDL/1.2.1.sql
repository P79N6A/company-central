
#企业表添加字段是否是正式账号还是测试账号
alter table baseinfo_company add COLUMN online_or_test TINYINT(1) NOT NULL DEFAULT 1 COMMENT '0：测试账号 1：正式账号';

#标签打印 增加字段  陈颖 2018-11-15  dev sit已更新
ALTER TABLE `comp_central`.`baseinfo_company` ADD COLUMN `print_mode` int(11) NOT NULL DEFAULT 0 COMMENT '打印模式0-蓝牙 1-服务' AFTER `online_or_test`;

#首页-打印设置-标签 陈颖 218-11-19 dev sit已更新
ALTER TABLE `baseinfo_company_print_config`
 ADD COLUMN `bar_code_template_type` int(11) NOT NULL DEFAULT 0 COMMENT ' 模板类型 ：0-简易模板' AFTER `print_size`,
 ADD COLUMN `is_first_print` tinyint(1) NOT NULL DEFAULT 0 COMMENT ' 是否优先打印单品条码:0- 不优先1-优先' AFTER `bar_code_template_type`;

#首页-打印设置-标签 陈颖 218-11-19 dev sit已更新
ALTER TABLE `comp_central`.`baseinfo_company_print_config` CHANGE COLUMN `bill_type` `bill_type` int(11) NOT NULL COMMENT '单据类型, 0:订单 1:出入库单 2:其他',
CHANGE COLUMN `bill_type_code` `bill_type_code` int(11) NOT NULL COMMENT '单据详细类型,订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,500-零售单,501-零售预订单，502-零售补录单. 出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单 1-对账单2-商品标签';


# 陈颖 218-11-19 dev sit 已更新
INSERT INTO sys_company_type_print_bill (pb_id, bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,
created_person_id,updated_person_id,is_deleted)
 VALUES (24, 2,2,'标签',1,0,0,0,0,0)
# 陈颖 218-11-19 dev sit 已更新
INSERT INTO sys_company_type_print_bill (pb_id, bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,
created_person_id,updated_person_id,is_deleted)
 VALUES (25, 2,2,'标签',2,0,0,0,0,0)
# 陈颖 218-11-19 dev sit 已更新
INSERT INTO sys_company_type_print_bill (pb_id, bill_type,bill_type_code,bill_type_name,ct_id,created_at,updated_at,
created_person_id,updated_person_id,is_deleted)
 VALUES (26, 2,2,'标签',3,0,0,0,0,0)
# 陈颖 218-11-19 dev sit 已更新
ALTER TABLE `sysdb`.`sys_company_type_print_bill` CHANGE COLUMN `bill_type` `bill_type` int(11) NOT NULL COMMENT '单据类型, 0:订单 1:出入库单 2:其他';
ALTER TABLE `sysdb`.`sys_company_type_print_bill` CHANGE COLUMN `bill_type_code` `bill_type_code` int(11) NOT NULL COMMENT '单据详细类型,订单:1-采购2-采购退货3-销售4-销售退货,6-零售退货,500-零售单,501-零售预订单，502-零售补录单. 出入库单:1-入库单，2-出库单，101-调拨单,102-盘点单,1-对账单 2-条码';