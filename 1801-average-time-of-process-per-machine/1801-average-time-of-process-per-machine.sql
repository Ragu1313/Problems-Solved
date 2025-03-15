with cte as (
    select a1.machine_id,(a2.timestamp-a1.timestamp) as dif
    from Activity as a1 join Activity as a2
    where a1.machine_id=a2.machine_id 
    and a1.process_id = a2.process_id 
    and a1.activity_type = 'start' and a2.activity_type = 'end'
)
select a.machine_id , round(avg(e.dif),3) as processing_time 
from Activity as a
join cte e
ON a.machine_id = e.machine_id
group by a.machine_id;

