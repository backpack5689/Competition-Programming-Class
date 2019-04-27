alpha=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
try:
	line = input()
except:
	print("Cipher not computable")
shouldBeA = line[0]
move = ord(shouldBeA) - 65
if move == 0:
	print(alpha)
else:
	alpha.extend(alpha[0:move])
	print(alpha[move:26+move])