minimum = 9999999999999
problems = []
def binaryLookup(n, k):
	#This function looks up to see if the value at k in the bit version of n is a 1 (true) or a 0 (false)
	if n & (1<<(k)):
		return True
	else:
		return False

def dp():
	global problems, minimum
	for x in range(2**len(problems)):
		#print(binaryString)
		set1 = 0
		set2 = 0
		for index in range(len(problems)):
			#print(index, num)
			if binaryLookup(x, index):
				set1 += problems[index]
			else:
				set2 += problems[index]
		differenceSets = abs(set1-set2)
		if minimum > differenceSets:
			minimum = differenceSets
			#print(set1)
			#print(set2)

def main():
	global problems, minimum
	for _ in range(int(input())):
		input()
		problems = [int(x) for x in input().split()]
		problems.sort()
		dp()
		print(minimum)
		minimum = 9999999999999
main()