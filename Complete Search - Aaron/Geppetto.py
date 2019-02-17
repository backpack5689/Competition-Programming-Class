#Global Variables
toppingRestrictions = []

#Taking Input
numIngredients, numLines = [int(i) for i in input().split()]
for _ in range(numLines):
	line = input()
	line = line.split()
	topping1 = int(line[0])
	topping2 = int(line[1])
	toppingRestrictions.append((1 << (topping1-1)) + (1<<(topping2-1)))

#Computation
possPizzas = 2**numIngredients
for pizza in range(2**numIngredients):
	for badPair in toppingRestrictions:
		if(pizza & badPair == badPair):
			possPizzas = possPizzas - 1
			break

#Output
print(possPizzas)
