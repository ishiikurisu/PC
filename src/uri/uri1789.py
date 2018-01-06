def read():
    return map(int, raw_input().split(' '))

def level(l):
    if l >= 20:
        return 3
    elif l >= 10:
        return 2
    else:
        return 1

def setup():
    global L
    global V
    L = read()
    V = read()

def draw():
    global V
    o = 1
    for v in V:
        l = level(v)
        if l > o: o = l
    print o

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
