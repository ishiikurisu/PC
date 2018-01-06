def main(argv):
    a, b = map(lambda x: int(x[::-1]), argv)
    r = '%d' % (a + b)
    print int(r[::-1])

if __name__ == '__main__':
    for N in xrange(input()):
        main(raw_input().split(' '))
