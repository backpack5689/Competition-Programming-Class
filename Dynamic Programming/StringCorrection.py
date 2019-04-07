#Program Requirements:
#Return the number of min 
#inserts/deletes/adds to change 
#string A (first input) into 
#string B (second input).
a = ""
b = ""
max = 9999999
memo = [[]]
cost = [0,1,1,1] #Array is Skip, Delete, Insert, Replace
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

def main():
	global a, b, max, memo, cost
	for _ in range(int(input())):
		a = " " + input()
		b = " " + input()
		memo = [[max for y in range(len(a))] for x in range(len(b))]
		dist()
		print(memo[len(a)][len(b)])
main()