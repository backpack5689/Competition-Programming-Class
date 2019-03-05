ECHO off
cls
REM Compiler/Runner
REM python AudibleAudio.py <TestFiles/in1.txt >TestFiles/try1.txt
python BrushingBoxes.py <TestFiles/in2.txt >TestFiles/try2.txt
REM python CassetteCollection.py <TestFiles/in3.txt >TestFiles/try3.txt
REM python DisplayDensity.py <TestFiles/in4.txt >TestFiles/try4.txt
REM python ExistentEdges.py <TestFiles/in5.txt >TestFiles/try5.txt
REM python FantasyFootball.py <TestFiles/in6.txt >TestFiles/try6.txt
REM python GreatestGroup.py <TestFiles/in7.txt >TestFiles/try7.txt

REM Comparator
REM ECHO AudibleAudio
REM FC TestFiles/try1.txt TestFiles/out1.txt
ECHO Brushing Boxes
FC TestFiles/try2.txt TestFiles/out2.txt
REM ECHO Cassette Collection
REM FC TestFiles/try3.txt TestFiles/out3.txt
REM ECHO Display Density
REM FC TestFiles/try4.txt TestFiles/out4.txt
REM ECHO Existent Edges
REM FC TestFiles/try5.txt TestFiles/out5.txt
REM ECHO Fantasy Football
REM FC TestFiles/try6.txt TestFiles/out6.txt
REM ECHO Greatest Group
REM FC TestFiles/try7.txt TestFiles/out7.txt
Pause