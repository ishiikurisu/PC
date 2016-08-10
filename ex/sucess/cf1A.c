#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main(int argc, char const *argv[]) {
    double n, m, a, x;


    while (scanf("%d %d %d\n", &n, &m, &a)) {
        printf("%d %d ", ceil(n/a), ceil(m/a));
        x = ceil(n/a) * ceil(m/a);
        printf("%d\n", x);
    }

    return 0;
}
