memo = []
price = 0
numCommercialBreaks = 0
studentsListening = []
possibleIncome = []

def dp():
	global possibleIncome, numCommercialBreaks
	currNum = possibleIncome[0]
	maxi = possibleIncome[0]
	for i in range(1,numCommercialBreaks):
		currNum = max(possibleIncome[i], possibleIncome[i]+currNum)
		maxi = max(maxi, currNum)
	return maxi
	
def main():
	global price, numCommercialBreaks, studentsListening, possibleIncome
	numCommercialBreaks, price = (int(x) for x in input().split())
	studentsListening = [int(x) for x in input().split()]
	possibleIncome = [(x - price) for x in studentsListening]
	ans = dp()
	print(ans)
main()
