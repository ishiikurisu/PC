#include <stdio.h>
#include <math.h>

main()
{
	float distance;
	int x[2], y[2];
	int i;

	for (i = 0; i < 2; i++)
		scanf("%d %d", &x[i], &y[i]);

	distance = sqrt(pow(x[1]-x[0], 2)+pow(y[1]-y[0], 2));
	printf("%.4f\n", distance);
}
