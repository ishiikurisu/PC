#include <stdio.h>
#include <vector>

void write(std::vector<char> v)
{
    std::vector<char>::iterator it;

    for (it = v.begin(); it != v.end(); it++)
    {
        printf("%c ", *it);
    }

    printf("...\n");
}

std::vector<char> fuck(std::vector<char> v)
{
    v[0] = 'F';
    return v;
}

int main(int argc, char const *argv[]) {
    std::vector<char> v;

    v.push_back('a');
    v.push_back('b');
    v.push_back('c');
    v.push_back('d');
    v.push_back('e');
    v.push_back('f');

    while (v.size() > 0)
    {
        write(fuck(v));
        write(v);
        v = std::vector<char>(v.begin()+1, v.end());
    }

    write(v);
    return 0;
}
