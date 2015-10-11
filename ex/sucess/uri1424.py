N = M = 0

def setup():
	global N
	global M
	global memo

	N, M = map(int, raw_input().split(' '))
	memo = {}
	line = raw_input().split(' ')
	for i, it in enumerate(line):
		if it not in memo:
			memo[it] = []
		memo[it].append(i+1)

def draw():
	global memo
	line = raw_input().split(' ')
	k = int(line[0]) - 1
	v = line[1]
	r = 0

	if v in memo:
		n = memo[v]
		if k >= 0 and k < len(n):
			r = n[k]
	return r

if __name__ == '__main__':
	while True:
		try:
			setup()
			for m in xrange(M):
				print draw()
		except:
			break
