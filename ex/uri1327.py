def draw(names, cards):
    while True:
        hands = cards[0:len(names)]
        cards = cards[len(names):-1]
        if len(hands):
            floor = min(hands)
        else:
            break
        next_names = []
        for i, hand in enumerate(hands):
            if hands[i] > floor:
                next_names.append(names[i])
        # print('{0} {2} {1}'.format(floor, names, hands))
        if len(next_names) is 0:
            next_names = names
            break
        else:
            names = next_names
    return ' '.join(names)

def main():
    assert int(input()) is not 0
    names = input().split(' ')
    cards = list()
    for _ in range(4):
        for card in map(int, input().split(' ')):
            cards.append(card)
    print(draw(names, cards))

if __name__ == '__main__':
    while True:
        try:
            main()
        except:
            break
