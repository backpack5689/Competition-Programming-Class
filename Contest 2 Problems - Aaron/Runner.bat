ECHO off
cls
ECHO Running
python AudibleAudio.py <TestFiles\in1.txt >TestFiles\try1.txt
python BrushingBoxes.py <TestFiles\in2.txt >TestFiles\try2.txt
python CassetteCollection.py <TestFiles\in3.txt >TestFiles\try3.txt
python DisplayDensity.py <TestFiles\in4.txt >TestFiles\try4.txt
REM python ExistentEdges.py <TestFiles\in5.txt >TestFiles\try5.txt
python FantasyFootball.py <TestFiles\in6.txt >TestFiles\try6.txt
python GreatestGroup.py <TestFiles\in7.txt >TestFiles\try7.txt
ECHO.
ECHO Begin Comparision
ECHO.
ECHO AudibleAudio
FC TestFiles\try1.txt TestFiles\out1.txt
ECHO Brushing Boxes
FC TestFiles\try2.txt TestFiles\out2.txt
ECHO Cassette Collection
FC TestFiles\try3.txt TestFiles\out3.txt
ECHO Display Density
FC TestFiles\try4.txt TestFiles\out4.txt
REM ECHO Existent Edges
REM FC TestFiles\try5.txt TestFiles\out5.txt
ECHO Fantasy Football
FC TestFiles\try6.txt TestFiles\out6.txt
ECHO Greatest Group
FC TestFiles\try7.txt TestFiles\out7.txt
Pause