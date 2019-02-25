ECHO off
cls
javac FruitBasket2.java
java FruitBasket2 <sample.in >test.ans
FC test.ans sample.ans
pause