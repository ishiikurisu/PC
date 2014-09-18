#include <stdlib.h>
#include <stdio.h>

int* sample;
int size;

int read_data()
{
	int i;

	scanf("%d", &size);
	if (size == 0)
		return 0;

	sample = (int*) malloc(sizeof(int)*size);
	for (i = 0; i < size; i++)
	{
		scanf("%d", &sample[i]);
	}

	return 1;
}

int process_data()
{
	int flag = 1;
	int diff;
	int i;

	if (size == 1) return flag;

	diff = sample[1] - sample[0];
	if (diff < 0) diff = -diff;
	for (i = 1; i < size - 1 && flag; i++)
	{
		if (sample[i+1] - sample[i] != diff - 1 &&
		sample[i+1] - sample[i] != 1 - diff)
			flag--;
		else
			diff--;
	}

	return flag;
}

void write_data(int result)
{
	if (result)
		printf("Jolly\n");
	else
		printf("Not jolly\n");
}

main()
{
	while(read_data())
	{
		write_data(process_data());
	}
}
