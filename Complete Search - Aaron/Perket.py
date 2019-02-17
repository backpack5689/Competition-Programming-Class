from itertools import combinations
#Global Variables
ingredients = []
ingredientTotals = []

def number13burgerkingfootlettuce(length):
	for aCombination in combinations(ingredients, length):
		sourTotal = 1
		bitterTotal = 0
		#The following loop will go through 1 possible combination and 
		#add the value in a tuple to sour and bitter total as stored
		#(sour,bitter)
		for n in range(length):
			sourTotal = sourTotal * aCombination[n][0]
			bitterTotal = bitterTotal + aCombination[n][1]
		ingredientTotals.append(abs(sourTotal - bitterTotal))
def main():
	lines = int(input())
	for _ in range(lines):
		line = input()
		line = line.split(" ")
		sour = int(line[0])
		bitter = int(line[1])
		ingredients.append((sour,bitter))
		ingredientTotals.append(abs(sour-bitter))
	for pastabilities in range(1,lines):
		number13burgerkingfootlettuce(pastabilities+1)
	print(min(ingredientTotals))	
main()
		