def is_vowel(letter):
    return letter in 'AEIOUY'

def main(arg):
    biggest = 1
    current = 1

    for letter in arg:
        if is_vowel(letter):
            biggest = current if current > biggest else biggest
            current = 1
        else:
            current += 1
    biggest = current if current > biggest else biggest

    return biggest

if __name__ == '__main__':
    while True:
        try:
            print(main(input()))
        except:
            break
