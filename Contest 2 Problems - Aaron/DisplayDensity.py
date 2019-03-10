for _ in range(int(input())):
	Ad = [x for x in input().split()]
	length = [len(x) for x in Ad]
	minimal = max(length)
	#len(Ad) - 1 --> Number of spaces in a max 1 line
	maximal = sum(length) + (len(Ad)-1)
	cost = 999999999
	for windowSize in range(minimal, maximal+1):
		completeWindow = []
		oneline = [length[0]]
		for value in length[1:]:
			if sum(oneline)+1+value <= windowSize:
				oneline.append(value+1)
			else:
				completeWindow.append(oneline)
				oneline = [value]
		completeWindow.append(oneline)
		tmpcost = len(completeWindow) * 2 + windowSize
		if tmpcost < cost:
			cost = tmpcost
	print(cost)