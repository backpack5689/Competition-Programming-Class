repetitions = int(input())
for _ in range(repetitions):
	inputs = [int(x) for x in input().split()]
	#inputs = {length, width, depth}, taken in inches
	totalSurfaceArea = (4*inputs[0]*inputs[2])+(4*inputs[1]*inputs[2])+(2*inputs[1]*inputs[0])
	#totalSurfaceArea in inches^2 
	gallonCoverage = 200*144
	#gallonCoverage is in inches^2
	toyBoxesPainted = 0
	while gallonCoverage > 0:
		if gallonCoverage - totalSurfaceArea < 0:
			break
		else: 
			toyBoxesPainted = toyBoxesPainted + 1
			gallonCoverage = gallonCoverage - totalSurfaceArea
	print(toyBoxesPainted)