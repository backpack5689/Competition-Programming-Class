#YEET!
while True:	
	graph = []
	n = int(input())
	if n == -1:
		break
	for line in range(n):
		graph.append([fido for fido,value in enumerate(input().split()) if int(value) == 1])
	weakVertex = True
	for indices,currVertex in enumerate(graph):
		for i,vertexCompareA in enumerate(currVertex):
			for vertexCompareB in currVertex[i+1:]:
				#The above part in the in part of the for loop is starting at i+1 of currVertex
				if vertexCompareB in graph[vertexCompareA]:
					weakVertex = False
					break
			if(not weakVertex):
				break
		if(weakVertex):
			print(str(indices) + " ",end="")
		weakVertex = True
	print()

	
