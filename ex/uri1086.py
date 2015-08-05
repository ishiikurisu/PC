alt = int()
prf = int()
lar = int()
ntb = int()
tab = list()

def setup():
    alt, prf = map(int, raw_input().split(' '))
    lar = int(raw_input())
    ntb = int(raw_input())
    tab = sorted(map(int, raw_input().split(' ')), reverse = True)
    qtd = {}

    for t in qtd:
        if t not in qtd:
            qtd[t] = 0
        qtd[t] += 1

def draw():
    a = (alt * 100) % lar
    b = (prf * 100) % lar

    if (a != 0) and (b != 0):
        return 'impossible'

    
    return n

if __name__ == '__main__':
    while True:
        try:
            setup()
            print draw()
        except Exception as e:
            break
