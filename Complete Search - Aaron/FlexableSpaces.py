#Important Variables
givenPartitions = []
availableAreas = [False] * 101

#Taking Input
width, numPartitions = (int(i) for i in input().split())
givenPartitions = [int(i) for i in input().split()]
givenPartitions.append(0)
givenPartitions.append(width)

#Goes and finds the areas in the availableAreas and sets it to True
for index, partition1 in enumerate(givenPartitions):
	for partition2 in givenPartitions[index:len(givenPartitions)]:
		if not partition1 == partition2: 
			availableAreas[abs(partition1 - partition2)] = True

#Prints
for index in range(width+1):
	if(availableAreas[index]):
		print(index, end = " ")
print()