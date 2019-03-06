#Fenwick Class
def getSum(BITTree,i): 
	s = 0
	i = i+1
	while i > 0: 
		s += BITTree[i] 
		i -= i & (-i) 
	return s 
def updateBit(BITTree , n , i ,v): 
	i += 1
	while i <= n: 
		BITTree[i] += v 
		i += i & (-i) 
def construct(arr, n): 
	BITTree = [0]*(n+1) 
	for i in range(n): 
		updateBit(BITTree, n, i, arr[i]) 
	return BITTree 
		
		
repetitions = int(input())
for _ in range(repetitions):
	numCassettes, numOperations = [int(x) for x in input().split()]
	positionArray = [int(x) for x in reversed(range(numCassettes))]
	#If numCassettes was at 5, position array would look like {4,3,2,1,0}
	boolArray = [1] * numCassettes
	boolArray.extend([0] * numOperations)
	#Operations to follow
	myFW = construct(boolArray,len(boolArray))
	
	operationList = [int(x) for x in input().split()]
	operationsToComplete = len(operationList)-1
	for operation in operationList:
		operationsToComplete -= 1
		startPos = positionArray[operation-1]
		endPos = max(positionArray)+1
		numCassettesSkipped = getSum(myFW, endPos) - getSum(myFW, startPos)
		boolArray[startPos] = 0
		boolArray[endPos] = 1
		updateBit(myFW, len(boolArray), endPos, 1)
		updateBit(myFW, len(boolArray), startPos, 0)
		positionArray[operation-1] = endPos
		if operationsToComplete < 0:
			print(numCassettes)
		else:
			print(numCassettesSkipped, end = " ")