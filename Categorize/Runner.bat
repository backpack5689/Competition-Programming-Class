ECHO OFF
cls
ECHO Categorize 2 Running
ECHO.
python ReverseRot.py <TestData/rot.in >TestData/rot.try
python ReverseRot.py <TestData/rotedge.in >TestData/rotedge.try
ECHO.
ECHO Categorize 3 Running
ECHO.
python FibonacciWords.py <TestData/fibonacci-sample.in >TestData/fibonacci-sample.try
ECHO Running Completed
CD TestData
FC rot.try rot.ans
FC rotedge.try rotedge.ans
FC fibonacci-sample.try fibonacci-sample.ans
pause