#include <iostream>
#include <stdlib.h>
#include <string>
#include <vector>
#define CNS (0)
#define VWL (1)
using namespace std;

bool is_vowel(char in)
{
    bool result = false;
    
    switch (in)
    {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            result = true;
        break;
    }
    
    return result;
}

string option1(string S, int x)
{
    string output;
    
    
    
    return output;
}

string option2(string S, int x)
{
    vector<char> letters;
    string output;
    const char flag = '#';

    int i, j; 
    int sl = S.length();

    for (string::iterator s = S.begin(); s != S.end(); ++s)
        output += *s;
    
    for (i = 0, j = 0; j < x; ++i)
    {
        if (!is_vowel(S[i % sl]))
        {
            letters.push_back(S[i % sl]);
            ++j;
        }
    }

    output[(i - 1) % sl] = flag;
    
    for (j = i; output[j % sl] != flag; ++j)
    {
       if (!is_vowel(S[j % sl]))
       {
           letters.push_back(output[j % sl]);
           output[j % sl] = letters.front();
           letters.erase(letters.begin());
       }
    }

    output[j % sl] = letters[0];
    return output;
}

int main()
{
    int T, t;
    
    string S;
    int Q, q;
    int X, x;
    
    cin >> T;
    for (t = 0; t < T; ++t)
    {
        /* READ */
        cin >> S;
        cin >> Q;
        cout << "Caso #" << (t + 1) << ":" << endl;
        for (q = 0; q < Q; ++q)
        {
            cin >> X;
            switch (X)
            {
                case 0:
                    cin >> x;
                    S = option1(S, x);
                break;
                
                case 1:
                    cin >> x;
                    S = option2(S, x);
                    break;
                
                case 2:
                    cout << S << endl;
                break;
            }
        }
    }

    return 0;
}
