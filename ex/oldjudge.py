#!c:\python27\python
import time
import sys
import os

CODE    = sys.argv[1]
OS_NAME = 'pc'
LANG    = 'assembly'
UNIX    = 'lin'
WINDOWS = 'win'
CPP     = 'cpp'
C       = 'c'
JAVA    = 'java'
PYTHON  = 'python'

def setup_languages():
    langs = {}

    langs['c']    = C
    langs['cpp']  = CPP
    langs['cxx']  = CPP
    langs['java'] = JAVA
    langs['py']   = PYTHON

    return langs

def setup():
    global LANG
    global OS_NAME
    languages = setup_languages()

    # DISCOVER OS
    if os.name   == 'posix':
        OS_NAME = UNIX
    else:
        OS_NAME = WINDOWS
    # DISCOVER LANGUAGE
    extension = CODE.split('.')[1]
    LANG = languages[extension]

def draw():
    global LANG
    global OS_NAME

    # COMPILE
    command = ''
    if LANG == C:
        output = CODE.split('.')[0] + '.exe'
        command = 'gcc %s -o %s -lm -O2' % (CODE, output)
    elif LANG == CPP:
        output = CODE.split('.')[0] + '.exe'
        command = 'g++ %s -o %s -lm -O2' % (CODE, output)
    elif LANG == JAVA:
        command = 'javac %s' % (CODE)
    elif LANG == PYTHON:
        pass
    os.system(command)

    # RUN APPLICATION
    input = CODE.split('.')[0] + '.in'
    if OS_NAME == UNIX:
        command = 'cat %s | ' % (input)
    else:
        command = 'more %s | ' % (input)
    if LANG == C or LANG == CPP:
        if OS_NAME == UNIX: command += './'
        command += CODE.split('.')[0] + '.exe'
    elif LANG == JAVA:
        command += 'java %s' % (CODE.split('.')[0])
    elif LANG == PYTHON:
        command += 'python %s' % (CODE)
    now = time.time()
    os.system(command)
    print '  %.3fs' % (time.time() - now)

    # DELETE FILES
    if OS_NAME == UNIX:
        command = 'rm '
    else:
        command = 'del '
    if LANG == C or LANG == CPP:
        command += '*.exe'
    elif LANG == JAVA:
        command += '*.class'
    elif LANG == PYTHON:
        command = ''
    os.system(command)

if __name__ == '__main__':
    setup()
    draw()
