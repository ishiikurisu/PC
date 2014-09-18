#include <stdlib.h>
#include <stdio.h>

int main() {
  char name[256];

  printf("name? ");
  scanf("%s", &name);
  printf("hello %s!\n", name);

  return 0;
}
