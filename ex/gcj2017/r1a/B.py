import math

def read():
    return list(map(int, input().split(' ')))

T = int(input())
for t in range(T):
    # Input
    line = read()
    N, P = line[0], line[1]
    R = read()
    Q = [read() for _ in range(N)]
    # Output
    S = []
    for i, qi in enumerate(Q):
        r = R[i]
        s = 0
        for qij in qi:
            # lower bound
            lower = False
            if qij//r is 0:
                lower = qij/r >= 0.9
            else:
                dr = qij / r
                di = 1 + qij//r
                lower = dr/di >= 0.9
            # upper bound
            upper = (qij / r) <= 1.1 * (qij // r)
            # result
            if lower or upper:
                s += 1
        S.append(s)
    print('Case #%d:' % (t+1), S)
