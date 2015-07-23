def rec(i, j, s):
    global C
    if i > j:
        return 0
    elif i + 1 == j:
        return s

    a = rec(i + 1, j - 1, C[i])
    b = rec(i + 1, j - 1, C[j])
    c = rec(i + 2, j, C[i])
    d = rec(i, j - 2, C[j])

    return max(a, b, c, d) + s

def main():
    global C

    N = int(raw_input())
    C = map(int, raw_input().split(' '))
    return rec(0, N - 1, 0)

if __name__ == '__main__':
    while True:
        try:
            print main()
        except:
            break
