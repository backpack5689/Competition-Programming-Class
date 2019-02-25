from itertools import combinations
totalWeight = 0;
input()
fruitArray = [int(x) for x in input().split()]

for places in range(len(fruitArray)+1):
	for aCombo in combinations(fruitArray, places):
		if sum(aCombo) >= 200:
			totalWeight = totalWeight + sum(aCombo)
print(totalWeight)