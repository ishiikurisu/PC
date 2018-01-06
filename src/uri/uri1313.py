from string import ascii_lowercase as letters

def read():
    return map(int, raw_input().split(' '))

def size(trie):
    result = len(trie)
    for it in trie:
        result += size(trie[it])
    return result

def iterative_add(trie, word, index):
    if index == len(word):
        return trie

    letter = word[index]
    if letter not in trie:
        trie[letter] = {}
    trie[letter] = iterative_add(trie[letter], word, index+1)

    return trie

def iterative_frequency(trie, count, level):
    for it in trie:
        if level > 0:
            count[it] += 1
        count = iterative_frequency(trie[it], count, level + 1)

    return count

def frequency(trie):
    count = {}
    for letter in letters:
        count[letter] = 0
    return iterative_frequency(trie, count, 0)

def setup():
    global portuguese
    global spanish

    P, S = read()
    if P == 0 and S == 0:
        raise StandardError

    portuguese = []
    spanish = []

    for p in xrange(P):
        portuguese.append(raw_input())
    for s in xrange(S):
        spanish.append(raw_input()[::-1])

def draw():
    global portuguese
    global spanish

    prefix = {}
    suffix = {}
    for word in portuguese:
        prefix = iterative_add(prefix, word, 0)
    for word in spanish:
        suffix = iterative_add(suffix, word, 0)

    return process(prefix, suffix)

def process(prefix, suffix):
    prefreq = frequency(prefix)
    suffreq = frequency(suffix)

    repetitions = 0
    for letter in letters:
        repetitions += prefreq[letter] * suffreq[letter]

    return (size(prefix)*size(suffix) - repetitions)

if __name__ == '__main__':
    while True:
        try:
            setup()
            print draw()
        except:
            break
