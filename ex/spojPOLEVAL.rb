$n = 0
$c = []
$t = 0

def evaluate x
    s = 0
    i = $n
    while i >= 0
        s += $c[i] * (x**i)
        i -= 1
    end
    return s
end

def main
    $n = gets.to_i
    $c = []

    return false if $n < 0 else $t += 1
    puts "Case #{$t}:"
    for c in gets.chomp.split " "
        $c << c.to_i
    end
    k = gets.to_i
    for x in gets.chomp.split(" ")
        puts "#{evaluate x.to_i}"
    end
    return true
end

while main
end
