require "yaml"

class Judge
  def initialize(src, txt)
    @src = src
    @txt = txt
    @config = YAML.load File.read('./config.yml')
  end
  
  def run
    ext = @src.split('.')[-1]
    lang = @config['available'][ext]
    cmds = @config['about'][lang]
    
    if (cmds['kind'] == 'compiled') || (cmds['kind'] == 'vm')
      `#{cmds['build'].gsub('{0}', @src)}`
    end
    
    exe = (cmds['kind'] == 'vm')? 
      cmds['run'].gsub('{0}', @src.gsub('.java', '')) : 
      cmds['run'].gsub('{0}', @src)
    puts `more #{@txt} | #{exe}`
    
    
    if cmds['kind'] == 'compiled'
      `#{clean = cmds['clean'].gsub('{0}', @src)}`
    end
  end
end

if __FILE__ == $0 
  # parsing CLI args
  src_script = ARGV[0]
  txt_script = src_script.split('.')[0...-1].join('.') + '.in'
  if ARGV.length > 1
    txt_script = ARGV[1]
  end
  
  # executing
  judge = Judge.new src_script, txt_script
  judge.run
end