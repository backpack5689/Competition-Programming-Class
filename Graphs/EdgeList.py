#YEET!
while True:	
	graph = []
	n = int(input())
	lineNum = 0
	if n == -1:
		break
	for line in range(n):
		graph.append([(int(lineNum),int(fido)) for fido,value in enumerate(input().split()) if int(value) == 1])
		lineNum += 1
	print(graph)
	weakVertex = True
	for indices,currVertex in enumerate(graph):
		for i,vertexCompareA in enumerate(currVertex): 
			for j,vertexCompareB in enumerate(currVertex[i+1:]):
				j+=i+1
				#The above part in the in part of the for loop is starting at i+1 of currVertex
				if (vertexCompareA[1], vertexCompareB[1]) in graph[vertexCompareA[1]]:
					weakVertex = False
					break
			if(not weakVertex): 
				break
		if(weakVertex):
			print(str(indices) + " ",end="")
		weakVertex = True
	print()

	
