#Fenwick Class, but in function form
def getSum(BITTree,i): 
	s = 0
	#i = i+1
	while i > 0: 
		s += BITTree[i] 
		i -= i & (-i) 
	return s 
def updateBit(BITTree , n , i ,v): 
	#i += 1
	while i <= n: 
		BITTree[i] += v 
		i += i & (-i) 
def construct(arr, n): 
	BITTree = [0]*(n+1) 
	for i in range(n): 
		updateBit(BITTree, n, i+1, arr[i]) 
	return BITTree 
  
#---------------------------------------------------------------------------	

repetitions = int(input())
for _ in range(repetitions):
	numCassettes, numOperations = [int(x) for x in input().split()]
	positionArray = [int(x)+1 for x in reversed(range(numCassettes))]
	boolArray = [1] * numCassettes
	boolArray.extend([0] * (numOperations+1))
	myFW = construct(boolArray,len(boolArray))
	operationList = [int(x) for x in input().split()]
	operationsToComplete = len(operationList)
	endPos = numCassettes+1
	for operation in operationList:
		operationsToComplete -= 1
		startPos = positionArray[operation-1]
		endPos = endPos+1
		updateBit(myFW, len(boolArray), startPos, -1)
		updateBit(myFW, len(boolArray), endPos , 1)
		numCassettesSkipped = getSum(myFW, endPos-1) - getSum(myFW, startPos)
		positionArray[operation-1] = endPos
		if operationsToComplete == 0:
			print(numCassettesSkipped)
		else:
			print(numCassettesSkipped, end = " ")