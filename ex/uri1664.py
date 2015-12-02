import re

talk = 0
shit = 0
blah = 0

def is_word(word):
    for letter in word:
        if re.match('[A-Za-z]', letter):
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

    not_letters = re.compile('^[:alpha:]*$')
    for word in not_letters.split(raw_input()):
        print word
        if word == 'BULLSHIT':
            talk += blah
            shit += 1
            blah = 0
        else:
            blah += 1

def draw():
    global talk
    global shit

    g = gcd(talk, shit)
    print '%d / %d' % (talk / g, shit / g)

if __name__ == '__main__':
    while True:
        try:
            setup()
        except:
            draw()
            raise
