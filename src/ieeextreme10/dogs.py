def main():
    global N # number of dogs
    global K # number walkers
    global X # dogs

    # setup
    N, K = list(map(int, input().split(' ')))
    X = set()
    for _ in range(N):
        X.add(int(input()))
    X = list(X)
    X.sort()
    N = len(X)

    # loop
    limits = []
    for it in [ _ for _ in range(K-1) ]:
        limits.append(it)
    limits.append(K)
    outlet = float('inf')

    while within(limits, K):
        print('{0} {1}'.format(K, limits))
        limits = update(limits, N, K, X)

    return outlet


def within(limits, K):
    fact = True
    current = K

    for it in reversed(limits):
        if it != current:
            fact = False
        current -= 1

    return not fact

def total_range(limits, N, K, X):
    total = 0
    i = 0

    for i in range(1, K-1):
        # calculating partial ranges
        total += X[limits[i]] - X[limits[i-1]]
    total += X[-1] - X[K-1]

    return total

def update(limits, N, K, X):
    i = 0

    while i < K:
        limits[i] += 1
        if limits[i] == limits[i+1]:
            i += 1
        else:
            break

    return limits

if __name__ == '__main__':
    for _ in range(int(input())):
        print(main())
