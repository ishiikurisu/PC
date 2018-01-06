def draw(n)
  b = 1
  s = 6

  while b < n
    b += s
    s += 6
  end

  (b == n)? true : false
end

def main()
  n = gets.to_i
  if n < 0
    raise
  else
    puts (draw n)? 'Y' : 'N'
  end
end

loop do
  begin
    main()
  rescue
    break
  end
end
