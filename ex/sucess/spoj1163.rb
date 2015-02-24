ANY_UP = '[A-Z]'
UNDER = "_"
ERROR = 'Error!'

def fail()
	c1 = $inlet.match(ANY_UP) && $inlet.match(UNDER)
	c2 = $inlet[0].match(ANY_UP)
	c3 = $inlet.match(UNDER + UNDER)
	c4 = $inlet[-1].match(UNDER) || $inlet[0].match(UNDER)
	c1 || c2 || c3 || c4
end

def to_cpp
	outlet = ""

	$inlet.chars do |ch|
		if ch.match ANY_UP
			outlet << "_#{ch.downcase}"
		else
			outlet << ch
		end
	end

	return outlet
end

def to_java
	outlet = ""
	flag = false

	while $inlet[0].match UNDER
		$inlet = $inlet[1..$inlet.length]
	end

	$inlet.each_char do |char|
		if char === UNDER
			flag = true
		elsif flag == true
			outlet.concat(char.upcase)
			flag = false
		else
			outlet.concat(char)
		end
	end

	return outlet
end

loop do
	begin
		$inlet = gets.chomp
		puts fail()? ERROR : $inlet.match(ANY_UP)? to_cpp : to_java
	rescue
		break
	end
end
