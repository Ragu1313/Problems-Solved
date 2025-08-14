with cte as
(
select u.name name ,Sum(t.amount) balance
from users u 
join transactions t
ON t.account = u.account 
group by t.account 
)

select name , balance 
from cte 
where balance>10000