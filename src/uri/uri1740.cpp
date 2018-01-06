#include <iostream>
#include <cstdlib>
#include <vector>
using namespace std;

vector<long> a;
int n, q;

string process(int lower, int upper) {
    int target = upper - lower;
    int nondec = 0;
    int noninc = 0;
    int alleql = 0;

    for (size_t i = lower; i < upper; i++) {
        if (a[i] == a[i+1]) {
            ++alleql;
        }
        if (a[i] <= a[i+1]) {
            ++nondec;
        }
        else if (a[i] >= a[i+1]) {
            ++noninc;
        }
    }

    if (alleql == target)
        return "ALL EQUAL";
    else if (nondec == target)
        return "NON DECREASING";
    else if (noninc == target)
        return "NON INCREASING";
    else
        return "NONE";
}

void setup() {
    long x;

    for (size_t m = 0; m < n; m++) {
        cin >> x;
        a.push_back(x);
    }
}

void loop() {
    int i, x, y;
    long u;

    cin >> i;
    switch (i) {
        case 0:
            cin >> x >> y;
            --x; --y;
            u = a[x];
            a[x] = a[y];
            a[y] = u;
        break;

        case 1:
            cin >> x >> u;
            a[x-1] = u;
        break;

        case 2:
            cin >> x >> u;
            a.insert(a.begin()+(x-1), u);
        break;

        case 3:
            cin >> x;
            a.erase(a.begin()+(x-1));
        break;

        default:
            cin >> x >> y;
            cout << process(x-1, y-1) << endl;
    }
}

int main(int argc, char const *argv[]) {
    while (cin >> n) {
        setup();
        cin >> q;
        for (size_t m = 0; m < q; m++) {
            loop();
        }
        a.clear();
    }

    return 0;
}
