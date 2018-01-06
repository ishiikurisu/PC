class Participant:
    def __init__(self, name):
        self.name = name

def read_input():
    entry = raw_input()

    while entry != 'FIM':
        # TODO read data
        entry = raw_input()

if __name__ == '__main__':
    participants = read_input()
