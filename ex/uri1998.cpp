#include "iostream"
#include "vector"
using namespace std;

int N;

/* UTILITIES */
void write(vector<int> P) {
    vector<int>::iterator p;

    for (p = P.begin(); p != P.end(); p++)
        cout << (*p) << " ";
    cout << endl;
}

/* RULE FUNCTIONS */

bool zeroes(vector<int> P) {
    int n = 0;

    for (int i = 0; i < N; ++i)
        n += (P[i] == 0)? 1 : 0;

    return n == N;
}

vector<int> rearrange(vector<int> inlet, int chosen) {
    vector<int> outlet;

    for (int i = 0; i < N; ++i)
        if (i < chosen)
            outlet.push_back(inlet.at(i) + 1);
        else if (i == chosen)
            outlet.push_back(0);
        else
            outlet.push_back(inlet.at(i));

    return outlet;
}

bool recur(vector<int> P) {
    bool result = false;

    // write(P);
    if (zeroes(P))
        result = true;
    for (int i = 0; i < N && !result; ++i)
        result = (P[i] == i+1)? result || recur(rearrange(P, i)) : result;

    return result;
}

int main(int argc, char const *argv[]) {
    vector<int> P;

    cin >> N;
    while (N >= 0) {
        int p;
        for (int n = 0; n < N; n++) {
            cin >> p;
            P.push_back(p);
        }

        cout << ((recur(P))? "S" : "N") << endl;
        P.clear();
        cin >> N;
    }

    return 0;
}
