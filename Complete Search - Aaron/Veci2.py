from itertools import permutations
myNumber = input()
myNumberArray = [int(i) for i in myNumber]
permutationArray = []
permutationArray.append(permutations(permutationArray))
permutationArray.remove(myNumberArray)


try:
	print(*(min(permutationArray)), sep="")
except ValueError:
	print(0)