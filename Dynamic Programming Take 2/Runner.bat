Echo off
cls
Echo Running
Echo.
python EditChanges.py <TestData/StringCorrection.in >TestData/StringCorrection.try
Echo 1/1 Completed
Echo.

Echo Comparing
CD TestData
FC StringCorrection.try StringCorrection.out
pause