n = input()
m = set()
while n > 1 and n not in m:
    m.add(n)
    if n % 2 == 0:
        n = n / 2
    else:
        n = 3*n + 3
if n > 1: print 'NIE'
else: print 'TAK'
