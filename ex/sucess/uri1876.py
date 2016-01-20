def main(arg):
    papers = arg.split('x')
    limit = len(papers) - 1
    out = max(len(papers[0]), len(papers[limit]))

    for i in xrange(1, limit):
        it = len(papers[i])/2
        if it > out:
            out = it

    return out

if __name__ == '__main__':
    while True:
        try:
            print main(raw_input())
        except:
            break
