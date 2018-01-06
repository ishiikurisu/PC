#include <stdlib.h>
#include <iostream>
#include <vector>
using namespace std;

int N;
long mean;
vector<long> coral;

void setup() {
    long n;
    long S = 0;

    mean = 0;
    for (long i = 0; i < N; ++i)
    {
        cin >> n;
        coral.push_back(n);
        S += n;
    }

    mean = S / N;
}

void loop() {
    long c = 1;
    long d = 0;
    long e = 0;

    for (int i = 0; i < N; ++i)
    {
        e = mean - coral[i];
        c += (coral[i] < mean)? e : 0;
        d += e;
    }

    if (d == 0)
        cout << c << endl;
    else
        cout << -1 << endl;
    coral.clear();
}

int main(int argc, char const *argv[]) {
    while (cin >> N)
    {
        setup();
        loop();
    }

    return 0;
}
