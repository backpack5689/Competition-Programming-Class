ECHO off
cls
javac PageLayout.java
java PageLayout <sample.in >test.ans
FC test.ans sample.ans
pause