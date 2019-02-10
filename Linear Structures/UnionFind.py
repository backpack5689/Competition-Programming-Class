import sys
import time

class UnionFind:
	arraySize = 0
	array = []
	
	#Constructor
	def __init__(self, size):
		self.arraySize = size
		self.array = [int(fido) for fido in range(size)]
	
	#Finds if two things are connected
	def isConnected(self,a,b):
		if (self.find(a)==self.find(b)):
			return True
		else:
			return False
	
	#Finds the root
	def find(self,a):
		while not(a == self.array[a]):
			a = self.array[a]
		return a
	
	#Joins 2 things together by using the same root
	def join(self,a,b):
		p = self.find(a)
		q = self.find(b)
		if not(p == q):
			self.array[p] = q
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
		else:
			#print("no")
	else:
		print("DONT F WITH ME, I HAVE THE POWER OF GOD AND ANIME ON MY SIDE!")
end = time.time()
print(end - start)