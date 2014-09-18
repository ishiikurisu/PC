def compile code
  app = code.chomp(".java")

  system "gcj #{code} --main=#{app} -o #{app}.o"
end

ARGV.each do |code|
  compile code
end
