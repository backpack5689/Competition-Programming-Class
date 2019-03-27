ECHO Off
cls
ECHO Running
python StringCorrection.py <TestData/StringCorrection.in >TestData/StringCorrection.try
rem ECHO Comparing
rem CD TestData
rem FC StringCorrection.try StringCorrection.out
pause