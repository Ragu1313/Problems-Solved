with cte as(
    select d.Id id ,Max(e.salary) Salary, d.name name
    from Employee e join
    department d On d.id = e.departmentId
    group by d.Id
)
select c.name as Department , e.name as Employee , c.Salary 
from employee e
join cte c 
ON c.id = e.departmentId and c.salary = e.salary;
