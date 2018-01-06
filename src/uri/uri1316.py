from itertools import combinations as comb

def read():
    return map(int, raw_input().split(' '))

def setup():
    global M
    global L
    global N
    global C

    M, L = read()
    if M == 0 and L == 0:
        raise StandardError
    N = int(raw_input())
    C = read()

def draw():
    global M
    global L
    global N
    global C
    cc = range(N)
    sol = None

    for n in xrange(1, N):
        combs = comb(cc, n)
        for cb in combs:
            m = 0
            l = 0
            for it in cc:
                if it in cb:
                    m += C[it]
                else:
                    l += C[it]
            if m <= M and l <= L:
                sol = cb
                break
        if sol:
            break

    if sol:
        out = ''
        out += '%d' % (len(sol))
        for it in sol:
            out += ' %d' % (it + 1)
        print out
    else:
        print 'Impossible to distribute'

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
