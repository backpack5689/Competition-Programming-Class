#!/usr/bin/env python

import random

items = 300000
drawers = 300000

print(items, drawers)

for _ in range(items):
    print('{} {}'.format(random.randrange(1,drawers), random.randrange(1,drawers)))
