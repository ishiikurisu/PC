#include <iostream>
#include <stdlib.h>
#define MOD (1000000007)
using namespace std;

int N, *H, M, K, X;

int process(int* current, int height)
{
    int i, j;

    if (height == X % M)
        return 1;
    if (height > X % M)
        return 0;

    for (i = 0; i < N; ++i)


    return count;
}

main()
{
    int T, t;
    int i, j;
    int* h;

    cin >> T;
    for (t = 0; t < T; ++t)
    {
        cin >> N;
        H = (int*) malloc(sizeof(int) * N);

        for (i = 0; i < N; ++i)
            cin >> H[i];
        cin >> M >> K >> X;
        cout << process(0, 0) << endl;
    }
}
