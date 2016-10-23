#include "stdlib.h"
#include "stdio.h"
#include "limits.h"
#define min(A,B) (((A)<(B))?(A):(B))

int N, *C;

int loop(int i, int l, int r)
{
    int outlet = 0;

    if (i != N)
        outlet = ((l == C[i]) || (r == C[i]))? loop(i+1, l, r) :
                                               1 + min(loop(i+1, C[i], r),
                                                       loop(i+1, l, C[i]));

    return outlet;
}

int main(int argc, char const *argv[]) {
    int T, t, c;

    scanf("%d", &T);
    for (t = 0; t < T; ++t)
    {
        scanf("%d", &N);
        C = (int*) malloc(sizeof(int) * N);
        for (c = 0; c < N; c++)
        {
            scanf("%d", &C[c]);
        }

        printf("%d\n", loop(0, 0, 0));
        free(C);
    }

    return 0;
}
