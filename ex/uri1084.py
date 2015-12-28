1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
def read():
    return map(int, raw_input().split(' '))

def setup():
    inlet = raw_input()
    outlet = []

    for ch in inlet:
        outlet.append(int(ch))

    return outlet

def biggest_from(index, added):
    global inlet
    global D
    result = index
    biggest = inlet[index]
    i = index + 1

    while i <= D + added:
        if inlet[i] > biggest:
            result = i
            biggest = inlet[i]
        i += 1

    return result

def process():
    global inlet
    global N
    global D
    result = 0
    index = 0
    added = 0

    while added < N - D:
        index = biggest_from(index, added)
        # print '  %d: %d' % (index, inlet[index])
        result = result * 10 + inlet[index]

        index += 1
        added += 1

    return result

def main():
    global N
    global D
    global inlet

    N, D = read()
    while N != 0 and D != 0:
        inlet = setup()
        print process()
        N, D = read()

if __name__ == '__main__':
    main()
