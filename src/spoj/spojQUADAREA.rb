def read
  gets.split(/\s+/).map{|x| x.to_f}
end

def sqrt a
  Math.sqrt a.to_f
end

def brahmagupta a, b, c, d
  s = (a + b + c + d)/2.0
  sqrt (s-a)*(s-b)*(s-c)*(s-d)
end

gets.to_i.times do
  arr = read
  a = arr[0]
  b = arr[1]
  c = arr[2]
  d = arr[3]
  puts "%.2f" % brahmagupta(a,b,c,d)
end
