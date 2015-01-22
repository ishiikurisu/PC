LIMIT = 2**3
FRACTIONS = [2, 3, 4]
memo = {}

def best_change(number):
    global FRACTIONS
    global LIMIT
    global memo
    change = number

    if memo.has_key(number):
        return memo[number]
    
    for poss in range(LIMIT):
        curr_sum = i = 0
        while (poss >> i) != 0:
            if (poss >> i) & 0x1:
                partial = number/(FRACTIONS[i])
                curr_sum += max(partial, best_change(partial))
            i += 1
        change = max(change, curr_sum)

    memo[number] = change
    return change

def setup():
    global memo

    for x in range(4):
        memo[x] = x

def draw():
    print best_change(input())

if __name__ == '__main__':
    setup()
    while True:
        try:
            draw()
        except:
            break
