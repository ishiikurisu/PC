from math import *
for t in range(0, int(input())):
    first_input = input().split(' ')
    p = int(first_input[0])
    s = int(first_input[1])
    n = int(first_input[2])
    pages = []
    for _ in range(0, n):
        pages.append(floor(int(input())/s))
    os_fifo = []
    rep_fifo = 0
    os_lru = []
    rep_lru = 0
    for page in pages:
        # Replacing in FIFO
        if page not in os_fifo:
            if len(os_fifo) < p:
                os_fifo.append(page)
            else:
                os_fifo.pop(0)
                os_fifo.append(page)
                rep_fifo += 1
        else:
            pass
        # Replacing in LRU
        if page not in os_lru:
            if len(os_lru) < p:
                os_lru.append(page)
            else:
                os_lru.pop(0)
                os_lru.append(page)
                rep_lru += 1
        else:
            os_lru.remove(page)
            os_lru.append(page)
        # print(os_fifo, os_lru)
    print('yes' if rep_fifo > rep_lru else 'no' , rep_fifo,rep_lru)
