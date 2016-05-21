# URI 1998
def not_zeroes? boxes
  boxes.select { |it| it != 0 }.size == 0 ? true : false
end

def rearrange boxes, chosen
  stuff = []

  boxes.each_index do |i|
    box = boxes.at i
    if i < chosen
      stuff.push box+1 
    elsif i == chosen
      stuff.push 0
    else
      stuff.push box 
    end
  end

  stuff
end

def calculate boxes
  result = false

  if not_zeroes? boxes
    return true
  end
  
  boxes.each_index do |i|
    if boxes[i] == i+1
      result = result || calculate(rearrange boxes, i)
    end
  end

  return result
end

def main
  number_boxes = gets.to_i
  while number_boxes >= 0
    boxes = gets.split.map { |it| it.to_i }
    puts "#{(calculate boxes)? "S" : "N"}"
    number_boxes = gets.to_i
  end
end

main
