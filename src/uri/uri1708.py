from math import ceil

def main(argv):
    vx, vy = sx, sy = map(lambda n: 1.0/n, map(int, argv))
    o = 1

    while sx < sy + 1:
        sx += vx
        sy += vy
        o += 1
        
    print int(ceil(o*vx))

if __name__ == '__main__':
    while True:
        try:
            main(raw_input().split(' '))
        except:
            break
