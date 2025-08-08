SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM employee e
JOIN department d ON e.departmentId = d.id
WHERE e.salary >= Ifnull(
    (SELECT Distinct e1.salary
     FROM employee e1
     WHERE e1.departmentId = e.departmentId
     ORDER BY e1.salary DESC
     LIMIT 1  OFFSET 2   ),
    0 
);
