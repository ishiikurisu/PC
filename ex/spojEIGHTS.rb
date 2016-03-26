def setup()
	$t = gets.to_i
	$ft = []
	a = -2
	
	for k in 0...200000
		a += (i % 2 == 0)? 3 : 2
		$ft << a
	end
end
	
def draw()
	$k = gets.to_i
	
	if $k % 2 == 0
		puts "#{$ft[$k-1]}42"
	else
		puts "#{$ft[$k-1]}92"
	end
end

setup()
$t.times do
	draw()
end