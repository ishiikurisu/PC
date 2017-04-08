def think(N, K, S):
    while True:
        print(S)
        L, R = [], []
        # TODO Disconsider the current occupied stalls
        for i in range(N):
            j, l = i, 0
            while (j > 0) and (not S[j]):
                j, l = j-1, l+1
            L.append(l)
        for i in reversed(range(N)):
            j, r = i, 0
            while (j > 0) and (not S[j]):
                j, r = j-1, r+1
            R.append(r)
        print(L)
        print(R)
        minLR = list(map(lambda it: min(it), zip(L, R)))
        maxLR = list(map(lambda it: max(it), zip(L, R)))
        imaxminLR = list(map(lambda v: v[0], filter(lambda p: p[1], enumerate(map(lambda s: s == max(minLR), minLR)))))
        if len(imaxminLR) == 1:
            chosen = imaxminLR[0]
        else:
            imaxminC = list(map(lambda i: [i, maxLR[i]], imaxminLR))
            maxC = max(imaxminC, key=lambda it: it[1])[1]
            imm = map(lambda p: p[0], filter(lambda it: it[1] == maxC, imaxminC))
            chosen = min(imm)

        if K == 1:
            print(chosen)
            return max(L[chosen], R[chosen]), min(L[chosen], R[chosen])
        else:
            S[chosen] = True
            K = K-1

def magic(N, K):
    S = [False] * N
    M, m = think(N, K, S)
    return M, m

if __name__ == '__main__':
    T = int(input())
    for t in range(T):
        line = input().split(' ')
        N, K = int(line[0]), int(line[1])
        M, m = magic(N, K)
        print('case %d: %d %d' % (t+1, M, m))
