import re

talk = 0
shit = 0
bingo = set()
not_letters = re.compile('[^a-zA-Z]')

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)

def setup():
    global talk
    global shit
    global bingo
    global not_letters

    for word in not_letters.split(raw_input()):
        if word:
            word = word.upper()
            if word == 'BULLSHIT':
                talk += len(bingo)
                shit += 1
                bingo = set()
            elif word not in bingo:
                bingo.add(word)

def draw():
    global talk
    global shit

    g = 0
    if talk > shit:
        g = gcd(talk, shit)
    else:
        g = gcd(shit, talk)
    if g == 0:
        print '1 / 1'
    else:
        print '%d / %d' % (talk / g, shit / g)

if __name__ == '__main__':
    while True:
        try:
            setup()
        except:
            draw()
            break
