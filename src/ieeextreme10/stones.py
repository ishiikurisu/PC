def main():
    # setup
    G = int(input())
    games = []
    for _ in range(G):
        number_piles = int(input())
        pile = list(map(int, input().split(' ')))
        games.append(pile)

    # loop
    no_rounds = 0
    for game in games:
        no_rounds += play(game)

    print('Bob' if no_rounds % 2 == 0 else 'Alice')

def play(game):
    no_rounds = 0

    for pile in game:
        no_rounds += (pile-1) / 2

    return no_rounds

def playable(game):
    return len(list(filter(lambda x: x > 1, game))) > 0

if __name__ == '__main__':
    for _ in range(int(input())):
        main()
