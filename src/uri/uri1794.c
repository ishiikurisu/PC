#include <stdio.h>
#include <stdbool.h>

bool possible(int n, int a, int b) {
    return (n >= a && n <= b)? true: false;
}

int main(int argc, char const *argv[]) {
    int N;
    int LA, LB;
    int SA, SB;

    scanf("%d", &N);
    scanf("%d %d", &LA, &LB);
    scanf("%d %d", &SA, &SB);

    if (possible(N, LA, LB) && possible(N, SA, SB)) {
        printf("possivel\n");
    }
    else {
        printf("impossivel\n");
    }

    return 0;
}
