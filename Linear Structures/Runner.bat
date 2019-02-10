ECHO OFF
cls
python UnionFindTimeTester.py >timeTest.in
python UnionFind.py <timeTest.in
pause
