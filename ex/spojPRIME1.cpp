#include <bits/stdc++.h>
#define LIMIT 1000000000
using namespace std;

bool *primes = NULL;

void setup(unsigned long long n)
{
    int i = 0;

    primes = (bool*) malloc(sizeof(bool) * (n + 1));
    for (i = 0; i <= n; primes[i] = true, ++i);
    primes[0] = primes[1] = false;

    for (i = 2; i < sqrt(n) + 1; ++i)
    {
        if (primes[i] == true)
            for (int j = 2; j < n / i + 1; ++j)
                primes[i*j] = false;
    }
}

void loop(unsigned long long m, unsigned long long n)
{
    for (int i = m; i <= n; ++i)
        if (primes[i] == true)
            cout << i << endl;
}

int main(int argc, char const *argv[]) {
    int N, n;
    unsigned long long a, z;

    setup(LIMIT);
    for (cin >> N, n = 0; N > n; ++n)
    {
        cin >> a >> z;
        if (n != 0)
            cout << endl;
        loop(a, z);
    }

    return 0;
}
