import random

def ordered_input(n):
    line = '%d\n' % (n)
    for i in range(n):
        line += '%d ' % (int(i+1))
    return line

def random_input(n):
    line = '%d\n' % (n)
    for i in range(n):
        line += '%d ' % (int((random.random() * 1000) % (i+1)))
    return line

if __name__ == '__main__':
    for _ in range(500):
        print(random_input(500))
    print(ordered_input(500))
    print(-1)
