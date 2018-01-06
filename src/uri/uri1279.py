import sys

first_case = True

def cat(s):
    sys.stdout.write(s)

def leap(year):
    result = False

    if (year % 4 == 0 and not year % 100 == 0) ^ (year % 400 == 0):
        result = True

    return result

def hulu(year):
    if year % 15 == 0:
        return True
    else:
        return False

def bulu(year, leapyear):
    if leapyear == True and year % 55 == 0:
        return True
    else:
        return False

def setup():
    global year

    year = raw_input()
    year = int(year)

def draw():
    global year
    global first_case

    if first_case:
        first_case = False
    else:
        print ''

    is_leap = leap(year)
    is_hulu = hulu(year)
    is_bulu = bulu(year, is_leap)

    if not is_leap and not is_hulu and not is_bulu:
        print 'This is an ordinary year.'
    else:
        if is_leap: print 'This is leap year.'
        if is_hulu: print 'This is huluculu festival year.'
        if is_bulu: print 'This is bulukulu festival year.'

if __name__ == '__main__':
    while True:
        try:
            setup()
            draw()
        except:
            break
