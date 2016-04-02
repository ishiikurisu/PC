import re

def setup():
    global low
    global up

    low = set(['j', 'p', 's', 'x', 'b', 'v', 'z'])
    up = set()
    for it in low:
        up.add(it.upper())

def draw():
    global low
    global up

    line = raw_input()
    outlet = str()

    for ch in line:
        if ch in low:
            outlet += 'f'
        elif ch in up:
            outlet += 'F'
        else:
            outlet += ch

    print re.sub(r"f+(F+|h+|H+)?", 'f', re.sub(r"F+(f+|h+|H+)?", 'F', outlet))

if __name__ == '__main__':
    setup()
    while True:
        try:
            draw()
        except:
            break
