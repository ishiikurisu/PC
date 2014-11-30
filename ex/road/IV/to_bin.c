#include <stdio.h>

main()
{
	int inlet;
	int outlet;
	int digit = 0;
	int flag = 1;

	scanf("%d", &inlet);

	outlet = 0;
	while ((inlet >> digit) > 0)
	{
		if (digit > 0 && outlet == 0)
			outlet = 10;
		else
			outlet *= 10;
			
		if ((inlet >> digit) & 0x1)
			++outlet;
		++digit;
	}

	if (inlet % 2 == 0)
		outlet--;
	printf("%d\n", outlet);
}
