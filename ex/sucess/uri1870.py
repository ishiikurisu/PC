def read():
    return map(int, raw_input().split(' '))

def check(line, position, direction):
    index = position
    limit = len(line) if direction > 0 else 0

    while line[index] == 0 and index != limit:
        index += direction

    return line[index]

def fan(line, position, offset):
    boom = False
    index = position
    direction = 1 if offset > 0 else -1

    for n in xrange(abs(offset)):
        index += direction
        if line[index] != 0:
            boom = True
            break

    return index, boom

def setup():
    global number_lines
    global initial_position

    L, C, P = read()
    if L == 0 and C == 0 and P == 0:
        raise Exception
    else:
        number_lines = L
        initial_position = P-1

def draw():
    global number_lines
    global initial_position

    position = initial_position
    for L in xrange(number_lines):
        line = read()
        right = check(line, position, 1)
        left = check(line, position, -1)
        offset = left - right
        C, boom = fan(line, position, offset)
        if boom:
            print 'BOOM %d %d' % (L+1, C+1)
            break
        else:
            position = C
    else:
        print 'OUT %d' % (position+1)

if __name__ == '__main__':
    number_lines = initial_position = 0
    while True:
        try:
            setup()
            draw()
        except:
            break
