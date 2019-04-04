Echo off
cls
Echo Running
Echo.
python EditChanges.py <TestData/EC1.in >TestData/EC1.try
Echo 1/1 Completed
Echo.

Echo Comparing
CD TestData
FC EC1.try EC1.out
pause