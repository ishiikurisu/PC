#include <stdlib.h>
#include <iostream>
#define LIMIT 10002
using namespace std;

int box[LIMIT];
int N;

void setup()
{
    int i, j, x, y;

    for (i = 0; i < LIMIT; ++i)
        box[i] = 0;

    for (i = 0; i < N; ++i)
    {
        cin >> x >> y;
        for (j = x; j <= y; ++j)
            box[j]++;
    }

}

void loop()
{
    int Q, i;
    int b = 0;

    cin >> Q;
    for (i = 1; i < Q; ++i)
    {
        b += box[i];
    }

    cout << Q;
    if (box[Q] == 0)
        cout << " not found";
    else
        cout << " found from " << b << " to " << b + box[Q] - 1;
    cout << endl;
}

int main(int argc, char const *argv[])
{
    while (cin >> N)
    {
        setup();
        loop();
    }

    return 0;
}
