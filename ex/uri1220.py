def setup():
    global costs
    global avg
    n = int(raw_input())

    if n == 0:
        raise EOFError
    else:
        costs = list()
        avg = float()
    for i in xrange(n):
        cost = float(raw_input())
        avg += cost
        costs.append(cost)
    avg = float(int(avg / n * 100) / 100.0)
    costs.sort()

def draw():
    global costs
    global avg
    diff = float()

    for cost in costs:
        if cost >= avg:
            break
        else:
            diff += avg - cost

    print '$%.2lf' % (diff)

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
