from sys import stdin
from sys import stdout
import time

class UnionFind:
	arraySize = 0
	array = []
	rankArray = []
	
	#Constructor
	def __init__(self, size):
		self.array = [int(fido) for fido in range(size)]
		self.rankArray = [1]*size
		
	
	#Finds if two things are connected
	def isConnected(self,a,b):
		if (self.find(a)==self.find(b)):
			return True
		else:
			return False
	
	#Finds the root (flattens)
	def find(self,a):
		while not(a == self.array[a]):
			self.array[a] = self.array[self.array[a]]
			a = self.array[a]
		return a
	
	#Joins 2 things together by using the same root
	def join(self,a,b):
		if self.array[a] > self.array[b]:
			self.array[b] = a
		else:
			self.array[a] = b

#Not in the class anymore, main program time!!! 
start = time.time()
inputters = input()
size,numOps = [int(x) for x in inputters.split()]
MyUnion = UnionFind(size)
for yeeters in range(numOps):
	inputters = stdin.readline()
	symbol,n1,n2 = [x for x in inputters.split()]
	n1 = int(n1)
	#print(n1)
	n2 = int(n2)
	#print(n2)
	if symbol == "=":
		MyUnion.join(n1,n2)
	elif symbol == "?":
		if MyUnion.find(n1) == MyUnion.find(n2):
			#stdout.write("yes \n")
			pass
		else:
			#stdout.write("no \n")
			pass
	else:
		print("DONT F WITH ME, I HAVE THE POWER OF GOD AND ANIME ON MY SIDE!")
end = time.time()
print(end - start)