ECHO off
cls
python FlexableSpaces.py <A.in >At.ans
python FlexableSpaces.py <B.in >Bt.ans
FC At.ans A.ans 
FC Bt.ans B.ans
pause