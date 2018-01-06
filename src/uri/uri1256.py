def read():
    return map(int, raw_input().split(' '))

FIRST_CASE = True

def setup():
    global M
    global hash

    M, C = read()
    data = read()
    hash = {}

    for item in data:
        hex = item % M
        if not hash.has_key(hex):
            hash[hex] = []
        hash[hex].append(item)

def draw():
    global FIRST_CASE
    global M
    global hash

    if FIRST_CASE is True:
        FIRST_CASE = False
    else:
        print ''

    for i in xrange(M):
        outlet = '%d' % (i)
        if hash.has_key(i):
            data = hash[i]
            for it in data:
                outlet += ' -> %d' % (it)

        print outlet + ' -> \\'

if __name__ == '__main__':
    for T in xrange(input()):
        setup()
        draw()
