import re
repeatLibrary = [[],[]]

def fib(n):
	fibArray = ["0", "1", "10"]
	placeHolder = 0
	if n in repeatLibrary[0]:
		n = repeatLibrary[0].index(n)
		return repeatLibrary[1][n]
	else:
		repeatLibrary[0].append(n)
	for ii in range(3, n+1):
		if placeHolder == 0:
			fibArray[0] = fibArray[2] + fibArray[1]
			placeHolder = 1
			prevHolder = 0
		elif placeHolder == 1:
			fibArray [1] = fibArray[0] + fibArray[2]
			placeHolder = 2
			prevHolder = 1
		elif placeHolder == 2:
			fibArray[2] = fibArray[1] + fibArray[0]
			placeHolder = 0
			prevHolder = 2
	repeatLibrary[1].append(fibArray[prevHolder])
	return fibArray[prevHolder]
def bitmatcher(testBits, calcBits):
	return len(re.findall(testBits[0]+"(?="+testBits[1:]+")", calcBits))

def main():
	caseNum = 1
	while True:
		try:
			n = int(input())
		except:
			break
		bitPattern = input()
		fib(n)
		timesFound = bitmatcher(bitPattern, fib(n))
		timesFound = int(timesFound)
		print(f"Case {caseNum}: {timesFound}")
		caseNum += 1	
main()