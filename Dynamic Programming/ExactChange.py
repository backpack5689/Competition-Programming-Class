from itertools import combinations
wallet = []
returning = [999999] * 2
def combfinder(target):
	for places in range(1, len(wallet)+1):
		for iteration in combinations(wallet, places):
			totals = sum(iteration)
			if(target - totals <= 0 and totals - target < returning[0] - target):
				returning[0] = totals 
				returning[1] = len(iteration)
def main():
	global wallet, returning
	input()
	target = int(input())
	for _ in range(int(input())):
		wallet.append(int(input()))
	combfinder(target)
	print(str(returning[0]) + " " + str(returning[1]))
main()
