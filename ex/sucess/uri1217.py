number_days = input()
spent = 0
weight = 0
 
for day in range(number_days):
    spent += input()
    fruits = raw_input()
     
    fruits = fruits.split()
    number_fruits = len(fruits)
    weight += number_fruits
     
    print 'day {}: {} kg'.format(day+1, number_fruits)
 
print '%.2f kg by day' % (float(weight)/number_days)
print 'R$ %.2f by day' % (spent/number_days)
