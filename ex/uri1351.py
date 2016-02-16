import math

# MODEL
class Product:
  def __init__(self, kind, price):
    self.kind = kind
    self.price = price

  def get_kind(self):
    return self.kind

  def get_price(self):
    return self.price

def new_memo(m, n):
  return [[None]*n]*m

# VIEW
def read_many_int():
  return map(int, raw_input().split(' '))

def read_product():
  line = raw_input().split(' ')
  return Product(int(line[0]), float(line[1]))

def write_result():
  global memo
  result = memo[0][0]

  # print memo
  if math.isnan(result):
    print 'Impossible'
  else:
    print '%.2f' % (result)

# CONTROLLER
def dynammic(i, j):
  global memo
  global shoplist
  global market
  global size_itens
  global size_market

  if j == size_itens:
    return 0.0
  elif i == size_market:
    return float('nan')
  elif memo[i][j] is not None:
    return memo[i][j]

  if shoplist[j] == market[i].get_kind():
    memo[i][j] = min(market[i].get_price() + dynammic(i+1, j+1),
                     dynammic(i+1, j))
  else:
    memo[i][j] = dynammic(i+1, j)

  return memo[i][j]

def next_iter(i, j):
  n = lambda x: 0 if x <= 1 else x-1
  return n(i), n(j)

# MAIN FUNCTIONS
def setup():
  global shoplist
  global market
  global size_itens
  global size_market

  size_itens, size_market = read_many_int()
  if size_itens == 0 and size_market == 0:
    raise StandardError

  shoplist = read_many_int()
  market = list()
  for _ in xrange(size_market):
    market.append(read_product())

def draw():
  global shoplist
  global market
  global size_itens
  global size_market
  global memo

  memo = new_memo(size_market, size_itens)

  dynammic(0, 0) # or
  i, j = size_market-1, size_itens-1
  while i > 0 or j > 0:
    dynammic(i, j)
    i, j = next_iter(i, j)

  write_result()

# Output:
#   21.30
#   2.50
#   Impossible
#   25.72
#   60.05
#   61.27

if __name__ == '__main__':
  while True:
    try:
      setup()
      draw()
    except:
      break
