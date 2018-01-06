def read(func):
    return map(func, raw_input().split(' '))

on, off = False, True
A, C = read(int)
while A is not 0 and C is not 0:
    B = read(lambda x: A - int(x))
    big = max(B)
    outlet = 0
    for depth in xrange(1, big + 1):
        before = laser = off
        for hole in B:
            if hole >= depth: laser = on
            else: laser = off
            if laser is off and before is on:
                outlet += 1
            before = laser
        if laser is on:
            outlet += 1
    print outlet
    A, C = read(int)
