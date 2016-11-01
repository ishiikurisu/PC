from functools import reduce

def beauty(parade):
    return abs(sum(parade))

def ideal_beauty(parade):
    return sum(list(map(abs, parade)))

def think(parade, i):
    parade[i] = -parade[i]
    return beauty(parade)

def main():
    N = int(input())
    P = []

    # setup
    for _ in range(N):
        L, R = list(map(int, input().split(' ')))
        P.append(L - R)

    # base case
    maxbeauty = ideal_beauty(P)
    if beauty(P) is maxbeauty:
        return 0

    # loop
    best = float('inf')
    change = -1
    for i in range(N):
        current = think(P, i)
        diff = maxbeauty - think(P, i)
        if diff is 0:
            change = i+1
            break
        elif diff < best:
            best = current
            change = i+1

    return change

if __name__ == '__main__':
    while True:
        try:
            print(main())
        except:
            break
