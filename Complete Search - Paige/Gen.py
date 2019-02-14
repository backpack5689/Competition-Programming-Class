import random
w = 100
p = 2

output = []
print(str(w) + " " + str(p))
print(1, end = " ")
for count in range (1, p):
	output.append(random.randrange(2,w))
output.sort()
print(*(x for x in output))