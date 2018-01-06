def read():
    return map(int, raw_input().split(' '))

def write(n):
    return '%d ' % (n)

def main():
    N, R = read()
    S = set(read())
    O = ''

    for n in xrange(1, N+1):
        if n not in S:
            O += write(n)

    print '*' if not len(O) else O

if __name__ == '__main__':
    while True:
        try:
            main()
        except:
            break
