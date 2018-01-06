#include <iostream>
#include <stdlib.h>
#include <vector>
#define END false
#define HOME true
using namespace std;

string inlet;
vector<char> outlet;

void setup()
{
    bool toggle = END;
    int offset = 0;

    for (int c = 0; c < inlet.length(); c++)
    {
        char ch = inlet[c];
        switch (ch)
        {
            case '[':
            toggle = true;
            offset = 0;
            break;

            case ']':
            toggle = false;
            break;

            default:
            if (toggle == HOME) {
                outlet.insert(outlet.begin() + offset, ch);
                offset++;
            }
            else
                outlet.push_back(ch);
        }
    }
}

void draw()
{
    vector<char>::iterator it;
    string output = "";

    for (it = outlet.begin(); it != outlet.end(); ++it)
        output += *it;

    cout << output << endl;
    outlet.clear();
}

int main()
{
    while (getline(cin, inlet))
    {
        setup();
        draw();
    }

    return 0;
}
