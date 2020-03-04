problems = []
total = 0

def dp(i, sumSetA):
	global problems, total
	if i == len(problems):
		print(sumSetA)
		return abs(total-2*sumSetA)
	else:
		return min(dp(i+1, sumSetA), dp(i+1, sumSetA+problems[i]))

def main():
	global problems, minimum
	for _ in range(int(input())):
		input()
		problems = [int(x) for x in input().split()]
		problems.sort()
		total = sum(problems)
		dp(0,0)
		print(dp(0,0))
main()