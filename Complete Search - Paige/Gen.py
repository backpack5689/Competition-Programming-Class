import random
w = 100
p = 20
output = []

def randArray():
	for count in range (1, p):
		output.append(random.randrange(2,w))
	output.sort()

	return output
	


reDo = False
print(str(w) + " " + str(p))
print(1, end = " ")
while not reDo:
	reDo = True
	randArray()
	for pointer1 in range(0,len(output)):
		for pointer2 in range(pointer1+1,len(output)):
			if(output[pointer1] == output[pointer2]):
				reDo = False
			
print(*(x for x in output))
