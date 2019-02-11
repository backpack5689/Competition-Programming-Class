ECHO OFF
cls
python Mancala.py <sample.in >test.out
FC test.out sample.ans
pause