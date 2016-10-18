import sys

def load(filename):
    text = ''

    with open(filename, 'r') as fp:
        text = fp.read().split('\n')

    return text

def diff(a, b):
    limit = min(len(a), len(b))
    diffs = {}

    # Smaller file
    if len(a) != len(b):
        if len(a) > len(b):
            diffs['smaller'] = 'b'
        else:
            diffs['smaller'] = 'a'

    # Checking for line differences
    diffs['lines'] = []
    for i in range(limit):
        if a[i] != b[i]:
            diffs['lines'].append(i+1)

    return diffs

def report(diffs):
    print('---')
    print('Different lines:')
    for line in diffs['lines']:
        print('- {0}'.format(line))
    print('...')

if __name__ == '__main__':
    input1 = load(sys.argv[1])
    input2 = load(sys.argv[2])
    diffs = diff(input1, input2)
    report(diffs)
