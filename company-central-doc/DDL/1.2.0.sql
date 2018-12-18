-- 说明：baseinfo_company_partner表增加seller_refund_times字段
-- 时间：2018-11-01
-- 作者：龚文强
-- 所有环境已更新
ALTER TABLE `comp_central`.`baseinfo_company_partner_0` ADD COLUMN `seller_refund_times` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_1` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_2` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_3` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_4` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_5` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_6` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_7` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;
ALTER TABLE `comp_central`.`baseinfo_company_partner_8` ADD COLUMN `seller_refund_times` bigint(20) NOT NULL DEFAULT 0 COMMENT '零售退货次数' AFTER `wechat_account_name`;


-- 说明：历史数据订正，白名单数据
-- 时间：2018-11-02
-- 作者：龚文强
-- 备份
select comp_id, comp_name from baseinfo_company  b where EXISTS (
select DISTINCT comp_id from baseinfo_company_store b1 where  b.comp_id = b1.comp_id and expire_status = 0 and expire_date = 0);

update baseinfo_company b set status = 2 where EXISTS (
select DISTINCT comp_id from baseinfo_company_store b1 where  b.comp_id = b1.comp_id and expire_status = 0 and expire_date = 0);