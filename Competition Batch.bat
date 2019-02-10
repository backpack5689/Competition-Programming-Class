@Echo off
color 0a
cls
javac Filename.java 
java Filename <sample.in >test.txt
FC /A test.txt sample.ans
pause