ECHO Off
cls
ECHO Running
ECHO .
python StringCorrection.py <TestData\StringCorrection.in >TestData\StringCorrection.try
ECHO Comparison
ECHO .
CD TestData
FC StringCorrection.try StringCorrection.out
pause