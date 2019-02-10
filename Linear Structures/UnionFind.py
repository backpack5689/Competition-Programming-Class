import sys
import time

class UnionFind:
	arraySize = 0
	array = []
	rankArray = []
	
	#Constructor
	def __init__(self, size):
		self.arraySize = size
		self.array = [int(fido) for fido in range(size)]
		self.rankArray = [1 for _ in range(size)]
		
	
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
		p = self.find(a)
		q = self.find(b)
		if self.rankArray[p] < self.rankArray[q]:
			self.rankArray[q] += self.rankArray[p]
			self.array[p] = q
		else:
			self.rankArray[p] += self.rankArray[q]
			self.array[q] = p
		return

#Not in the class anymore, main program time!!! 
start = time.time()
inputters = input()
size,numOps = [int(x) for x in inputters.split()]
MyUnion = UnionFind(size)
for yeeters in range(numOps):
	inputters = sys.stdin.readline()
	if inputters == "":
		#This bitch empty, YEET!
		break
	symbol,n1,n2 = [x for x in inputters.split()]
	n1 = int(n1)
	#print(n1)
	n2 = int(n2)
	#print(n2)
	if symbol == "=":
		MyUnion.join(n1,n2)
	elif symbol == "?":
		if MyUnion.isConnected(n1,n2):
			#print("yes")
			pass
		else:
			#print("no")
			pass
	else:
		print("DONT F WITH ME, I HAVE THE POWER OF GOD AND ANIME ON MY SIDE!")
end = time.time()
print(end - start)