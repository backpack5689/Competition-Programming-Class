for _ in range(int(input())):
	inputters = [int(x) for x in input().split()]
	rows = inputters[0]
	columns = inputters[1]
	#Also if columns =0, then it's just unconnected vertexes, and automatically true
	if columns == 0:
		print("Yes")
		continue
	myMatrix = [[int(j) for j in input().split()] for i in range(rows)]
	simpleGraph = True
	myEdgeMatrix = []
	
	#Checks to see if every edge only has 2 vertexes
	for __ in range(columns):
		if simpleGraph:
			for c in range(columns):
				numberofVertexes = 0
				for v in range(rows):
					numberofVertexes += myMatrix[v][c]
					if numberofVertexes > 2:
						simpleGraph = False
						break
				#You also have to check if an edge start and doesn't go anywhere
				if numberofVertexes == 1:
					simpleGraph = False
				if not simpleGraph:
					break
		if not simpleGraph:
			break
	#Checks to see if any edge is the same edge as another edge
	#First builds a 2d array by edges to vertexes
	if simpleGraph:
		for c in range(columns):
			thisc = []
			for v in range(rows):
				if myMatrix[v][c] == 1:
					thisc.append(v)
			myEdgeMatrix.append(thisc)
		#Now takes that 2d array and compares each inner array to each other
		curr = 0
		for column1 in myEdgeMatrix:
			if simpleGraph:
				curr+=1 
				for column2 in myEdgeMatrix[curr:]:
					if column1 == column2:
						simpleGraph = False
						break
	if simpleGraph:
		print("Yes")
	else:
		print("No")