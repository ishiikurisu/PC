from math import *

def withDot():
    global num
    global cutoff

    number = num.split('.')
    if number[0] == '': number[0] = '0'
    if number[1] == '': number[1] = '0'
    realnum = int(number[0])
    precision = pow(10, len(number[1]) - 1)
    decnum = float(number[1]) / precision
    deccut = float(cutoff) * 10.0

    if decnum >= deccut:
        realnum += 1

    return realnum

def withoutDot():
    global num
    global cutoff

    number = int(num)
    deccut = float(cutoff)

    if deccut == 0.0:
        number += 1

    return number

def setup():
    global num
    global cutoff

    num = raw_input()
    cutoff = raw_input()

def draw():
    global num
    global cutoff

    if '.' in num:
        return withDot()
    else:
        return withoutDot()

if __name__ == '__main__':
    while True:
        try:
            setup()
            print draw()
        except:
            break
