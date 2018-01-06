#include "iostream"
using namespace std;

int recur(int best_average, int current_strike, int best_strike, int N)
{
    int current_average;

    // cout << N << ": " << best_average << " " << current_strike << " " << best_strike << endl;

    if (!N) {
        if (current_strike > best_strike)
            best_strike = current_strike;
        return best_strike;
    }

    cin >> current_average;
    if (current_average == best_average) {
        return recur(best_average, current_strike+1, best_strike, N-1);
    }
    else if (current_average > best_average) {
        return recur(current_average, 1, 1, N-1);
    }
    else {
        return recur(best_average,
                     0,
                     (current_strike > best_strike)? current_strike : best_strike,
                     N-1);
    }

}

int loop(int N)
{
    return recur(-1, 0, 0, N);
}

int main(int argc, char const *argv[])
{
    int T, N;

    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        cout << "Caso #" << t << ": " << loop(N) << endl;
    }

    return 0;
}
