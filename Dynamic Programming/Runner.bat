ECHO Off
cls
ECHO Running
python StringCorrection.py <TestData/StringCorrection.in >TestData/StringCorrection.try
python LongestCommonSubsequence.py <TestData/LCS.in > TestData/LCS.try
ECHO Comparing
CD TestData
FC StringCorrection.try StringCorrection.out
FC LCS.try LCS.out
pause