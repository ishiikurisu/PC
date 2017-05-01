a = list(map(int, input().split(' ')))
n, m = a[0], a[1]
if n >= m:
    print(n-m)
else:
    d = [1e12] * (2*m)
    d[n] = 0
    Q = [n]
    while Q:
        e = Q[0]
        del Q[0]
        if (e < m) and (d[2*e] >= 1e12):
            Q.append(2*e)
            d[2*e] = d[e] + 1
        if (e-1 > 0) and (d[e-1] >= 1e12):
            Q.append(e-1)
            d[e-1] = d[e] + 1
    print(d[m])
