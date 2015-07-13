def read():
    return map(int, raw_input().split(' '))

def main():
    raymond, friends = read()
    stamps = sorted(read(), reverse = True)
    friend = 0
    lucy = 0
    while lucy < raymond and friend < friends:
        lucy += stamps[friend]
        friend += 1
    if lucy < raymond:
        friend = 'impossible'
    return friend

if __name__ == '__main__':
    for T in xrange(input()):
        print 'Scenario #%d:' % (T + 1)
        print main()
        print ''
