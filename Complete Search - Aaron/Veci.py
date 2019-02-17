#Basically, I want to take the number I get, find the biggest number, and then move it over 1 spot until
#the number I get is > the number x.

def move(myInt):
	myIntArray = [int(i) for i in str(myInt)]
	max = -1
	pos,max = max(enumerate(myIntArray), key=lambda x: x[1])
	#And now to swap it forward, I want to take my position and swap with position + 1
	if pos-1 >= 0:
		tmp = myIntArray[pos-1]
		myIntArray[pos-1] = myIntArray[pos]
		myIntArray[pos] = tmp
	mySubArray = []
	mySubArray.append(x for x in myIntArray[pos:myIntArray.len()])
	mySubArray = sort(mySubArray)
	for i in range(pos,myIntArray.len()):
		myIntArray[i] = mySubArray[i]
	#Now I need something to change my array into a number
	return convert(myIntArray)
	
def convert(array):
	returnvalue = 0
	index = 0
	for digit in reversed(range(array.len())):
		returnvalue = returnvalue + (array[index] * 10**(digit)) 
		index = index + 1
	return returnvalue
	
def sort(array):
	for i in range(len(array)): 
		min_idx = i 
		for j in range(i+1, len(array)): 
			if array[min_idx] > array[j]: 
				min_idx = j 
	return array			
    # Swap the found minimum element with  
    # the first element         
myVal = int(input())
movedVal = move(myVal)
for iterations in range(0,100):
	if(movedVal > myVal):
		print(movedVal)
		break
	else:
		movedVal = move(movedVal)