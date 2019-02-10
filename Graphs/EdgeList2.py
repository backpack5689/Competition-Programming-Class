#YEET!
while True:	
	graph = []
	n = int(input())
	lineNum = 0
	if n == -1:
		break
	for line in range(n):
		graph.append([tuple([int(lineNum),int(fido)]) for fido,value in enumerate(input().split()) if int(value) == 1])
		lineNum += 1
	graph = sum(graph,[])
	#print(graph)
	#print("*************************************************")
	weakVertex = False
	printed = False
	lastStart = 0
	strongList = [False] * n
	for i,vertexCompareA in enumerate(graph): 
		if not lastStart == vertexCompareA[0]:
			printed = False
			weakVertex = False
			lastStart = vertexCompareA[0]
			#If we have moved on to a new starting vertex
			
		for vertexCompareB in graph[i+1:]:
			if lastStart == 6:
				#print(vertexCompareA, vertexCompareB)
				pass
			#The above part in the in part of the for loop is starting at i+1 of currVertex
			if(vertexCompareA[0] == vertexCompareB[0]):
				if (vertexCompareA[1], vertexCompareB[1]) in graph:
					strongList[vertexCompareA[0]] = True
					strongList[vertexCompareA[1]] = True
					strongList[vertexCompareB[1]] = True

					#print("mlem caused by " + str(vertexCompareA) + " " + str(vertexCompareB))
					#print(vertexCompareA,vertexCompareB)
					break
	print(*(yeet for yeet, yote in enumerate(strongList) if not yote), sep = " ")


	
