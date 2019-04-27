Echo off
cls
Echo Beginning Running
Echo.
Echo Running 1/6
python Longevity.py <in1.txt >try1.txt
Echo Running 2/6
python Partition.py <in2.txt >try2.txt
Echo Running 3/6
python Fenders.py <in3.txt >try3.txt
Echo Running 4/6
python Sum.py <in4.txt >try4.txt
Echo Running 5/6
python Painter.py <in5.txt >try5.txt
Echo Running 6/6
python Farmers.py <in6.txt >try6.txt
Echo Running Completed
Echo.
CD TestData
Echo Beginning Comparisons
Echo Longevity
FC try1.txt out1.txt
Echo.
Echo Partition
FC try2.txt out2.txt
Echo.
Echo Fenders
FC try3.txt out3.txt
Echo.
Echo Sum
FC try4.txt out4.txt
Echo.
Echo Painter
FC try5.txt out5.txt
Echo.
Echo Farmers
FC try6.txt out6.txt
Echo.
Echo Comparisions Complete
pause