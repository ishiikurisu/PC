def min_index(cards):
    index, floor = 0, cards[0]
    for i, card in enumerate(cards):
        if card < floor:
            index, floor = i, card
    return floor

def remove_with_min(players, cards):
    how_many = len(players)
    hand = cards[:how_many]
    remaining = list()
    limit = 0

    try:
        limit = min_index(hand)
    except:
        return remaining

    for i, card in enumerate(hand):
        if card is not limit:
            remaining.append(players[i])
    return remaining

def draw(players, cards):
    remaining = remove_with_min(players, cards)
    how_many = len(remaining)
    if how_many is 0:
        return ' '.join(players)
    elif how_many is 1:
        return remaining[0]
    else:
        return draw(remaining, cards[how_many+1:])

def main():
    assert input() is not 0
    players, cards = raw_input().split(' '), []
    for _ in xrange(4):
        for card in map(int, raw_input().split(' ')):
            cards.append(card)
    print draw(players, cards)

if __name__ == '__main__':
    while True:
        try:
            main()
        except:
            break
