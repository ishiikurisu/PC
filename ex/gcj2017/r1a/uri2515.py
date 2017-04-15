import math
import sys

def main():
    N = int(input())
    B = list(map(int, input().split(' ')))
    total = sum(B)
    partial = 0
    M = 1000000000000000000000
    L = 1000000000000000000000
    for b in B:
        partial += b
        tp = total - partial
        tpp = math.fabs(tp - partial)
        if tpp < M:
            L = tp
            M = tpp
    print(L, total - L)


while True:
    try:
        main()
    except:
        break
