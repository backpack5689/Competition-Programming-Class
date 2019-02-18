import random
testCases = 180

for test in range(testCases):
	f = open(str(test)+".txt", "w"))
	f.write(test)
	f.close()
