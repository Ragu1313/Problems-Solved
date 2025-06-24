select t1.id
from Weather t1 
join Weather t2
On datediff(t2.recorddate,t1.recorddate)=-1
and t1.temperature>t2.temperature;
