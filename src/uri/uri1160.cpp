#include <iostream>
using namespace std;

long PA, PB;
double G1, G2;

void setup()
{
    cin >> PA >> PB >> G1 >> G2;
    G1 = (100.0 + G1) / 100.0;
    G2 = (100.0 + G2) / 100.0;
}

void loop()
{
    string output = "Mais de 1 seculo.";
    int time = 0;

    while (PA <= PB && time <= 100)
    {
        PA = (long) PA * G1;
        PB = (long) PB * G2;
        ++time;
    }

    if (time <= 100)
        cout << time << " anos." << endl;
    else
        cout << output << endl;
}

int main()
{
    int T;

    cin >> T;
    for (int t = 0; t < T; ++t)
    {
        setup();
        loop();
    }

    return 0;
}
