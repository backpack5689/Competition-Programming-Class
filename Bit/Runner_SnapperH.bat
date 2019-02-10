@Echo off
color 0a
cls
javac {Your filename here}.java 
java {Your filename here} <sample2.in >test2.out
FC /L test2.out sample2.out
pause