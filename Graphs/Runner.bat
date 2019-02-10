@Echo OFF
color 0a
cls

python AdjacencyMatrix.py <sample.in >sample.out
python EdgeList2.py <sample.in >test.ans
FC /L test.ans sample.out
Pause