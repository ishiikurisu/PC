def couple(a, b):
  return a * a - b * b

def is_couple(inlet):
  outlet = str()
  a = 2
  b = a - 1
  sum = couple(a, b)

  while sum < inlet:
    while b >= 0:
      sum = couple(a, b)
      if sum >= inlet: break
      else: b -= 1
      # print locals()
    if sum is not inlet:
      a += 1
      b = a - 1
      sum = couple(a, b)
    # print locals()

  if sum == inlet:
    outlet = '%d %d' % (a, b)
  elif inlet % 2 == 0:
    outlet = 'Bachelor Number.'
  else:
    outlet = 'Spinster Number.'

  return outlet

def process(number):
  return is_couple(number)

def count(start, end):
  outlet = 0

  for number in xrange(start, end):
    result = is_couple(number)
    try:
      _ = int(result.split(' ')[0])
    except:
      outlet += 1

  return outlet

if __name__ == '__main__':
  while True:
    try:
      inlet = raw_input()
      try:
        print process(int(inlet))
      except:
        n1, n2 = map(int, inlet.split(' '))
        print count(n1, n2 + 1)
    except:
      raise
      break
