from math import pi
from math import sqrt
from math import cos

def main(argv):
    if map(int, argv) == [0]*4:
        raise StandardError

    output = True
    l, c, r1, r2 = map(float, argv)

    fc = (1 + sqrt(2)) * cos(pi/4)
    dx1 = r1 * fc
    dy1 = dx1
    dx2 = c - r2 * fc
    dy2 = l - r2 * fc

    output = output and ((dx1 > dx2) and (dy1 > dy2))
    output = output and (2 * max(r1, r2) > min(l, c))

    if output is True: return 'S'
    else: return 'N'

if __name__ == '__main__':
    while True:
        try:
            print main(raw_input().split(' '))
        except:
            break
