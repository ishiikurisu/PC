def main(arg):
    data = set()
    for it in arg:
        data.add(it)
    outlet = 'CHAT WITH HER!'
    if len(data) % 2 != 0:
        outlet = 'IGNORE HIM!'
    return outlet

if __name__ == '__main__':
    while True:
        try:
            print main(raw_input())
        except:
            break
