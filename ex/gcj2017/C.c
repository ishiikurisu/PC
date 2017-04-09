#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void think(int N, int K, int* M, int *m)
{
    int i, j, k;
    bool *S = (bool*) malloc(sizeof(bool) * N);

    for (i = 0; i < N; i++) { S[i] = false; }

    for (;;)
    {
        
    }

}


int main(int argc, char const *argv[]) {
    int t, T, N, K, M, m;

    for (t = 1; t <= T; t++)
    {
        scanf("%d %d", &N, &K);
        (N <= K)? M = m = 0: think(N, K, &M, &m);
        printf("case #%d: %d %d\n", t, M, n)
    }

    return 0;
}
