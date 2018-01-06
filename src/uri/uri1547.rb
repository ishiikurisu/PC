def abs x
	x >= 0? x : -x
end

gets.to_i.times do
	line = gets.chomp.split
	answer = line[1].to_i
	tries = gets.chomp.split.map { |it| it.to_i }	
	diff, chosen = 1000, 1
	tries.each_index do |i|
		it = tries[i]
		dist = abs(it - answer)
		if dist == 0
			chosen = i+1
			break
		elsif dist < diff
			diff = dist
			chosen = i+1
		end
	end
	puts chosen
end
