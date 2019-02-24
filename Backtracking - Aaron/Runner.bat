ECHO off
cls
REM javac GoodMorning.java
REM java GoodMorning <sample.in >test.ans
REM FC test.ans sample.ans
python GoodMorning2.py <sample.in >test.ans
FC Test.ans sample.ans
pause