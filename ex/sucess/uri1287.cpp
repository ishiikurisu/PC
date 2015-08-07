#include <iostream>
#include <sstream>
#include <stdlib.h>
#include <limits.h>
using namespace std;

void pass(void) { return; }

int main(int argc, char const *argv[]) {
    long long int result;
    string inlet;
    string outlet;

    while (getline(cin, inlet))
    {
        outlet = "";

        for (int i = 0; i < inlet.length(); ++i)
        {
            switch (inlet[i])
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    outlet += inlet[i];
                break;

                case 'O':
                case 'o':
                    outlet += '0';
                break;

                case 'l':
                    outlet += '1';
                break;

                case ',':
                case ' ':
                    pass();
                break;

                default:
                    outlet = "";
                    i = inlet.length();
                    break;
            }
        }

        stringstream(outlet) >> result;
        if (outlet.length() == 0 || result > LONG_MAX)
            cout << "error";
        else
            cout << result;
        cout << endl;
    }

    return 0;
}
