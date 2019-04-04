memo = [[]]
costs = [0] #costs will go skip, delete, insert, and replace

#Function will populate the memo array
def minEditFinder(original, goal):
	global memo, costs
	for i in reversed(range(len(goal+1))):
		for j in reversed(range(len(original+1))):
			
				
#Function will return the edits required to complete
#the string mutation in the smallest amount of steps
def workBack():
	global memo, costs
	
	
def main():
	global memo, costs
	repetitions = int(input())
	costs.extend([int(x) for x in input().split()])
	for _ in range(repetitions):
		original = " "+input()
		goal = " "+input()
		memo = [[999999 for x in range(len(original+1))]for y in range(len(goal+1))]
		memo[0[0]] = 0
		minEditFinder(original, goal)
main()		