def pass
end

def organize arr
  arr.sort.reverse
end

def setup()
  $no_counters = gets.to_i
  $counters = organize gets.split(/\s+/).map{|x| x.to_i}
  $no_nuggets = gets.to_i
end

def draw()
  nn = $no_nuggets
  ss = $counters
  cc = 0 # cost

  while nn > 0
      break if ss[0] == 0
      cc += ss[0]
      ss[0] -= 1
      ss = organize ss if ss[0] < ss[1]
      nn -= 1
  end

  puts (nn == 0)? cc : -1
end

gets.to_i.times do
  setup()
  draw()
end
