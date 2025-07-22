with cte as(
    select p.product_id ,  sum((p.price * u.units )) as totPrice ,sum(u.units) as tot
    from Prices as p 
    left join UnitsSold as u
    On p.product_id = u.product_id and u.purchase_date >=p.start_date and u.purchase_date <= p.end_date 
    group by p.product_id 
)

select product_id  , IfNull(Round((totPrice / tot) ,2), 0) as average_price 
from cte
