SELECT "GEOX_TRANS_MTRC_SD"."CAL_DT" AS "none_CAL_DT_ok" FROM "DEFAULT"."GEOX_TRANS_MTRC_SD" "GEOX_TRANS_MTRC_SD"   LEFT JOIN "DEFAULT"."GEOX_BYR_CNTRY_LVL_LKP" "GEOX_BYR_CNTRY_LVL_LKP" ON ("GEOX_TRANS_MTRC_SD"."BYR_CNTRY_ID" = "GEOX_BYR_CNTRY_LVL_LKP"."BUYER_CNTRY_ID")   INNER JOIN (   SELECT COUNT(1) AS "XTableau_join_flag",     MAX("GEOX_TRANS_MTRC_SD"."CAL_DT") AS "X__alias__A",     "GEOX_TRANS_MTRC_SD"."CAL_DT" AS "none_CAL_DT_ok"   FROM "DEFAULT"."GEOX_TRANS_MTRC_SD" "GEOX_TRANS_MTRC_SD"     LEFT JOIN "DEFAULT"."GEOX_BYR_CNTRY_LVL_LKP" "GEOX_BYR_CNTRY_LVL_LKP" ON ("GEOX_TRANS_MTRC_SD"."BYR_CNTRY_ID" = "GEOX_BYR_CNTRY_LVL_LKP"."BUYER_CNTRY_ID")   GROUP BY "GEOX_TRANS_MTRC_SD"."CAL_DT"   ORDER BY 2 DESC   LIMIT 7  ) "t0" ON ("GEOX_TRANS_MTRC_SD"."CAL_DT" = "t0"."none_CAL_DT_ok") GROUP BY "GEOX_TRANS_MTRC_SD"."CAL_DT"