import re

talk = 0
shit = 0
blah = 0

ALL_LETTERS = """
for i in xrange(0, 256):
    print '%d: %s' % (i, chr(i))
"""

def is_alpha(word):
    if re.match('[a-zA-Z]', word):
        return True
    else:
        return False

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)

def setup():
    global talk
    global shit
    global blah

    not_letters = re.compile('[^a-zA-Z\x2D]')
    for word in not_letters.split(raw_input()):
        if word and is_alpha(word):
            if word == 'BULLSHIT':
                talk += blah
                shit += 1
                blah = 0
            else:
                blah += 1

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
