ECHO off
cls
python CalculatiingDartScores.py <1.in >1t.ans
python CalculatiingDartScores.py <2.in >2t.ans
python CalculatiingDartScores.py <3.in >3t.ans
FC 1t.ans 1.ans 
FC 2t.ans 2.ans
FC 3t.ans 3.ans
pause