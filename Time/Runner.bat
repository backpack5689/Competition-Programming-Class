@Echo off
color 0a
cls
javac BusySchedule.java 
java BusySchedule <sample.in >test.txt
FC /L test.txt sample.ans
pause