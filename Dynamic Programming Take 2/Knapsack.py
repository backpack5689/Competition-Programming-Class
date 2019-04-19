from math import floor
totalWeight = -1
numObj = -1

def main():
	global totalWeight, numObj
	totalWeight, numObj = (floor(x) for x in input().split())
	while True:
		