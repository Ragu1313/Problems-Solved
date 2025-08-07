select s.score , 
(select Count(Distinct(s2.score)) from scores s2 
where s.score<s2.score 
)+1
as 'rank'
from scores s
order by s.score desc;