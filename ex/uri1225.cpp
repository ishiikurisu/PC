#include <stdlib.h>
#include <iostream>
#include <vector>
using namespace std;

int N;
vector<long> coral;
vector<long> ending;

bool check(int i, int j)
{
    if (i < j && i < N && j >= 0)
        return true;
    else
        return false;
}

bool equals(vector<long> n, vector<long> m)
{
    int limit = n.size();
    bool result = true;

    for (size_t i = 0; i < limit && result; i++) {
        if (n[i] != m[i]) {
            result = false;
        }
    }

    return result;
}

void setup() {
    long n, m;
    long S = 0;

    for (long i = 0; i < N; ++i)
    {
        cin >> n;
        coral.push_back(n);
        S += n;
    }

    m = S / N;
    for (long j = 0; j < N; ++j)
        ending.push_back(m);

}

void loop() {
    int i = 0;
    int j = N - 1;
    long c = 0;

    while (check(i, j))
    {
        while (ending[i] == coral[i] && check(i, j))
            ++i;
        while (ending[j] == coral[j] && check(i, j))
            --j;

        if (i < j) {
            --ending[i];
            ++ending[j];
            c++;
        }
    }

    if (equals(coral, ending)) {
        c++;
    }
    else {
        c = -1;
    }

    cout << c << endl;
    coral.clear();
    ending.clear();
}

int main(int argc, char const *argv[]) {
    while (cin >> N)
    {
        setup();
        loop();
    }

    return 0;
}
