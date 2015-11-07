"""
Regras:
+ Tesoura corta papel
+ Papel cobre pedra
+ Pedra derruba lagarto
+ Lagarto adormece Spock
+ Spock derrete tesoura
+ Tesoura prende lagarto
+ Lagarto come papel
+ Papel refuta Spock
+ Spock vaporiza pedra
+ Pedra quebra tesoura
"""

def setup():
    global rules

    rules = dict()
    rules['tesoura'] = set()
    rules['papel'] = set()
    rules['pedra'] = set()
    rules['lagarto'] = set()
    rules['spock'] = set()

    rules['tesoura'].add('papel')
    rules['papel'].add('pedra')
    rules['pedra'].add('lagarto')
    rules['lagarto'].add('spock')
    rules['spock'].add('tesoura')
    rules['tesoura'].add('lagarto')
    rules['lagarto'].add('papel')
    rules['papel'].add('spock')
    rules['spock'].add('pedra')
    rules['pedra'].add('tesoura')

def draw():
    global rules
    rajesh, sheldon = raw_input().split(' ')
    result = 'empate'

    if sheldon in rules[rajesh]:
        result = 'rajesh'
    elif rajesh in rules[sheldon]:
        result = 'sheldon'

    print result

if __name__ == '__main__':
    setup()
    for x in xrange(input()):
        draw()
