Echo off
cls
Echo Running
Echo.
python EditChanges.py <TestData/StringCorrection.in >TestData/StringCorrection.try
Echo 1/3 Completed
Echo.
python Commercials.py <TestData/commercials.in >Testdata/commercials.try
Echo 2/3 Completed
Echo.
python LongestIncSub.py <TestData/LIS.in >TestData/LIS.try
Echo 3/3 Completed
REM Echo.
REM REM M.py <TestData/M.in >TestData/M.try
REM Echo 4/4 Completed
Echo.

Echo Comparing
CD TestData
FC StringCorrection.try StringCorrection.out
FC commercials.try commercials.ans
FC LIS.try LIS.ans
pause