SELECT 
 test_category_groupings.meta_categ_name 
 ,sum(test_kylin_fact.price) as GMV_SUM 
 ,max(test_kylin_fact.price) as GMV_MAX 
 ,min(test_kylin_fact.price) as GMV_MIN 
 ,count(*) as TRANS_CNT 
 FROM test_kylin_fact 
 inner JOIN test_cal_dt 
 ON test_kylin_fact.cal_dt = test_cal_dt.cal_dt 
 inner JOIN test_category_groupings 
 ON test_kylin_fact.leaf_categ_id = test_category_groupings.leaf_categ_id AND test_kylin_fact.lstg_site_id = test_category_groupings.site_id 
 inner JOIN test_sites 
 ON test_kylin_fact.lstg_site_id = test_sites.site_id 
 where test_kylin_fact.seller_id = 10000002 or test_kylin_fact.lstg_format_name = 'FP-non GTC' 
 group by 
 test_category_groupings.meta_categ_name 
