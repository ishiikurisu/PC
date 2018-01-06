import itertools
import sets
 
__fermat__ = []
__limit__ = 10**6
__memo__ = sets.Set()
 
def modulus(obj):
    big = -1
    for item in obj:
        if item > big: big = item
    return big
 
def fermat_number():
    n = 0
    while True:
        yield 2**(2**n) + 1
        n += 1
 
def gauss_wantzel(inlet):
    global __memo__
    global __fermat__
 
    if inlet in __memo__: return True
    if inlet in __fermat__: return True
 
    fermat = []
    midlet = -1
    k = 0
    d = 2**k
 
    for number in __fermat__:
        if number <= inlet: fermat.append(number)
        else: break
    while d <= inlet and midlet is not inlet:
        for length in range(1 + len(fermat)):
            for sequence in itertools.combinations(fermat, length):
                midlet = d
                for number in sequence:
                    midlet *= number
                __memo__.add(midlet)
     
                if midlet is inlet: return True
        k += 1
        d = 2**k
 
    return False
 
# setup
sequence = fermat_number()
number = sequence.next()
while number < __limit__:
    __fermat__.append(number)
    number = sequence.next()
number = 2
 
while number < __limit__:
    __memo__.add(number)
    number *= 2
gauss_wantzel(__limit__)
 
# draw
T = input()
for t in range(T):
    if input() in __memo__: print 'Yes'
    else: print 'No'
