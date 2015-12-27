def main(line):
	side = list()
	result = 'no'
	truck = 1
	wanted = len(line)+1

	for order in line:
		while len(side) > 0 and side[-1] == truck:
			truck += 1
			side.pop()
		if order is truck:
			truck += 1
		elif len(side) > 0 and side[-1] < order:
			break
		else:
			side.append(order)
	else:
		result = 'yes'

	print result

if __name__ == '__main__':
	n = int(raw_input())
	while n > 0:
		main(map(int, raw_input().split(' ')))
		n = int(raw_input())
