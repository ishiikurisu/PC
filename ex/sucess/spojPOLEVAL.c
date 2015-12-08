#include <stdio.h>
#include <stdlib.h>

long horner(long *C, long N, long x, long n)
{
    long r = 0;

    if (n == N)
        r = C[0];
    else
        r = C[N-n] + x*horner(C, N, x, n+1);

    return r;
}

int main(int argc, char const *argv[]) {
    long *C, N, K;
    long x = 0, t = 0, n = 0;

    for (scanf("%ld", &N); N >= 0; scanf("%ld", &N))
    {
        /* setup */
        C = (long*) malloc(sizeof(long) * (N+1));
        for (n = 0; n <= N; ++n)
            scanf("%ld", &x),
            C[n] = x;
        scanf("%d", &K);

        /* draw */
        printf("Case %d:\n", ++t);
        for (n = 0; n < K; ++n)
            scanf("%ld", &x),
            printf("%ld\n", horner(C, N, x, 0));
        free(C);
    }

    return 0;
}
