ECHO Off
cls
ECHO Running
javac CanonicalCoins.java
java CanonicalCoins <TestData/CanonicalCoins1.in >TestData/CanonicalCoins1.try
java CanonicalCoins <TestData/CanonicalCoins2.in >TestData/CanonicalCoins2.try
java CanonicalCoins <TestData/CanonicalCoins3.in >TestData/CanonicalCoins3.try
python ExactChange.py <TestData/C.in > Testdata/C.try
ECHO Comparing
CD TestData
FC CanonicalCoins1.try CanonicalCoins1.ans
FC CanonicalCoins2.try CanonicalCoins2.ans
FC CanonicalCoins3.try CanonicalCoins3.ans
FC C.try C.ans
pause