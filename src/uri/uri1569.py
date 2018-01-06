def main():
    ladders = {}
    position = []
    dice = []
    line_count = 0
    winner = False

    # read data
    line = raw_input().split(' ')
    number_players = int(line[0])
    number_stairs = int(line[1])
    number_dice = int(line[2])
    for s in xrange(number_stairs):
        line = raw_input().split(' ')
        top = int(line[0])
        bottom = int(line[1])
        ladders[top] = bottom
    for d in xrange(number_dice):
        dice.append(int(raw_input()))

    # process data
    for p in range(number_players):
        position.append(1)

    while line_count < number_dice and not winner:
        die = dice[line_count]
        player = line_count % number_players
        position[player] += die

        while ladders.has_key(position[player]):
            position[player] = ladders[position[player]]

        if position[player] >= 100:
            winner = True
            position[player] = 100

        line_count += 1

    #write data
    player = 1
    for p in position:
        print 'Position of player {} is {}.'.format(player, p)
        player += 1

if __name__ == '__main__':
    while True:
        try:
            nc = input()
            for c in range(nc):
                main()
        except:
            break
