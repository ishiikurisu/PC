#include "stdlib.h"
#include "stdio.h"
#include "stdbool.h"

int* update(int N, int *P, int n) {
    int *nP = (int*) malloc(sizeof(int) * N);
    int i;

    for (i = 0; i < N; ++i) {
        nP[i] = (i < n)? 1+P[i] : (i == n)? 0 : P[i];
    }

    return nP;
}

bool play(int N, int *P) {
    bool e = true;
    bool r = false;
    int i;

    for (i = 0; (i < N) && (!r); ++i) {
        if (P[i] == i+1) {
            int *nP = update(N, P, i);
            r |= play(N, nP);
            free(nP);
        }
        else if (P[i] > i+1) {
            return false;
        }
        if (P[i] > 0) {
            e = false;
        }
    }

    return (e)? true : r;
}

int main(int argc, char const *argv[]) {
    int N;
    int *P;
    int i;

    scanf("%d", &N);
    while (N >= 1) {
        P = (int*) malloc(sizeof(int)*N);
        for (i = 0; i < N; ++i) {
            scanf("%d", &P[i]);
        }
        printf("%c\n", (play(N, P))? 'S' : 'N');
        free(P);
        scanf("%d", &N);
    }

    return 0;
}
