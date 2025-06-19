with cte as(
    select student_id , subject_name ,count(student_id) as cnt
    from Examinations 
    group by student_id,subject_name 
)
select s.student_id,s.student_name , su.subject_name , Coalesce (cnt,0) as attended_exams
from Students s cross join subjects su
left join cte c ON s.student_id = c.student_id AND su.subject_name = c.subject_name
order by student_id,subject_name

