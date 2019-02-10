import sys

class UnionFind:
	arraySize = 0
	array = []
	
	#Constructor
	def __init__(self, size):
		self.arraySize = size
		self.array = [int(fido) for fido in range(size)]
	
	#Finds if two things are connected
	def isConnected(a,b):
		if (find(a)==find(b)):
			return True
		else:
			return False
	
	#Finds the root
	def find(a):
		while not(a == array[a]):
			a == array[a]
		return a
	
	#Joins 2 things together by using the same root
	def join(a,b):
		p = find(a)
		q = find(b)
		if not(p == q)
			array[p] = q
		return

#Not in the class anymore, main program time!!! YA YEET!!!
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
	n2 = int(n2)
	if symbol == "=":
		MyUnion.join(n1,n2)
	else if symbol == "?"
		if MyUnion.isConnected(n1,n2):
			print("yes")
		else:
			print("no")
	else:
		print("If she breathes, she's a vodka")
	