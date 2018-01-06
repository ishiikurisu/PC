from math import ceil

def main():
    n, m, a = map(lambda x: float(x), raw_input().split(' '))
    print '%d' % (ceil(n/a) * ceil(m/a))

if __name__ == '__main__':
    try:
        main()
    except:
        pass
