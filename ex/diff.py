import os

def load(filename):
    return nil

def diff(a, b):
    return nil

def report(diffs):
    pass

if __name__ == '__main__':
    input1 = load(os.args[1])
    input2 = load(os.args[2])
    diffs = diff(input1, input2)
    report(diffs)
