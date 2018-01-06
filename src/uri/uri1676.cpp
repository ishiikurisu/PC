#include <iostream>
#include <stdlib.h>
#include <math.h>
#define LIMIT (3000)
using namespace std;

int* lucky;
int n;

bool is_prime(int input)
{
    bool result = true;
    int limit = (int) sqrt(input);
    int test = 3;

    if (input % 2 == 0)
        return false;

    while (test <= limit && result == true)
    {
        if (input % test == 0)
            result = false;
        else
            test += 2;
    }

    return result;
}

void setup()
{
    int i = 0;
    int number = 7;
    lucky = (int*) malloc(sizeof(int) * LIMIT);

    lucky[0] = 2;
    lucky[1] = 3;
    lucky[2] = 5;
    for (i = 3; i < LIMIT; ++i)
    {
        while (!is_prime(number))
            number += 2;

        lucky[i] = number;
        number += 2;
    }

    for (i = 0; i < LIMIT; ++i)
        cout << lucky[i] << " ";
    cout << endl;
}

void loop()
{
    cout << lucky[n-1] << endl;
}

main()
{
    setup();

    cin >> n;
    while (n > 0)
    {
        loop();
        cin >> n;
    }
}
