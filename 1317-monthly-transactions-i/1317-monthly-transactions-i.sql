# Write your MySQL query statement below
SELECT date_format(trans_date,'%Y-%m') month,
country,
COUNT(id) trans_count,
SUM(case when state='approved' then 1 else 0 end) approved_count,
SUM(amount) trans_total_amount,
SUM(case when state='approved' then amount else 0 end) approved_total_amount
from Transactions
group by date_format(trans_date,'%Y-%m'),
country
