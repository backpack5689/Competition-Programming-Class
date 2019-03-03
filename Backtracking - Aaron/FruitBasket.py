from itertools import combinations
totalWeight = 0
fruitArray = []
def fruitBasketCreator(turnedOn, position, weight):
	global totalWeight
	if position != turnedOn.len:
		fruitBasketCreator(turnedOn, position+1, weight)
		if(weight+fruitArray[position] < 200):
			turnedOn[position] = True
			fruitBasketCreator(turnedOn, position+1, weight+array[position])
	else:
		totalWeight = totalWeight - weight
	
def main():
	global totalWeight
	global fruitArray
	input()
	fruitArray = [int(x) for x in input().split()]
	totalWeight = sum(fruitArray)
	totalWeight = totalWeight * 2**fruitArray.len
	turnedOn = [false] * (fruitArray.len+1)
	fruitBasketCreator(turnedOn, 0, 0) 
	print(totalWeight)
	