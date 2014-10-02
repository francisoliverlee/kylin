select sum(test_kylin_fact.price) as GMV 
 , count(*) as TRANS_CNT from test_kylin_fact 
 inner JOIN test_cal_dt 
 ON test_kylin_fact.cal_dt = test_cal_dt.cal_dt 
 where test_kylin_fact.lstg_format_name='FP-GTC' 
 and test_cal_dt.week_beg_dt between DATE '2013-05-01' and DATE '2013-08-01' 
