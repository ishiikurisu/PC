$n = 0
$c = []
$t = 0

def b n, x
    if n == $n
        $c[0]
    else
        $c[$n-n] + x*b(n+1, x)
    end
end

def evaluate x
    b(0, x)
end

loop do
    $n = gets.to_i
    $c = []

    if $n < 0
        break
    else
        $t += 1
    end

    # setup
    for c in gets.chomp.split " "
        $c << c.to_i
    end
    k = gets.to_i

    #draw
    puts "Case #{$t}:"
    for x in gets.chomp.split(" ")
        puts "#{evaluate x.to_i}"
    end
end
