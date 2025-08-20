
select e.employee_id as  employee_id
from employees e 
where e.employee_id not in (select s.employee_id from Salaries s)
union 
select s.employee_id as employee_id
from Salaries s 
where s.employee_id not in (select e.employee_id from employees e)
order by employee_id 

