#2018-11-27 打印提醒去掉 "提醒："   sunjd  所有环境已更改
UPDATE baseinfo_company_print_config
SET print_warn = '钱款、件数请当面点清，离店概不负责，货物如有缺漏、损坏、到货请即通知，次品必需七天调换，不可退款，人为因素或逾期恕不退换，多谢合作！'
WHERE
	print_warn = '提醒：钱款、件数请当面点清，离店概不负责，货物如有缺漏、损坏、到货请即通知，次品必需七天调换，不可退款，人为因素或逾期恕不退换，多谢合作！';