vowels = {'a','e','i','o','u'}
pairs = {'ai','au','ay','ea','ee','ei','ey','ie','oi','oo','ou','oy','ue'}
ys = {'ay', 'ey','oy'}
for _ in range(int(input())):
	word = input()
	word = word.lower()
	count = 0
	skip = False
	for parser in range(len(word)):
		if skip:
			skip = False
			continue
		if word[parser] in vowels:
			if word[parser:parser+2] in pairs:
				skip = True
			count+=1
	if word[-1] == 'y' and word[-2:] not in ys:
		count += 1
	elif len(word) >= 3 and (word[-1] == 'e') and (word[-2] not in vowels) and (word[-3] in vowels):
		count -= 1
	elif len(word) >= 4 and (word[-1] == 'e') and (word[-2] not in vowels) and (word[-3] not in vowels) and (word[-4] in vowels):
		count -= 1
	print(count)