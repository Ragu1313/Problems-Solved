Select sell_date , 
Count(Distinct(product))  num_sold ,
Group_Concat(Distinct(product) order by product asc Separator ',') products
from Activities
group by sell_date 
order by (sell_date);