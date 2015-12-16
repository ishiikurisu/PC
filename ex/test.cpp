#include <stdlib.h>
#include <iostream>
#include <map>
using namespace std;

void func(map<char, char> *ptr) {
    (*ptr)['c'] = 'c';
    (*ptr)['j'] = 'j';
}

int main(int argc, char const *argv[]) {
    void *ptr;

    ptr = new map<char, char>();
    func((map<char, char>*) ptr);

    return 0;
}
