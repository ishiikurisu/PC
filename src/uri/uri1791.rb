def read_matrix
  $M = []
  $N.times do
    $M << gets.chomp.split(" ").map{ |x| x.to_i }
  end
end

def horizontal
  for y in 0...$N
    l = $M[y]
    l = l.sort{ |a, b| a.abs <=> b.abs }
    m = l[1]
    
    for x in 2...$N
      if m ** x != l[x]
        return false
      end
    end
  end
  true
end

def vertical
  for x in 0...$N
    l = []
    for y in 0...$N
      l << $M[y][x]
    end
    l = l.sort{ |a, b| a.abs <=> b.abs }
    m = l[1]
    
    for y in 2...$N
      if m ** y != l[y]
        return false
      end
    end
  end
  true
end

if __FILE__ == $0
  $C = gets.chomp.to_i
  $C.times do
    $N = gets.chomp.to_i
    read_matrix
    ok = horizontal || vertical
    puts (ok)? "Potencia" : "Nao Potencia"
  end
end