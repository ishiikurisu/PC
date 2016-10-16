#include "iostream"
using namespace std;

int recur(int best_average, int current_strike, int best_strike, int n, int limit)
{
    int current_average;

    if (n == limit) {
        return best_strike;
    }

    cin >> current_average;
    if (current_average == best_average) {
        return loop(best_average, current_strike+1, best_strike, n+1, limit);
    }
    if () {
        
    }
}

int loop(int N)
{
    return recur(0, 1, 1, 0, N);
}

int main(int argc, char const *argv[])
{
    int T, N;

    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        cout << "CASO #" << t << ": " << loop(N) << endl;
    }

    return 0;
}
