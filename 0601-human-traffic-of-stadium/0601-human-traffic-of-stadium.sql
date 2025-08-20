select Distinct id , visit_date , people 
from Stadium s 
where s.people>=100 
and ( ( (select Ifnull(people,0) from stadium s2 where s2.id = s.id+1)>=100
and (select Ifnull(people,0) from stadium s3 where s3.id = s.id+2)>=100) or ((select Ifnull(people,0) from stadium s2 where s2.id = s.id-1)>=100
and (select Ifnull(people,0) from stadium s3 where s3.id = s.id-2)>=100) or ( (select IfNull(people,0) from stadium s3 where s3.id = s.id-1)>=100 and (select Ifnull(people,0) from stadium s4 where s4.id = s.id+1)>=100 ) ) ;
