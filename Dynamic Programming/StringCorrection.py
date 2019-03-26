#Program Requirements:
#Return the min inserts/deletes/adds to 
#change string A (first input) into 
#string B (second input).
a = ""
b = ""
max = 9999
memo = [[]]
def dist(i, j):
	global a,b,max,memo
	if not (memo[i][j] == max):
		return memo[i][j]
	elif i > len(a)-1:
		memo[i][j] = len(b)-j
		return len(b)-j
	elif j > len(b)-1:
		memo[i][j] = len(a)-i
		return len(a)-i
	elif a[i] == b[j]:
		memo[i][j] = dist(i+1, j+1)
		return dist(i+1, j+1)
	else:
		memo[i][j] = 1+min({dist(i,j+1),dist(i+1,j),dist(i+1,j+1)})
		return memo[i][j]

def main():
	global a, b, max, memo
	for _ in range(int(input())):
		memo = [[max]*1000]*1000
		a = input()
		b = input()
		print(dist(0,0))

main()