def is_even(n):
    if n % 2 == 0:
        return True
    else:
        return False

def setup():
    global even
    global odd

    even = []
    odd = []

    for N in xrange(input()):
        n = input()
        if is_even(n):
            even.append(n)
        else:
            odd.append(n)

def draw():
    global even
    global odd

    even.sort()
    odd = sorted(odd, reverse = True)
    for it in even:
        print it
    for it in odd:
        print it

def main():
    setup()
    draw()

if __name__ == '__main__':
    while True:
        try:
            main()
        except:
            break
