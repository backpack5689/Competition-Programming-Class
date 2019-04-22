alphaArray = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","_","."]
cypherArray = []

def encrypter(decryptedString):
	returning = []
	for i in decryptedString:
		if not (i == "_" or i == "."):
			returning.append(cypherArray[ord(i)-65])
		else:
			if i == "_":
				returning.append(cypherArray[26])
			if i == ".":
				returning.append(cypherArray[27])
	return returning
	
def cypherCreator(step):	
	global alphaArray, cypherArray
	cypherArray = []
	i = step
	for ii in alphaArray[i:]:
		cypherArray.append(ii)
	for ii in alphaArray[0:i]:
		cypherArray.append(ii)

def main():
	flag = True
	line = input()
	step = int(line.split()[0])
	if step == 0:
		print("REVERSE_ROT")
		flag = True
	decryptedString = line.split()[1]
	while flag:
		cypherCreator(step)
		encryptedArray = encrypter(decryptedString)
		print("".join(encryptedArray[::-1]))
		line = input()
		step = int(line.split()[0])
		if step == 0:
			break
		decryptedString = line.split()[1]
main()