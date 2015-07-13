def rec(line, stack, street):
    global stdline

    print line
    if len(street) == len(stdline):
        if street == stdline:
            return True
        else:
            return False

    truck = line.pop(0)
    result = rec(line, stack.insert(0, truck), street)
    result = result or rec(line, stack, street.append(truck))

    return result

def main():
    global stdline

    n = input()
    if n == 0: raise StandardError

    stdline = [i+1 for i in xrange(n)]
    line = map(int, raw_input().split(' '))
    if rec(line, [], []):
        return 'yes'
    else:
        return 'no'

if __name__ == '__main__':
    print main()
    while True:
        try:
            print main()
        except:
            break
