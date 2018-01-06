require 'matrix'

def cramer(matrix, vars)
    det = matrix.det
    cols = matrix.to_a.transpose
    cols.each_index.map do |i|
        c = cols.dup
        c[i] = vars
        Matrix.columns(c).det/det
    end
end

def ok? answer
    fact = (answer.reduce(:+) == 0)? false : true
    answer.each { |it| fact = ((it < 0) || ((it % 1) != 0))? false : fact }
    fact
end

def main
    props = Matrix[
        [0.0, 1.0,  6.0],
        [2.0,  0.0,  12.0],
        [1.0,  2.0,  6.0],
    ]

    inlet = gets.split(' ').map { |it| it.to_i }
    outlet = cramer(props, inlet)
    if ok? outlet
        outlet.map{ |e| e.to_i.to_s }.reduce{ |box, it| (box.length > 0)? box + " #{it}" : it }
    else
        'Error'
    end
end

if __FILE__ == $0
    loop do
        begin
            puts main
        rescue
            break
        end
    end
end
