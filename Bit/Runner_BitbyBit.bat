@Echo off
color 0a
cls
python genbit.py >test.in
javac {Your filename here}.java 
java {Your filename here} <test.in >myans.out
python bit_by_bit.py <test.in >corrans.out
FC /L myans.out corrans.out
pause