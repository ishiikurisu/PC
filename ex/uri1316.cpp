#include <iostream>
#include <stdlib.h>
using namespace std;
 
int M, L, N, *C;

void setup()
{
    cin >> N;
    C = malloc(sizeof(int) * N);
    for (int c = 0; c < N; cin >> C[c], c++);
}

void loop()
{

}

int main()
{
    cin >> M >> L;
    while (M != 0 && L != 0)
    {
        setup();
        loop();
        cin >> M >> L;
    }
 
    return 0;
}
