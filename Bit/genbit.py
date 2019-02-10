#!/usr/bin/env python

from random import randrange
from sys import argv

#numrange is the amount of numbers in your string that it's working with
num_range = (0,31)

CMDS = [
    ("CLEAR", 1),
    ("SET", 1),
    ("OR", 2),
    ("AND", 2),
]
#Edit the 2 lines below this, number of commands and then test cases

cmdsptc = 20
numtests = 25
for _ in range(numtests):
    print(cmdsptc)
    for _ in range(cmdsptc):
        c = CMDS[randrange(0, 4)]
        nums = (randrange(num_range[0], num_range[1] + 1) for _ in range(c[1]))
        print(c[0], *nums)
print(0)
