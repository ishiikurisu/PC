def min_index(cards):
    index, min = 0, cards[0]
    for i, card in enumerate(cards):
        if card < min:
            index, min = i, card
    return index

def draw(players, cards):
    if len(players) == 1:
        return players[0]
    else:
        players.pop(min_index(cards[0:len(players)]))
        return draw(players, cards[len(players):])

def main():
    assert input() is not 0
    players, cards = raw_input().split(' '), []
    for _ in xrange(4):
        for card in map(int, raw_input().split(' ')):
            cards.append(card)
    print draw(players, cards)

if __name__ == '__main__':
    while True:
        try: main()
        except: break
