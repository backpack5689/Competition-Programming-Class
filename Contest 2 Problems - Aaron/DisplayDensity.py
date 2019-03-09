for _ in range(int(input())):
	Ad = [x for x in input().split()]
	length = [len(x) for x in Ad]
	min = max(length)
	#len(Ad) - 1 --> Number of spaces in a max 1 line
	max = sum(length) + (len(Ad)-1)
	cost = 999999999
	for windowSize in range(min, max+1):
		