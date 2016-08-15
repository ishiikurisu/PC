def main():
  how_many = int(raw_input())
  groups = map(int, raw_input().split(' '))
  kinds = [0]*4
  taxis = 0
  for group in groups:
    kinds[group-1] += 1
  # grouping 2s and 1s into 4s
  while (kinds[0] > 1) and (kinds[1] > 0):
    kinds[-1] += 1
    kinds[1] -= 1
    kinds[0] -= 2
  # grouping 2s and 1s into 3s
  while (kinds[0] > 0) and (kinds[1] > 0):
    kinds[2] += 1
    kinds[1] -= 1
    kinds[0] -= 1
  # grouping 3s and 1s
  for _ in xrange(min(kinds[0], kinds[2])):
    kinds[3] += 1
    kinds[0] -= 1
    kinds[2] -= 1
  # summing everyone
  for kind in kinds:
    taxis += kind

  return taxis

if __name__ == '__main__':
  while True:
    try:
      print main()
    except:
      break
