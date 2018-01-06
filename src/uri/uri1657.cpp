#include <stdlib.h>
#include <iostream>
#include <vector>
using namespace std;

vector<string> dict;

void setup()
{
    int N, n;
    string input = NULL;

    for (cin >> N, n = 0; n < N; ++n)
    {
        getline(cin, input);
        dict.push_back(input);
    }
}
void loop()
{
    string input;
    string output;

    getline(cin, input);
    /* what the fuck do I do now? */
    cout << output << endl;
}


int main(int argc, char const *argv[])
{
    int Q, q;

    setup();
    for (cin >> Q, q = 0; q < Q; ++q)
        loop();

    return 0;
}
