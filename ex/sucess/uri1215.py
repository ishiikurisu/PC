from re import split

def update(group, line):
	if line:
		for it in split('[^a-zA-Z]', line):
			group.add(it.lower())
	return group

def setup():
	global andy

	andy = set()
	while True:
		try:
			andy = update(andy, raw_input())
		except:
			break

def draw():
	global andy

	for word in sorted(andy):
		if word:
			print word

if __name__ == '__main__':
	setup()
	draw()
