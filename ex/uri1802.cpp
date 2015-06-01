#include <stdlib.h>
#include <iostream>
using namespace std;

int* P;
int* M;
int* F;
int* Q;
int* B;
int K;

int* read()
{
    int P;
    int* v;

    cin >> P;
    v = (int*) malloc(sizeof(int) * (P + 1));
    v[0] = P;
    for (int i = 1; i <= P; ++i)
        cin >> v[i];

    return v;
}

void setup()
{
    P = read();
    M = read();
    F = read();
    Q = read();
    B = read();
    cin >> K;
}

void loop()
{

}

int main()
{
    setup();
    loop();

    return 0;
}
