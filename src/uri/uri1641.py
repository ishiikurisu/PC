def main(argv):
    global pizza
    R, W, L = map(int, argv)

    result = True
    outlet = 'Pizza %d ' % (pizza)

    w = W * 0.5
    l = L * 0.5
    if R < (w**2 + l**2) ** 0.5:
        result = False

    if result:
        outlet += 'fits on the table.'
    else:
        outlet += 'does not fit on the table.'
    return outlet

if __name__ == '__main__':
    pizza = 1
    while True:
        try:
            print main(raw_input().split(' '))
            pizza += 1
        except:
            break
