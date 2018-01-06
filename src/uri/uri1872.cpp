#include <iostream>
using namespace std;

bool palindrome(string inlet) {
    bool result = true;
    int i = 0, j = inlet.length()-1;

    for ( ; i <= j && result; i++, j--) {
        if (inlet.at(i) != inlet.at(j)) {
            result = false;
        }
    }

    return result;
}

string process(string inlet) {
    if (palindrome(inlet)) {
        return "0";
    }

    
}

int main(int argc, char const *argv[]) {
    int C;
    string inlet;

    for (cin >> C, size_t c = 0; c < C; c++) {
        cin >> inlet;
        cout << process(inlet) << endl;
    }

    return 0;
}
