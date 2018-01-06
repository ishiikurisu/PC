def minute(data):
    line = data.split(':')
    hour = int(line[0])
    mint = int(line[1])

    return hour * 60 + mint

def get_index(l, m):
    n = 0
    for i in l:
        if i[0] < m:
            n += 1
        else:
            break
    return n

def argv():
    return raw_input().split(' ')

def setup():
    global history

    hst = []
    T = input()
    NA, NB = map(int, argv())

    for n in xrange(NA):
        line = argv()
        dep = minute(line[0])
        arr = minute(line[1])
        hst.append([dep, 'DA'])
        hst.append([arr + T, 'AB'])

    for n in xrange(NB):
        line = argv()
        dep = minute(line[0])
        arr = minute(line[1])
        hst.append([dep, 'DB'])
        hst.append([arr + T, 'AA'])

    hst = sorted(hst, key = lambda x: x[1])
    history = sorted(hst, key = lambda x: x[0])

def draw():
    global history

    N = {'A': 0, 'B': 0}
    T = {'A': 0, 'B': 0}

    for event in history:
        moment = event[0]
        M, S = event[1]

        if M == 'A':
            T[S] += 1
        else:
            if T[S] == 0:
                N[S] += 1
                T[S] = 1
            T[S] -= 1

    print '%d %d' % (N['A'], N['B'])
    # print history

if __name__ == '__main__':
    for N in xrange(input()):
        print 'Case #%d:' % (N + 1),
        setup()
        draw()
