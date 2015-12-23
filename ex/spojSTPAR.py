def deal(truck, line, p = 0):
	if len(line) > 0:
		if truck == line[p]:
			return True
	return False

def exchange(line, side):
	flag = True

	if (len(side) == 0) and (len(line) > 0): # can add to empty side from line
		side.append(line.pop(0))
	elif (len(line) > 0) and (len(side) > 0): # can add to side from line
		if line[0] < side[-1]:
			side.append(line.pop(0))
		else:
			flag = False
	else:
		flag = False

	return flag

def main(line):
	side = list()
	result = 'no'
	truck = 1
	wanted = len(line)+1

	while truck is not wanted:
		# print 'line:', line, 'side:', side
		if deal(truck, line):
			line.pop(0)
			truck += 1
		elif deal(truck, side, -1):
			side.pop()
			truck += 1
		elif not exchange(line, side):
			break
	else:
		result = 'yes'

	print result

if __name__ == '__main__':
	n = int(raw_input())
	while n > 0:
		main(map(int, raw_input().split(' ')))
		n = int(raw_input())
