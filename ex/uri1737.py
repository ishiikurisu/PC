def process():
    global counter
    global lines

    counter = {}
    length = len(lines)
    for i in xrange(length - 1):
        piece = lines[i:i+2]
        print '  %s' % (piece)
        if counter.has_key(piece):
            counter[piece] += 1
        else:
            counter[piece] = 1

def draw():
    global counter

    best = sorted(counter, key = lambda x: counter[x], reverse = True)
    total = len(counter) + 0.0
    for i in xrange(5):
        s = best[i]
        d = counter[s]
        f = d / total
        print '%s: %d %.6f' % (s, d, f)
    print ''


def setup():
    global number_lines
    global lines

    number_lines = input()
    if number_lines == 0:
        raise StandardError
    lines = ''
    for line in xrange(number_lines):
        line = raw_input()
        lines += line

def loop():
    process()
    draw()

if __name__ == '__main__':
    while True:
        try:
            setup()
            loop()
        except:
            break
