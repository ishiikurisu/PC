def maior(a, b):
    return (a + b + abs(a - b))/2
 
if __name__ == '__main__':
    inlet = raw_input()
    numbers = inlet.split(' ')
    biggest = int(numbers[0])
     
    for number in numbers:
        biggest = maior(biggest, int(number))
    print "%i eh o maior" % biggest
