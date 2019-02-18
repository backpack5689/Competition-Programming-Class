from itertools import combinations
ingredients = []
minDif = 999999999

def comboFinder(length):
	for specificCombo in combinations(ingredients, length):
		sourTotal = 1
		bitterTotal = 0
		#Ingredient values being stored as (sour,bitter)
		for ingredient in range(length):
			sourTotal = sourTotal * specificCombo[ingredient][0]
			bitterTotal = bitterTotal + specificComb[ingredient][1]
		if abs(sourTotal - bitterTotal) < minDif:
			minDif = abs(sourTotal - bitterTotal)

def main():
	#Type your code here