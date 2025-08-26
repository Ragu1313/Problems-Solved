select tot.id , 
case 
    when Isnull((select p_id from Tree where id = tot.id ))  then 'Root'
    when (select Count(id) from Tree where p_id = tot.id group by p_id)>0 then 'Inner'
    else 'Leaf'
end
as type
from Tree tot 
order  by tot.id;