REM   Script: Activity7
REM   Aggregate functions 

select SUM(total_sales) AS "Total sum" from co.product_orders;

select AVG(total_sales) AS "Average" from co.product_orders;

select MAX(total_sales) AS "Maximum" from co.product_orders;

select MIN(total_sales) AS "Minumum" from co.product_orders;

select COUNT(distinct total_sales) AS "Total count" from co.product_orders;

