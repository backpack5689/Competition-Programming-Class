ECHO OFF
cls
javac DartScore.java
java DartScore <1.in >1t.ans
java DartScore <2.in >2t.ans
java DartScore <3.in >3t.ans
java DartScore <4.in >4t.ans
java DartScore <5.in >5t.ans
FC 1t.ans 1.ans
FC 2t.ans 2.ans
FC 3t.ans 3.ans
FC 4t.ans 4.ans
FC 5t.ans 5.ans
pause

