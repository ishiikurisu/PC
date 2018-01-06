def read():
    return input().split(' ')

def count(s):
    while len(s) > 1:
        s = str(sum(map(int, s)))
    return int(s)

if __name__ == '__main__':
    a, b = read()
    while (a != '0') or (b != '0'):
        a = count(a)
        b = count(b)
        print(1 if a > b else 2 if a < b else 0)
        a, b = read()
