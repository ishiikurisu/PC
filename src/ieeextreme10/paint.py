def new_memo():
    global N

    memo = []
    for _ in range(N+1):
        matrix = []
        for _ in range(21):
            line = []
            for _ in range(21):
                line.append(-1)
            matrix.append(line)
        memo.append(matrix)

    return memo

def dp(i, b1, b2):
    global N
    global C
    global memo

    # corner cases
    if i == N:
        return 0
    if memo[i][b1][b2] >= 0:
        return memo[i][b1][b2]

    # average case
    outlet = N+10
    if (C[i] == b1) or (C[i] == b2): # actual color is in state
        outlet = dp(i+1, b1, b2)
    else: # we need to change the color
        outlet = 1 + min(dp(i+1, b1, C[i]), dp(i+1, b2, C[i]))

    memo[i][b1][b2] = memo[i][b2][b1] = outlet
    return outlet


def main():
    global N
    global C
    global memo

    # load
    N = int(input())
    C = []
    for c in input().split(' '):
        C.append(int(c))

    # loop
    memo = new_memo()
    return dp(0, 0, 0)


if __name__ == '__main__':
    for _ in range(int(input())):
        print(main())
