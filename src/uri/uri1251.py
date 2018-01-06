def setup():
    global data

    inlet = raw_input()
    frequency = {}
    present = []

    for ch in inlet:
        c = ord(ch)
        if c not in frequency:
            frequency[c] = 0
            present.append(c)
        frequency[c] += 1

    data = []
    for it in present:
        data.append([it, frequency[it]])

def draw():
    global first_case
    global data

    if first_case:
        first_case = False
    else:
        print ''

    data = sorted(data, key = lambda x: x[0], reverse = True)
    data = sorted(data, key = lambda x: x[1])

    for pair in data:
        print '%d %d' % (pair[0], pair[1])

if __name__ == '__main__':
    first_case = True
    while True:
        try:
            setup()
            draw()
        except:
            break
