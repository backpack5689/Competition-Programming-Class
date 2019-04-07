#Program Requirements:
#Return the number of min 
#inserts/deletes/adds to change 
#string A (first input) into 
#string B (second input).
a = ""
b = ""
max = 9999999
memo = [[]]
cost = [0,0,0,0] #Array is Skip, Delete, Insert, Replace
def dist():
	global a,b,max,memo,cost
	for i in range(len(a)):
		for j in range(len(b)):
			if i == 0 and j == 0: #Starting with empty string compared to an empty string
				memo[i][j] = 0
			else:
				if i == 0: #Inserting to an empty string
					memo[i][j] = memo[i][j-1]+cost[2]
				elif j == 0: #Deleting to an empty string
					memo[i][j] = memo[i-1][j]+cost[1]
				else:
					if a[i] == b[j]: #Skiping
						memo[i][j] = memo[i-1][j-1]
					else:
						memo[i][j] = min((memo[i-1][j]+cost[1]),(memo[i][j-1]+cost[2]),(memo[i-1][j-1]+cost[3]))
def backtracker9000():
	global a, b, memo
	i = len(a)-1
	j = len(b)-1
	count = 1
	answer=[]
	while ((not i == 0) or (not j == 0)):
		if i == 0:
			j -= 1
			outputters = "I"+b[j+1]
			answer.extend(outputters)
		elif j == 0:
			i -= 1
			outputters = "D"
			answer.extend(outputters) 
		else:
			mincompare = min(memo[i-1][j-1], memo[i][j-1], memo[i-1][j])
			if mincompare == memo[i-1][j-1] and cost[3] == memo[i][j] - mincompare:
				i -= 1
				j -= 1
				outputters = "R" + b[j+1]
				answer.append(outputters)
			else:
				mincompare = min(memo[i-1][j], memo[i][j-1])
				if mincompare == memo[i-1][j] and cost[1] == memo[i][j] - mincompare:
					i -= 1
					outputters = "D"
					answer.append(outputters)
				elif mincompare == memo[i][j-1] and cost[2] == memo[i][j] - mincompare:
					j -= 1
					outputters = "I"+b[j+1]
					answer.append(outputters)
				elif memo[i][j] == memo[i-1][j-1]:
					i-=1
					j-=1
					outputters = "S"
					answer.extend(outputters) 
	return answer
def main(): 	
	global a, b, max, memo, cost
	for _ in range(int(input())):
		tmp = [int(x) for x in input().split()]
		cost[1] = tmp[0]
		cost[2] = tmp[1]
		cost[3] = tmp[2]
		a = " " + input()
		b = " " + input()
		memo = [[max for y in range(len(b))] for x in range(len(a))]
		dist()
		outputEdits = backtracker9000()
		answer = ""
		for x in reversed(outputEdits):
			answer += str(x)
		answer = answer.rstrip("S")
		print(answer)

main()