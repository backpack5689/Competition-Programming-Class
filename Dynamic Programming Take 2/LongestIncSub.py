inputArray = []
indexArray = []
def dp():
	global inputArray, indiceArray
	n = len(inputArray)
	longis = [1 for x in range(n)]
	longisbunny = [-1 for x in range(n)]
	for ii in range(1,n):
		for jj in range(0, ii):
			if inputArray[ii] > inputArray[jj] and longis[ii] < longis[jj] + 1:
				longis[ii] = longis[jj] + 1
				longisbunny[ii] = jj
	maxi = 0
	bunnystart = -1
	for i in range(n):
		if(longis[i] > maxi):
			maxi = longis[i]
			bunnystart = i
	indiceArray = []
	indiceArray.append(bunnystart)
	while True:
		if not longisbunny[bunnystart] == -1:
			indiceArray.append(longisbunny[bunnystart])
			bunnystart = longisbunny[bunnystart]
		else:
			break
	return maxi
	
def main():
	global inputArray, indiceArray
	while True:
		try:
			numLength = input()
		except:
			break
		numLength = int(numLength)
		inputArray = [int(x) for x in input().split()]
		numAns = dp()
		print(numAns)
		for i in reversed(indiceArray):
			print(i, end = " ")
		print()

main()