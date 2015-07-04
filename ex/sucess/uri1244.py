def write(data):
    out = ''
    first = True

    for it in data:
        if first: first = False
        else: out += ' '
        out += it

    return out

for T in xrange(input()):
    data = raw_input().split(" ")
    data = sorted(data, key = lambda x: len(x), reverse = True)
    print write(data)
