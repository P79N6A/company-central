#baseinfo_company 增加公司头像  2018-10-12 张梦丹  所有数据库已更新
ALTER TABLE `baseinfo_company`
ADD COLUMN `company_head`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公司头像' AFTER `attributes`;

#baseinfo_company_store 增加未禁用  银行账户信息  支付宝账号  支付宝账号二维码  支付宝账号二维码内容  微信账号 微信账号二维码 微信账号二维码内容 微信收款码 微信收款码内容  2018-10-12 张梦丹  所有数据库已更新
ALTER TABLE `baseinfo_company_store`
ADD COLUMN `forbidden`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否禁用  0:未禁用  1:禁用' AFTER `is_public`,
ADD COLUMN `alipay_account_name`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '支付宝账号' AFTER `attributes`,
ADD COLUMN `alipay_receipt_qrcode`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '支付宝收款码' AFTER `alipay_account_name`,
ADD COLUMN `alipay_receipt_qrcode_content`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '支付宝收款码内容' AFTER `alipay_receipt_qrcode`,
ADD COLUMN `alipay_account_qrcode`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '支付宝账号二维码' AFTER `alipay_receipt_qrcode_content`,
ADD COLUMN `alipay_account_qrcode_content`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '支付宝账号二维码内容' AFTER `alipay_account_qrcode`,
ADD COLUMN `wechat_account_name`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信账号' AFTER `alipay_account_qrcode_content`，
ADD COLUMN `wechat_account_qrcode`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信账号二维码' AFTER `wechat_account_name`，
ADD COLUMN `wechat_account_qrcode_content`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信账号二维码内容' AFTER `wechat_account_qrcode`，
ADD COLUMN `wechat_receipt_qrcode`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信收款码' AFTER `wechat_account_qrcode_content`，
ADD COLUMN `wechat_receipt_qrcode_content`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信收款码内容' AFTER `wechat_receipt_qrcode`;

#增加门店付费相关字段  sunjd 所有数据库已更新
ALTER TABLE `baseinfo_company_store`
ADD COLUMN `expire_date`  bigint(11) NOT NULL DEFAULT 0 COMMENT '过期时间' AFTER `alipay_receipt_qrcode_content`,
ADD COLUMN `pay_remark`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '付款备注' AFTER `expire_date`,
ADD COLUMN `pay_remark_user_name`  varchar(128) NOT NULL DEFAULT '' AFTER `pay_remark`,
ADD COLUMN `pay_remark_user_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '付款备注者 id' AFTER `pay_remark_user_name`,
ADD COLUMN `pay_remark_time`  bigint(14) NOT NULL DEFAULT 0 COMMENT '付款备注时间' AFTER `pay_remark_user_id`;

ALTER TABLE `baseinfo_company_store`
ADD COLUMN `expire_status`  int(11) NOT NULL DEFAULT 0 COMMENT '0:体验;1:付费' AFTER `pay_remark_time`,
ADD COLUMN `version`  int(11) NOT NULL DEFAULT 0 COMMENT '版本号' AFTER `expire_status`;


#门店/企业 添加索引 sunjd  所有环境已更改
ALTER TABLE `baseinfo_company_store`
ADD INDEX `created_at_idx` (`created_at`) USING BTREE ,
ADD INDEX `expire_date_idx` (`expire_date`) USING BTREE ,
ADD INDEX `expire_status_idx` (`expire_status`) USING BTREE ;

ALTER TABLE `baseinfo_company`
ADD INDEX `status_idx` (`status`) USING BTREE ;

#门店付费订单/流水表增加字段 sunjd  所有环境已更改
ALTER TABLE `order_company_journal`
ADD COLUMN `store_id`  bigint(20) NOT NULL COMMENT '门店id' AFTER `service_start_time`;

ALTER TABLE `baseinfo_company_extend_service_journal`
ADD COLUMN `store_id`  bigint(20) NOT NULL COMMENT '门店id' AFTER `fund_status`;

ALTER TABLE `order_company_journal`
ADD COLUMN `auditor_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '审核员id' AFTER `created_person_id`,
ADD COLUMN `auditor_name`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '审核员名称' AFTER `auditor_id`;

#立即打印标志 孙缙东  所有环境已更改
ALTER TABLE `baseinfo_company_print_config`
ADD COLUMN `immediately_print`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '0:不立即打印   1：立即打印' AFTER `version`;
#企业伙伴表添加微信号字段 张梦丹 所有环境已更改
ALTER TABLE `baseinfo_company_partner_0`
ADD COLUMN  `wechat_account_name` varchar(50) NOT NULL DEFAULT '' COMMENT '微信账号' AFTER `prepaid_deposit`;

#企业伙伴表字段调整 所有环境已修改
alter table `baseinfo_company_partner_0 CHANGE COLUMN `partner_name` `partner_name` varchar(256) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '合伙人企业名称', CHANGE COLUMN `partner_linkman` `partner_linkman` varchar(30) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '联系人  当partner_type = 0(供应商) 时此字段有意义，客户和零售会员与partnerName保持一致', CHANGE COLUMN `wechat_account_name` `wechat_account_name` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '微信账号';

