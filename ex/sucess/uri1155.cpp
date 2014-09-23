#include <cstdio>

main()
{
	float sum = 0;
	int i;
	for (i = 1; i <= 100; ++i) sum += 1.0/i;
	printf("%.2f\n", sum);	
}
