def setup():
    global numppl
    global chosen
    global moment

    n, m, k = map(int, raw_input().split(' '))
    numppl = n
    chosen = m
    moment = k

    if n == 0: raise StandardError

def draw():
    global numppl
    global chosen
    global moment

    result = -1
    claps = [0] * numppl
    count = 0
    dir = 1

    i = 0
    n = numppl - 1
    m = chosen - 1
    k = moment

    while result < 0:
        count += 1
        # print '%d %d' % (i, count)

        if must_clap(count):
            claps[i] += 1
            if claps[m] == k:
                result = count

        i += dir
        if i == n or i == 0:
            dir = -dir

    return result

def must_clap(number):
    str = '%d' % number

    if number % 7 == 0 or '7' in str:
        return True
    else:
        return False

if __name__ == '__main__':
    setup()
    print draw()
    while True:
        try:
            setup()
            print draw()
        except:
            break
