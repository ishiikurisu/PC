#include <iostream>
using namespace std;

unsigned long long tricount(unsigned long long N)
{
    unsigned long long s = N*N;

    for (unsigned long long i = 1; i < N; ++i)
    {
        s += i * (N-1);
    }

    return s;
}

int main(int argc, char const *argv[])
{
    unsigned long long T, N, t;

    cin >> T;
    for (t = 0; t < T; ++t)
    {
        cin >> N;
        cout << tricount(N) << endl;
    }

    return 0;
}
