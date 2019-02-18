for test in range(1,181):
	overallScore = test
	score = [0] * 3
	mod = [1] * 3
	completed = False
	for score1 in range(1,21):
		for mod1 in range(1,4):
			if(score1 * mod1 == overallScore):
				score[0] = score1
				mod[0] = mod1
				completed = True 
				break
			for score2 in range(1,21):
				for mod2 in range(1,4):
					if(score2 * mod2 + score1 * mod1 == overallScore):
						score[0],score[1] = score1,score2
						mod[0],mod[1] = mod1,mod2
						completed = True
						break
					for score3 in range(1,21):
						for mod3 in range(1,4):
							if(score2 * mod2 + score1 * mod1 + score3 * mod3 == overallScore):
								score[0],score[1], score[2] = score1,score2,score3
								mod[0],mod[1],mod[2] = mod1,mod2,mod3
								completed = True
								break
						if completed:
							break
					if completed:
						break
				if completed:
					break
			if completed:
				break
		if completed:
			break
	if score[0] == 0:
		print("impossible")
	for i in range(3):
		if score[i] == 0:
			break
		else:
			if mod[i] == 1:
				print("single " + str(score[i]))
			if mod[i] == 2:
				print("double " + str(score[i]))
			if mod[i] == 3:
				print("triple " + str(score[i]))
	print("***")