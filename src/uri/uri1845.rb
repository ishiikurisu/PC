require 'set'

# setup
low = Set.new ['j', 'p', 's', 'x']
up = Set.new
low.each { |c| up << c.capitalize }

# draw
while line = gets
    outlet = ''
    line.chomp.each_char do |ch|
        if up.include? ch
            outlet << 'F'
        elsif low.include? ch
            outlet << 'f'
        else
            outlet << ch
        end
    end
    outlet.gsub! /f+/,  'f'
    puts outlet
end
