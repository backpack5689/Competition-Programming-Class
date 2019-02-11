#Global Variables
allBoards = []

#Function to add a new winning posibility
def newBoard (boardNum):
	if not(boardNum == 0):
		changeEmptyBin = False
		prevBoard = allBoards[boardNum-1].copy()
		prevBoardSize = len(prevBoard)
		for index in range(prevBoardSize):
			if prevBoard[index] > 0:
				prevBoard[index] -= 1
			elif prevBoard[index] == 0:
				prevBoard[index] = index+1
				changeEmptyBin = True
				break
		if not changeEmptyBin:
			prevBoard.append(prevBoardSize+1)
		allBoards.append(prevBoard)		
	else:
		allBoards.append([1])
#Main Program
for boardNum in range(2000):
	newBoard(boardNum)
repetitions = int(input())
for _ in range(repetitions):
	trash, totalStones = (int(x) for x in input().split())
	print(trash, len(allBoards[totalStones-1]), sep = " ")
	for count in range(len(allBoards[totalStones-1])):
		if count%10 == 0 and not(count == 0):
			print()
		print(allBoards[totalStones-1][count], end = " ")
	print()