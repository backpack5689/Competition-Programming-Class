#YEET!
while True:	
	graph = []
	n = int(input())
	if n == -1:
		break
	for line in range(n):
		graph.append([int(fido) for fido in input().split()])
	weakVertex = True
	for indices,currVertex in enumerate(graph):
		for i,vertexCompareA in enumerate(currVertex):
			for j,vertexCompareB in enumerate(currVertex[i+1:]):
				j+=i+1
				#The above part in the in part of the for loop is starting at i+1 of currVertex
				if((vertexCompareA & vertexCompareB == 1) and graph[i][j]):
					weakVertex = False
					break
			if(not weakVertex):
				break
		if(weakVertex):
			print(str(indices) + " ",end="")
		weakVertex = True
	print()

	
