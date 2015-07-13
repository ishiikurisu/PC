#include <iostream>
#include <stdlib.h>
#include <vector>
#define LIMIT 1000002
using namespace std;

unsigned long long n, m;
vector<unsigned long long> memo[LIMIT];

void setup()
{
    unsigned long long i, j, k;

    for (i = 1; i <= n; ++i)
    {
        cin >> j;
        memo[j].push_back(i);
    }
}

void loop()
{
    unsigned long long k, v;

    cin >> k >> v;

    if (memo[v].size() >= k && memo[v].size() > 0)
        cout << memo[v][k-1] << endl;
    else
        cout << 0 << endl;
}

void clear()
{
    for (int i = 0; i < LIMIT; i++) {
        memo[i].clear();
    }
}

main()
{
    while (cin >> n >> m)
    {
        setup();
        for (int i = 0; i < m; ++i)
            loop();
        clear();
    }
}
