#include <stdlib.h>
#include <stdio.h>

int numbdays;
int numbpart;
int* hartal;

int* init_var(int* var, int size)
{
  int i;

  for (i = 0; i < size; i++)
  {
    var[i] = 0;
  }

  return var;
}

void process_data()
{
  int* calendar = (int*) malloc(sizeof(int)*numbdays);
  int* counters = (int*) malloc(sizeof(int)*numbpart);
  int day, party, count = 0;

  /*initialize variables*/
  counters = init_var(counters, numbpart);

  /*mark calendar*/
  for (day = 0; day < numbdays; day++)
  {
    calendar[day] = 0;
    for (party = 0; party < numbpart; party++)
    {
      counters[party]++;
      if (counters[party] == hartal[party])
      {
        calendar[day]++;
        counters[party] = 0;
      }
    }
  }

  /*count lost days*/
  count = 0;
  for (day = 0; day < numbdays; day++)
  {
    if (calendar[day]) count++;
  }
  printf("%d\n", count);

  return;
}

int read_data()
{
  int i, j;

  int numbcases;
  scanf("%d", &numbcases);
  if (numbcases == 0)
    return 0;

  for (i = 0; i < numbcases; i++)
  {
    scanf("%d", &numbdays);
    scanf("%d", &numbpart);
    if (numbdays == 0 || numbpart == 0)
      return 0;

    hartal = (int*) malloc(sizeof(int)*numbpart);
    for (j = 0; j < numbpart; j++)
      scanf("%d", &hartal[j]);

    process_data();
  }

  return 1;
}

main()
{
  while(read_data()){}
}
