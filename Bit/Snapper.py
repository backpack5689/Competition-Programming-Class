testCases = int(input())
for ii in range(1,testCases+1):
    numSnappers, numSnaps = [int(x) for x in input().split()]
    myint = (1<<numSnappers)-1     
    if ((numSnaps & myint) ^ myint):
        print(f'Case #{ii}: OFF')
    else:
        print(f'Case #{ii}: ON')
#Basically, what this is doing is that it is looking for the substring of (2**N)-1(base 2), and if it finds that, then it will be able to be turned on. So, line 3 takes the inputs, line 4 is the base 2 string that we are looking for. line 5 is "spotting the difference". If our number of snaps anded with our number that we are looking for, and then xord with that same number, it should equal zero. Therefore, being false, and going with the else.
