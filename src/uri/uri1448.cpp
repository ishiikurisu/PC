#include <iostream>
#include <sstream>
#include <stdlib.h>
using namespace std;

string ref, t1, t2;

void setup()
{
    getline(cin, ref);
    getline(cin, t1);
    getline(cin, t2);
}

void loop()
{
    int a1 = -1;
    int a2 = -1;
    int e1 = -1;
    int e2 = -1;
    int c1 = 0;
    int c2 = 0;

    for (int i = 0; i < ref.length(); ++i)
    {
        if (ref[i] == t1[i]) {
            a1 = (a1 < 0)? i : a1;
            c1++;
        }
        else {
            e1 = (e1 < 0)? i : e1;
        }

        if (ref[i] == t2[i]) {
            a2 = (a2 < 0)? i : a2;
            c2++;
        }
        else {
            e2 = (e2 < 0)? i : e2;
        }

        if (e1 == e2) {
            e1 = e2 = -1;
        }
    }

    // cout << c1 << " " << a1 << " x " << c2 << " " << a2 << ": ";

    if (c1 > c2) {
        cout << "time 1";
    }
    else if (c2 > c1) {
        cout << "time 2";
    }
    else {
        if (a1 < a2)
            cout << "time 1";
        else if (a2 < a1)
            cout << "time 2";
        else {
            if (e1 > e2)
                cout << "time 1";
            else if (e2 > e1)
                cout << "time 2";
            else
                cout << "empate";
        }
    }

    cout << endl;
}

int main(int argc, char const *argv[]) {
    string inlet;
    int T, t;

    getline(cin, inlet);
    stringstream(inlet) >> T;
    for (t = 1; t <= T; ++t)
    {
        cout << "Instancia " << t << endl;
        setup();
        loop();
        cout << endl;
    }

    return 0;
}
