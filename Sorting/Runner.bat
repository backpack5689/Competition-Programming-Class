@Echo off
color 0a
cls
javac Sort_of_Sorting.java
java Sort_of_Sorting <sample.in >test.txt
FC /L test.txt sample.ans
pause