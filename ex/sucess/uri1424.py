N = M = 0
memo = {}

def setup():
    N, M = map(int, raw_input().split(' '))
    line = raw_input().split(' ')
    for i, it in enumerate(line):
        if it not in memo:
            memo[it] = []
        memo[it].append(i+1)

def draw():
    line = raw_input().split(' ')
    k = int(line[0])
    v = line[1]
    r = 0

    if v in memo:
        try:
            r = memo[v][k-1]
        except:
            pass
    return r

if __name__ == '__main__':
    setup()
    while True:
        try:
            print draw()
        except:
            break
