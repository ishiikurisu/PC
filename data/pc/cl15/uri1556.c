#include <stdio.h>
#include <stdlib.h>
#define WORD_LENGTH (1000)

main()
{
	int i;
	char c;

	srand(WORD_LENGTH);
	for (i = 0; i < WORD_LENGTH; ++i)
	{
		c = (rand() % ('z' - 'a')) + 'a';
		printf("%c", c);
	}

	printf("\n");
}
