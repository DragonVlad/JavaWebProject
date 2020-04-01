#insert into scheduledb (id, routeName, placeOut, timeOut, placeIn, timeIn, inPath, day, date) values (12, "автовокзал Центральный - автовокзал Брест", "автовокзал Центральный", "20:30", "Брест, ТЦ 'Корона'", "00:44", "4ч 14мин", "ежедневно, кроме пт", "");
select * from scheduledb;
#update scheduledb set day = "ср, пт" where id = 2;
#delete from scheduledb where id = 13;