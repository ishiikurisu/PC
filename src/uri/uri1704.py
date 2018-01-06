def read():
    return map(int, raw_input().split(' '))
def write(data):
    print '  ',
    print data

def setup():
    global N
    global H
    global D

    N, H = read()
    D = []
    for n in xrange(N):
        D.append(read()) # v, t
    D = sorted(D, key = lambda x: x[1])
    D = sorted(D, key = lambda x: x[0], reverse = True)
    write(D)

def draw():
    global N
    global H
    global D

    t = 1
    r = 0
    l = 0
    n = 0



    print r

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            raise
