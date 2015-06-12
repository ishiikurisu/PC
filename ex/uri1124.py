from math import pi
from math import sqrt
from math import cos

def rl(r, x):
    return x - r * (1 + cos(pi / 4))
def cc(r):
    return pi * r**2

def main(argv):
    input = map(int, argv.split(' '))

    if input == [0]*4:
        raise StandardError

    input = map(float, input)
    l, c, r1, r2 = input

    fc = (1 + sqrt(2)) * cos(pi/4)
    dx1 = r1 * fc
    dy1 = dx1
    dx2 = c - r2 * fc
    dy2 = l - r2 * fc
    if ((dx1 < dx2) or (dy1 < dy2)) and (2 * max(r1, r2) < min(l, c)):
        return 'S'
    else:
        return 'N'

while True:
    try:
        print main(raw_input())
    except:
        break
