#include <iostream>
#include <stdlib.h>
using namespace std;

main()
{
    int T, t, i;
    int a, b, c;

    cin >> T;
    for (t = 0; t < T; ++t)
    {
        cin >> a >> b;
        c = 1;

        for (i = 0; i < b && c; ++i)
            c = (c * a) % 10;

        cout << c << endl;
    }
}
