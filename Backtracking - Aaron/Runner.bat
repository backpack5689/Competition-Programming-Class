ECHO off
cls
python FruitBasket.py <sample.in >test.ans
FC test.ans sample.ans
pause