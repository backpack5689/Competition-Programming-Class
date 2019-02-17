from itertools import permutations
def convert(array):
	returnvalue = 0
	index = 0
	for digit in reversed(range(len(array))):
		returnvalue = returnvalue + (array[index] * 10**(digit)) 
		index = index + 1
	return returnvalue

found = False
myNumber = input()
minimum = 99999999999;
myNumberArray = [int(i) for i in myNumber]
myNumber = int(myNumber)
for Array in permutations(myNumberArray):
	value = convert(Array)
	if value > myNumber and value < minimum:
		found = True
		minimum = value
if found:
	print(minimum)
else:
	print(0)