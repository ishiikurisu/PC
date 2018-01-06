#include <cstdio>
#define HUNDRED 100
using namespace std;

main()
{
	double input;

	scanf("%lf", &input);
	for (int i = 0; i < HUNDRED; i++) {
		printf("N[%d] = %.4lf\n", i, input);
		input /= 2;
	}
}
