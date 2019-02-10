ECHO OFF
cls
python UnionFind.py <unionfind1.in >unionfind1test.ans
python UnionFind.py <unionfind2.in >unionfind2test.ans
FC unionfind1test.ans unionfind1.ans
FC unionfind2test.ans unionfind2.ans
pause
