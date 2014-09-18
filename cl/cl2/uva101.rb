$stacks = []

module MOVE
  def MOVE.over stack_a, stack_b
    $stacks[stack_a] << $stacks[stack_b].pop
  end

  def MOVE.other stack_a
    $stacks[stack_a] << $stacks[stack_b]
    $stacks[stack_b].clear
  end
end

module PILE
  def PILE.over stack_a, block_b
    $stack[stack_a] << block_b
  end
end

def define_size
  size = Integer(gets.chomp)
  for i in 0..size
    $stacks << []
    $stacks[i] << i + 1
  end
end

def read_actions
  while true
    action = gets.chomp
    break if action == "quit"

    action = action.split " "
    action[1] = Integer(action[1])
    action[3] = Integer(action[3])
    case action[0]
    when "move"
      if action[2] == "over"
        MOVE.over action[1], action[3]
      else
        MOVE.other action[1], action[3]
      end
    when "pile"
      if action[2] == "over"
        PILE.over action[1], action[3]
      else
        PILE.other action[1], action[3]
      end
    end
  end
end

def write_results
  i = 1
  $stacks.each do |stack|
    print "#{i}: "
    stack.each do |block|
      print "#{block} "
    end
    puts " "
    i += 1
  end
end

define_size
read_actions
write_results
