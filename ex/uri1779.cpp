#include "iostream"
using namespace std;

int loop(int N) {
    int m = 0, c = 1, p;

    cin >> p;
    for (int n = 0; n < N; n++) {
        if (p == m) c++; else c = 1;
        if (p > m) m = p;
        cin >> p;
    }

    return c;
}

int main(int argc, char const *argv[]) {
    int T, N;

    cin >> T;
    for (int t = 0; t < T; t++) {
        cin >> N;
        cout << loop(N) << endl;
    }

    return 0;
}
