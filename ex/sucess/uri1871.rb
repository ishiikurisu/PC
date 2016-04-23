loop do
    inlet = gets.split.each { |x| x.to_i }
    a, b, o = inlet[0].to_i, inlet[1].to_i, ""
    break if a == 0 and b == 0
    (a + b).to_s.each_char { |ch| o += ch if ch != '0' }
    puts o
end
