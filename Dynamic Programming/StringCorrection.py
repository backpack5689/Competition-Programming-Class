#Program Requirements:
#Return the number of min 
#inserts/deletes/adds to change 
#string A (first input) into 
#string B (second input).
a = ""
b = ""
max = 9999999
memo = [[]]
def dist(i, j):
	global a,b,max,memo
	if not (memo[i][j] == max):
		return memo[i][j]
	elif i > (len(a)-1):
		memo[i][j] = len(b)-j
		return memo[i][j]
	elif j > (len(b)-1):
		memo[i][j] = len(a)-i
		return memo[i][j]
	elif a[i] == b[j]:
		memo[i][j] = dist(i+1, j+1)
		return memo[i][j]
	else:
		memo[i][j] = 1+min(dist(i+1,j+1),dist(i,j+1),dist(i+1,j))
		return memo[i][j]

def main():
	global a, b, max, memo
	for _ in range(int(input())):
		a = input()
		b = input()
		memo = [[max for y in range(len(a)+1)] for x in range(len(b)+1)]
		print(dist(0,0))
main()