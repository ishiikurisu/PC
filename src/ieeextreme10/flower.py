from math import *

def main(arg):
    return ceil(1 + 2*(arg  - pow(2, floor(log(arg, 2)))))

if __name__ == '__main__':
    for _ in range(int(input())):
        print(main(int(input())))
