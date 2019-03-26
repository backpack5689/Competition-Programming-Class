coinTypes = []
isCanonical = True
greedyCoinNums = []
optimalCoinNums = []

#This algorithm just goes through and finds the greedy way of 
#solving the issue
def greedyAlgorithm(upperLimit):
	global greedyCoinNums, coinTypes
	for target in range(1,upperLimit):
		currentCoins = 0
		for Rupee in reversed(coinTypes):
			if target - Rupee > 0:
				numCoinofType = target // Rupee
				target -= Rupee * (numCoinofType)
				currentCoins += numCoinofType	
		greedyCoinNums.append(currentCoins)
	print(greedyCoinNums)

def optimalAlgorithm(upperLimit):
	global optimalCoinNums, coinTypes
	memo = [999999]*(upperLimit)
	memo[0] = 0
	for target in range(1,upperLimit):
		for i, Rupee in enumerate(coinTypes):
			if target > Rupee:
				print(memo[target - Rupee]+1)
				print(memo[target])
				print("---------------")
				memo[target] = min(memo[target - Rupee]+1, memo[target])
		optimalCoinNums = memo
	print (memo)
	
def canonicalTest(upper):
	global isCanonical, greedyCoinNums, optimalCoinNums
	greedyAlgorithm(upper)
	optimalAlgorithm(upper)
	if not greedyCoinNums == optimalCoinNums:
		isCanonical = False
	
def main():
	global coinTypes, isCanonical
	input()
	coinTypes = [int(x) for x in input().split()];
	upper = coinTypes[len(coinTypes)-1] + coinTypes[len(coinTypes)-2]
	#print(upper)
	canonicalTest(upper)
	if isCanonical:
		print("canonical")
	else:
		print("non-canonical")
main()