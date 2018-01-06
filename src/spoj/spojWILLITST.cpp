#include <iostream>
#include <set>
using namespace std;

int main(int argc, char const *argv[]) {
    unsigned long long n;
    set<unsigned long long> m;

    for (cin >> n; n > 1 && !m.count(n); m.insert(n), n = (n % 2 == 0)? n/2 : 3*n+3);

    if (n > 1) cout << "NIE" << endl;
    else cout << "TAK" << endl;

    return 0;
}
