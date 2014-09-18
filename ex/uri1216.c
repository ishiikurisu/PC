#include <stdio.h>

main()
{
  char name[256];
  int sum = 0;
  int num = 0;
  int psum;

  while (scanf("%[^/n]s", &name))
  {
    scanf("%d", &psum);
    sum += psum;
    num++;
  }

  printf("%.1f\n", (sum+0.0)/num);
}
