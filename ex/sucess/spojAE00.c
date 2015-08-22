#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int Q(int n)
{
    int out = 0;
    int i = 0;

    for (i = 2; i < sqrt(n); ++i)
        out += (n % i == 0)? 1 : 0;

    return out;
}

int S(int n)
{
    if (n == 1)
        return 0;

    int f = (int) floor(sqrt(n));

    if (f*f == n)
        return 1;
    else
        return 0;
}

int R(int N)
{
    int out = N;
    int i;

    for (i = 1; i <= N; ++i)
    {
        out += Q(i) + S(i);
    }

    return out;
}

int main(int argc, char const *argv[]) {
    int N = 0;
    scanf("%d", &N);
    printf("%d\n", R(N));
    return 0;
}
