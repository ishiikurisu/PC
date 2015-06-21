#include <stdlib.h>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int NG, NM;
vector<int> GG;
vector<int> MM;

vector<int> read(int size)
{
    vector<int> output;
    int input;

    for (int i = 0; i < size; ++i)
    {
        cin >> input;
        output.push_back(input);
    }

    return output;
}

void setup()
{
    cin >> NG >> NM;
    GG = read(NG);
    MM = read(NM);

    sort(GG.begin(), GG.end());
    sort(MM.begin(), MM.end());
}

string draw()
{
    string result = "uncertain";
    int godzilla = 0;
    int mechagod = 0;
    int g = 0, m = 0;

    if (NG == 0 && NM == 0)
        return result;

    while (g < NG && m < NM)
        if (GG[g] >= MM[m])
            m++;
        else
            g++;

    if (g < NG)
        result = "Godzilla";
    else
        result = "MechaGodzilla";

    return result;
}

main()
{
    int T, t;

    cin >> T;
    for (t = 0; t < T; ++t)
    {
        setup();
        cout << draw() << endl;
    }
}
