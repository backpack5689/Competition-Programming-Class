from itertools import groupby
iterations = 0
def decoder(bitString):
	global iterations
	if len(bitString) <= 2:
		if iterations > 0:
			return iterations - 1
		else:
			return iterations
	else:
		iterations += 1
		countArray = []
		for _, aGroup in groupby(bitString):
			countArray.append(len(list(aGroup)))
		#print(countArray)
		newString = ""
		for value in countArray:
			newString += bin(value)[2:]
		return decoder(newString)
def main():
	global iterations
	for _ in range(int(input())):
		initialString  = input()
		print(decoder(initialString))
		iterations = 0
main()