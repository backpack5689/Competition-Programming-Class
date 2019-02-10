import random
from sys import argv

#This program is to generate a max edge case to asses time (No program has been accepted yet, and therefore has no actual answer key)
numArraySize = 1000000
numOps = 1000000
print(numArraySize, end = " ")
print(numOps)
posOps = ["?", "="]
for _ in range(numOps):
	print(random.choice(posOps), end =" ")
	print(random.randint(0,numArraySize-1), end=" ")
	print(random.randint(0,numArraySize-1))