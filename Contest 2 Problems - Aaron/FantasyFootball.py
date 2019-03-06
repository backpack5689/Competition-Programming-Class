repetitions = int(input())
for _ in range(repetitions):
	arrayInputs = [int(x) for x in input().split()]
	teamArray = arrayInputs[1:arrayInputs[0]+1]
	teamArray.sort()
	tieNum = 1
	teamsMovingUp = 0
	for teamPos in range(arrayInputs[0]-1):
		if(teamArray[teamPos] == teamArray[teamPos+1]):
			tieNum = tieNum + 1
		elif teamArray[teamPos] + 10 >= teamArray[teamPos + 1]:
			teamsMovingUp = teamsMovingUp + tieNum
			tieNum = 1
		else:
			tieNum = 1
	print(teamsMovingUp)