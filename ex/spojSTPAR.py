def deal(truck, line):
	result = True

	if len(line) > 0:
		if truck == line[-1]:
			line.pop()
			truck += 1
	else:
		result = False

	return result

def main(line):
	line = list()
	side = list()
	parade = list()
	result = 'no'
	wanted = 1

	while len(line) > 0 and len(side) > 0:
		if not (deal(wanted, line) and deal(wanted, side)):
			if len(line) > 0:
				side.append(line.pop())
			else:
				break
	else:
		result = 'yes'

	print result

if __name__ == '__main__':
	n = input()
	while n > 0:
		main(map(int, raw_input().split(' ')).reverse())
		n = input()
