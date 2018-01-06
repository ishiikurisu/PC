def walk(phone, tree, index):
    if index == len(phone):
        return 0

    digit = phone[index]
    if tree.has_key(digit):
        return walk(phone, tree[digit], index+1) + 1
    else:
        tree[digit] = {}
        return walk(phone, tree[digit], index+1)

def run(phone, book):
    tree = book
    economy = 0

    for digit in phone:
        if tree.has_key(digit):
            economy += 1
        else:
            tree[digit] = {}
        tree = tree[digit]

    return economy

def setup():
    global phones

    phones = []
    for x in xrange(int(raw_input())):
        phones.append(raw_input())

def draw():
    global phones

    book = {}
    economy = 0

    for phone in phones:
        # economy += walk(phone, book, 0)
        economy += run(phone, book)

    print(economy)

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
