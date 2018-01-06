#include <stdlib.h>
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int T, t;
    int n, p;

    for (cin >> T, t = 0; t < T; ++t)
    {
        cin >> n;
        p = n;
        for (int i = 2; i*i <= n; ++i) 
        {            
            if (n % i == 0) 
                p -= p / i;
            while (n % i == 0) 
                n /= i;
        }   

        if (n > 1) 
            p -= p / n;

        cout << p << endl;
    }

    return 0;
}
