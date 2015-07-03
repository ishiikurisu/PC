import os

# os.system('g++ spojWILLITST.cpp -o spoj.exe -lm -O2')
for T in xrange(100):
    print T
    os.system('echo %d | spojWILLITST.py' % (T))
    #os.system('echo %d | spoj.exe' % (T))
# os.system('del spoj.exe')
