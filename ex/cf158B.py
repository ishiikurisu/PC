def main():
  how_many = int(raw_input())
  groups = map(int, raw_input().split(' '))
  taxi = taxis = 0
  
  groups.sort()
  for group in groups:
    # taxis
    if taxi + group >= 4:
      taxis += 1
    # taxi
    future = taxi + group
    if future > 4:
      taxi = group
    elif future == 4:
      taxi = 0
    else:
      taxi = future
  return taxis

if __name__ == '__main__':
  while True:
    try:
      print main()
    except:
      break