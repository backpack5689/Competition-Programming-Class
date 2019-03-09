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
	def find(self, a):
		while not(a == self.array[a]):
			self.array[a] = self.array[self.array[a]]
			a = self.array[a]
		return a
	
	#Joins 2 things together by using the same root
	def union(self,a,b):
		p = self.find(self.array[a])
		q = self.find(self.array[b])
		if p > q:
			self.array[p] = q
		else:
			self.array[q] = p

#--------------------------------//-----------------------------------

repetitions = int(input())
for _ in range(repetitions):
	friendJoins = int(input())
	myUnion = UnionFind(100001)
	size = [1]*100001
	for __ in range(friendJoins):
		inputs = [int(x) for x in input().split()]
		if (inputs[0] == inputs[1] or myUnion.isConnected(inputs[0], inputs[1])):
			continue
		root0, root1 = (myUnion.find(inputs[0]),myUnion.find(inputs[1]))
		if root0 > root1:
			tmp = root1
			root1 = root0
			root0 = tmp
		myUnion.union(inputs[0], inputs[1])
		size[root0] += size[root1]
	print(max(size))