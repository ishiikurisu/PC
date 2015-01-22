def new_list(size):
    l = []
 
    for n in range(size):
        l.append(n+1)
 
    return l
 
WELLINGTON = 13
 
inlet = input()
while inlet is not 0:
    outlet = 0
    key = False
 
    while key is False:
        l = new_list(inlet)
        i = 0
 
        while len(l) is not 1:
            l.pop(i)
            i = (i + outlet) % len(l)
 
        if l[0] is WELLINGTON:
            key = True
        outlet += 1
 
    print outlet
    inlet = input()
