ALTER TABLE `comp_central`.`order_company_journal` ADD COLUMN `version` int NOT NULL DEFAULT 0 AFTER `is_cancel`;
ALTER TABLE `comp_central`.`baseinfo_company_extend_service_journal` CHANGE COLUMN `source_type` `source_type` tinyint(4) UNSIGNED NOT NULL COMMENT '来源  0、充值;1、退款';
ALTER TABLE `comp_central`.`baseinfo_company` ADD COLUMN `experience_date` bigint(20) NOT NULL DEFAULT 0 COMMENT '体验时长' AFTER `expire_status`;
ALTER TABLE `comp_central`.`order_company_journal` ADD COLUMN `service_start_time` bigint(20) NOT NULL DEFAULT 0 COMMENT '服务开始时间' AFTER `version`;



