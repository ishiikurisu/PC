# SPOJ TRT
def new_memo(n):
    m = []
    for x in range(n+1):
        X = []
        for y in range(n):
            Y = []
            for z in range(n):
                Y.append(-1)
            X.append(Y)
        m.append(X)
    return m

def process(a, l, r, o):
    global M
    global N
    global V

    if M[a][l][r] >= 0: return M[a][l][r]
    
    if l == r:
        o += V[r] * a
        M[a][l][r] = max(o, M[a][l][r])
    else:
        x = process(a + 1, l + 1, r, o + V[l]*a)
        y = process(a + 1, l, r - 1, o + V[r]*a)
        M[a][l][r] = max(x, y, M[a][l][r])
        
    return M[a][l][r]
    
V = []
N = input()
for n in range(N):
    V.append(input())
M = new_memo(N)
print process(1, 0, N-1, 0)
