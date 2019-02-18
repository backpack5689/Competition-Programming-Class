ECHO OFF
cls
javac DartScoreTest.java
java DartScoreTest >1t.ans
echo Completed Java
python CalculatiingDartScores.py >1.ans
echo Completed Python -> File Comparison in progress
FC 1t.ans 1.ans

pause

