# Write your MySQL query statement below
# key word: distinct 'SALARIES'
select d.Name Department, e1.Name Employee, e1.Salary Salary
from Employee e1
inner join Department d
on e1.DepartmentId = d.Id
where 3 > (select count(distinct(e2.Salary))
            from Employee e2
            where e2.Salary>e1.Salary
            and e1.DepartmentId = e2.DepartmentId
            );