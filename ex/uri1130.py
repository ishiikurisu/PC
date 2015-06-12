def main():
    N = input()
    D = raw_input()
    R = 'N'

    A = D.split('X')
    B = ''
    for it in A:
        B += it
    if len(B) % 2 != 0:
        R = 'S'

    return R

if __name__ == '__main__':
    while True:
        try:
            print main()
        except:
            break
