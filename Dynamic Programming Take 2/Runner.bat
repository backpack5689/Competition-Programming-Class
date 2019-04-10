Echo off
cls
Echo Running
Echo.
python EditChanges.py <TestData/StringCorrection.in >TestData/StringCorrection.try
Echo 1/2 Completed
Echo.
python Commercials.py <TestData/commercials.in >Testdata/commercials.try
Echo 2/2 Completed
REM Echo.
REM REM z.py <TestData/z.in >TestData/z.try
REM Echo 3/4 Completed
REM Echo.
REM REM M.py <TestData/M.in >TestData/M.try
REM Echo 4/4 Completed
REM Echo.

Echo Comparing
CD TestData
FC StringCorrection.try StringCorrection.out
FC commercials.try commercials.ans
pause