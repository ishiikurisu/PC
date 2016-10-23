def main(args):
    n = int(args[0])
    name = args[1]

    return len(loop(n, name))

def loop(n, name):
    stuff = set()

    for i in range(1, n+1):
        stuff += npali(i, name)

    return stuff

def npali(n, word):
    stuff = set()

    for i in range(0, n):
        new_word = build(word, i)
        if pali(word):
            stuff.add(new_word)
        stuff += npali(0, new_word)

    return stuff


def build(w, i):
    nw = ''
    for j, it in enumerate(w):
        if j == len(w) -1-i:
            nw += w[i]
        else:
            nw += it
    return nw

def pali(word):
    fact = True
    i = 0

    while i <= len(word)/2:
        fact &= word[i] is word[-1-i]
        i += 1

    return fact

if __name__ == '__main__':
    for _ in range(int(input())):
        print(main(input().split(' ')))
