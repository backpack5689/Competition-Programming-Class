possNums = [[0],[1,2,3,4,5,6,7,8,9,0],[2,3,5,6,8,9,0],[3,6,9],[4,5,6,7,8,9,0],[5,6,8,9,0],[6,9],[7,8,9,0],[8,9,0],[9],[1,2,3,4,5,6,7,8,9,0]]  

def canIEnter(number):
	global possNums
	number = str(number)
	digits = len(number)
	for position in range(digits):
		if position == 0:
			if int(number[position]) in possNums[10]:
				continue
			else:
				return False
		else:
			if int(number[position]) in possNums[int(number[position-1])]:
				continue
			else:
				return False
	return True
def numberFinder(goalNumber):
	if(canIEnter(goalNumber)):
		return goalNumber
	else:
		for i in range(50):
			if(goalNumber+i >= 1 and goalNumber+i <= 200 and canIEnter(goalNumber+i)):
				return goalNumber+i
			if(goalNumber-i >= 1 and goalNumber-i <= 200 and canIEnter(goalNumber-i)):
				return goalNumber-i
	return -1
def main():
	repetitions = int(input())
	for _ in range(repetitions):
		nextNum = int(input())
		returnNum = numberFinder(nextNum)
		print(returnNum)
main()