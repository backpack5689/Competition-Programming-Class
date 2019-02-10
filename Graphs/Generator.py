from random import randrange
#numrows is the amount of rows in the input
#edit the number in the range parenthesis to edit the amount of test cases
numrows = 10
for n in range(1):
	print(numrows)
	for _ in range(numrows):
		print(*(randrange(0,2) for _ in range(numrows)),sep=" ")
print(str(-1))
	
