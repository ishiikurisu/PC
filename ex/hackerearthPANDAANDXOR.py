from itertools import combinations as comb

def maxor(array):
    out = 0
    for item in array:
        out = item ^ out
    return out

def main(argv):
    A = map(int, argv)
    N = len(A)
    R = 0

    a = set(A)
    for i in xrange(1, N - 1):
        for sub in comb(A, i):
            m = set(sub)
            n = a - m
            if maxor(m) == maxor(n):
                 R = (R + 1) % 1000000007
    return R

if __name__ == '__main__':
    N = input()
    print main(raw_input().split(' '))
