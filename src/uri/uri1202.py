def fib(n):
    if n <= 2:
        return 1
    a, b = 1, 2
    for i in xrange(3, n):
        a, b = b, a + b
    return b

def main():
    inlet = int(raw_input(), 2)
    print '%03d' % (fib(inlet) % 1000)

if __name__ == '__main__':
    for T in xrange(int(raw_input())):
        main()
