#include <stdio.h>
#include <math.h>

int p(int z)
{
    int i;
    for (i = 2; i <= sqrt(z)+1; ++i) if (z % i == 0) return 0;
    return 1;
}

int main()
{
    int n, m;
    scanf("%d",&n);
    if (n >= 2) for(m = 1; p(n*m+1); m++);
    else m = 3;
    printf("%d\n", m);
    return 0;
}
