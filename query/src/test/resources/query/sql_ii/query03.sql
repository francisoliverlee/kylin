select sum(price) as price_sum, min(price) as price_min , max(price) as price_max , LSTG_FORMAT_NAME from test_kylin_fact group by LSTG_FORMAT_NAME