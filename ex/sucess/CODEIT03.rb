def setup
	raw = gets.chomp.split " "
	raw.map {|x| x.to_i}
	$inlet = Time.gm raw[2], raw[1], raw[0]
end
def draw
	if $inlet.monday?
		puts 'Monday'
	elsif $inlet.tuesday?
		puts 'Tuesday'
	elsif $inlet.wednesday?
		puts 'Wednesday'
	elsif $inlet.thursday?
		puts 'Thursday'
	elsif $inlet.friday?
		puts 'Friday'
	elsif $inlet.saturday?
		puts 'Saturday'
	else puts 'Sunday'
	end
end

$n = gets.to_i
($n-1).times do
	setup
	draw
	puts
end
setup
draw
