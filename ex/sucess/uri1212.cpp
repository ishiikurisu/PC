#include <stdlib.h>
#include <math.h>
#include <iostream>
#include <vector>
#define ZERO ("0")
#define BASE (10)
#define max(A,B) (((A)>(B))?(A):(B))
using namespace std;

string m, n;
int limit;

string reverse(string str)
{
    string rev = "";

    for (int i = 0; i < str.length(); ++i)
        rev = str[i] + rev;

    return rev;
}

int rec(int d, int r, int c)
{
    if (d == limit) return c;
    r = ((n[d] - '0') + (m[d] - '0') + r)/BASE;
    return rec(d+1, r, c+r);
}

void setup()
{
    int lem = m.length();
    int len = n.length();

    limit = max(lem, len);
    m = reverse(m);
    n = reverse(n);

    if (len < lem) {
        for (int i = 0; i < lem - len; ++i)
            n = n + ZERO;
    }
    else if (len > lem) {
        for (int j = 0; j < len - lem; ++j)
            m = m + ZERO;
    }
}

void loop()
{
    int result = rec(0, 0, 0);

    if (result == 0)
        cout << "No carry operation." << endl;
    else if (result == 1)
        cout << "1 carry operation." << endl;
    else
        cout << result << " carry operations." << endl;
}

int main(int argc, char const *argv[]) {

    cin >> m >> n;
    while (m.compare(ZERO) || n.compare(ZERO))
    {
        setup();
        loop();
        cin >> m >> n;
    }

    return 0;
}
