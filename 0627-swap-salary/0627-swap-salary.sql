update Salary  
set sex = Case
    when sex = 'f' then 'm'
    when sex = 'm' then 'f'
    end

