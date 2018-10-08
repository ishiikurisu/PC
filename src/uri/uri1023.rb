def evaluate xy
  avg = xy.map{ |x, y| y }.sum / xy.map{ |x, y| x }.sum
  xy = xy.sort{ |a, b| (a[1]/a[0]) <=> (b[1]/b[0]) }.map{ |a| [a[0].to_i, (a[1]/a[0]).to_i] }
  out = []
  cx = xy[0][0]
  cy = xy[0][1]
  xy.drop(1).each do |x, y|
    if cy == y
      cx += x
    else
      out << [cx, cy]
      cx = x
      cy = y
    end
  end
  if out.length == 0
    out << [cx, cy]
  elsif out[-1][1] == cy
    out[-1][0] += cx
  else
    out << [cx, cy]
  end

  return out, avg
end

if __FILE__ == $0
  $n = gets.chomp.to_i
  case_number = 0
  while $n > 0
    if $n == 1
      xy = gets.chomp.split(" ").map{ |x| x.to_f }
      avg = xy[1]/xy[0]
      out = [[xy[0].to_i, (xy[1]/xy[0]).to_i]]
    else
      xy = []
      $n.times do
        xy << gets.chomp.split(" ").map{ |x| x.to_f }
      end
      out, avg = evaluate xy
    end

    case_number += 1
    if case_number > 1
      puts ''
    end
    puts 'Cidade# %d:' % case_number
    puts out.map{ |a| "%d-%d" % a }.join(" ")
    puts "Consumo medio: %.2fm3."  % avg

    $n = gets.chomp.to_i
  end
end