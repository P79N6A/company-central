#uat删除一批演示账号门店
SELECT * from baseinfo_company where comp_id in (233,234,235);
SELECT * from baseinfo_company_store where comp_id in (233);
update baseinfo_company_store set is_deleted = 1 where comp_id = 233 and store_id in (7710233,7720233,13460233,15610233,2020233);
update baseinfo_company_stock set is_deleted = 1 where comp_id = 233 and store_id in (7710233,7720233,13460233,15610233,2020233);
