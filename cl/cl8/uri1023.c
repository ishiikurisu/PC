#include <stdlib.h>
#include <stdio.h>

int amount;
int* numRes;
int* totCon;
int cityCont = 0;
float medium;

int read()
{
  int flag = 1;
  int i;

  scanf("%d", &amount);
  if (amount == 0)
    flag--;
  else
  {
    numRes = (int*) malloc(sizeof(int)*amount);
    totCon = (int*) malloc(sizeof(int)*amount);
    for (i = 0; i < amount; i++)
    {
      scanf("%d", &numRes[i]);
      scanf("%d", &totCon[i]);

      medium += totCon[i];
      totCon[i] /= numRes[i];
    }
  }

  return flag;
}


void process()
{
  float total_con = 0;
  int total_cit = 0;
  int flag = 1;
  int temp;
  int i;

  for (i = 0; i < amount; i++)
  {
    total_con += totCon[i];
    total_cit += numRes[i];
  }
  medium /= total_cit;

  // Ordenacao
  while (flag)
  {
    flag = 0;
    for (i = 0; i < amount-1; i++)
    {
      if (totCon[i] > totCon[i+1])
      {
        temp = totCon[i];
        totCon[i] = totCon[i+1];
        totCon[i+1] = temp;
        temp = numRes[i];
        numRes[i] = numRes[i+1];
        numRes[i+1] = temp;
        flag++;
      }
    }
  }

}

void write()
{
  int con, res;
  int index;
  int i;

  cityCont++;
  if (cityCont != 1) printf("\n");
  printf("Cidade# %d:\n", cityCont);
  for (i = 0; i < amount; i++)
  {
    con = totCon[i];
    res = numRes[i];
    while (totCon[i] == totCon[i+1] && i < amount)
    {
      con += totCon[i+1];
      res += numRes[i+1];
      i++;
    }

    printf("%d-%d ", res, con);
  }
  printf("\n");

  printf("Consumo medio: %.2f m3.\n", medium);
}

main()
{
  while(read())
  {
    process();
    write();
  }
}
