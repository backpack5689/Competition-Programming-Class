Echo off
cls
Echo Running
Echo.
python EditChanges.py <TestData/StringCorrection.in >TestData/StringCorrection.try
Echo 1/4 Completed
Echo.
REM python x.py <TestData/x.in >Testdata/x.try
Echo 2/4 Completed
Echo.
REM z.py <TestData/z.in >TestData/z.try
Echo 3/4 Completed
Echo.
REM M.py <TestData/M.in >TestData/M.try
Echo 4/4 Completed
Echo.

Echo Comparing
CD TestData
FC StringCorrection.try StringCorrection.out
pause