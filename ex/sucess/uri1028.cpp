#include <stdlib.h>
#include <iostream>
using namespace std;

int gcd(int a, int b)
{
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}

main()
{
    int N, n;
    int F1, F2;

    cin >> N;
    for (n = 0; n < N; ++n)
    {
        cin >> F1 >> F2;
        cout << gcd(F1, F2) << endl;
    }
}
