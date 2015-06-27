N = 0
FL = True
lines = []
lenghts = []
biggest_length = 0

def setup():
    global lines
    global lengths
    global biggest_length

    lines = []
    lengths = []
    biggest_length = 0

    for n in xrange(N):
        words = raw_input().split(' ')
        line = []
        length = 0

        for word in words:
            if word:
                line.append(word)
                length += len(word) + 1
        length -= 1
        if length > biggest_length:
            biggest_length = length

        lines.append(line)
        lengths.append(length)

def draw():
    global N
    global FL
    global lines
    global lengths
    global biggest_length

    if FL is True:
        FL = False
    else:
        print ''

    for n in xrange(N):
        line = lines[n]
        no_spaces = biggest_length - lengths[n]

        if no_spaces > 0:
            output = ' ' * (no_spaces)
        else:
            output = ''

        for word in line:
            output += ' ' + word

        print output[1::]

if __name__ == '__main__':
    N = input()
    while N > 0:
        setup()
        draw()
        N = input()
