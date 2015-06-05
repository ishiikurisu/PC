def main():
    N = input()
    D = raw_input()

    if not 'X' in D:
        return 'S'
    tab = D.split('X')
    for gap in tab:
        if len(gap) >= 3:
            return 'S'
    else:
        return 'N'

if __name__ == '__main__':
    while True:
        try:
            print main()
        except:
            break
