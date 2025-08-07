select Distinct(num) as ConsecutiveNums from
logs s where num=(select Ifnull(num,-1) from logs s1 where s1.id = s.id+1) and
num=(select IfNull(num,-1) from logs s2 where s2.id = s.id+2);
