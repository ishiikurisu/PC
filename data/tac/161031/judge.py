#!c:\python27\python
import os
import sys
import time
import json

UNIX = 'LINUX'
WINDOWS = 'WINDOWS'

def execute(command):
    os.system(command)

def compile(LANG, CODE, OS_NAME):
    type = LANG['type']
    command = ''

    if type == 'binary':
        output = CODE.split('.')[0] + '.exe'
        command = LANG['compile'] % (CODE, output)
    elif type == 'compiled':
        command = LANG['compile'] % (CODE)

    execute(command)

def run(LANG, CODE, OS_NAME):
    type = LANG['type']
    input = CODE.split('.')[0] + '.in'
    command = ''

    if OS_NAME == UNIX:
        command = 'cat %s | ' % (input)
    else:
        command = 'more %s | ' % (input)

    if type == 'binary':
        if OS_NAME == UNIX: command += './'
        command += CODE.split('.')[0] + '.exe'
    elif type == 'compiled':
        command += LANG['run'] % (CODE.split('.')[0])
    elif type == 'interpreted':
        command += LANG['run'] % (CODE)

    print('--- # judging')
    now = time.time()
    execute(command)
    print('... # %.3fs' % (time.time() - now))

def delete(LANG, CODE, OS_NAME):
    command = 'rm ' if OS_NAME == UNIX else 'del '
    type = LANG['type']

    if type == 'binary' or type == 'compiled':
        command += LANG['delete']
        execute(command)

def setup():
    global LANG
    global CODE
    global OS_NAME

    # DISCOVER OS
    if os.name == 'posix':
        OS_NAME = UNIX
    else:
        OS_NAME = WINDOWS

    # DISCOVER LANGUAGE
    CODE = sys.argv[1]
    extension = CODE.split('.')[1]

    # OPEN CONFIG FILE
    jsonfp = open('judge.json', 'r')
    options = json.load(jsonfp)
    LANG = options['languages'][extension]
    LANG = options[LANG]
    jsonfp.close()

def draw():
    global LANG
    global CODE
    global OS_NAME

    compile(LANG, CODE, OS_NAME)
    run(LANG, CODE, OS_NAME)
    delete(LANG, CODE, OS_NAME)

if __name__ == '__main__':
    setup()
    draw()
