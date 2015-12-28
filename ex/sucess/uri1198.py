def uri1198():
    x, y = map(int, raw_input().split(' '))
    if not (x > y): x, y = y, x
    print '%d' % (x - y)

if __name__ == '__main__':
    while True:
        try:
            uri1198()
        except:
            break
