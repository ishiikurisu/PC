from math import pi
if __name__ == '__main__':
    L = float(raw_input())
    while L != 0:
        A = (L ** 2) / (pi * 2)
        print '%.2f' % (A)
        L = float(raw_input())
