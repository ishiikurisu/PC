def setup():
    global costs
    global avg
    n = int(raw_input())

    if n == 0:
        raise EOFError
    else:
        costs = list()
        avg = int()
    for i in xrange(n):
        cost = int(float(raw_input()) * 100)
        avg += cost
        costs.append(cost)
    avg /= n
    costs.sort()

def draw():
    global costs
    global avg
    diff = int()

    for cost in costs:
        if cost >= avg:
            break
        else:
            diff += avg - cost

    print '$%.2lf' % (diff / 100.0)

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
