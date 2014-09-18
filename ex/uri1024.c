#include <stdlib.h>
#include <stdio.h>

int num_tests;
char** phrases;
char** new_phrases;

int read()
{
  char letter;
  int size;

  scanf("%d", &num_tests);
  if (num_tests == 0) return num_tests;

  phrases = (char**) malloc(sizeof(char*)*num_tests);
  for (int i = 0; i < num_tests; i++)
  {
    phrases[i] = (char*) malloc(sizeof(char));
    size = 1;
    scanf("%c", &letter);
    while (letter != '\0' || letter != '\n')
    {
      phrases[i][size-1] = letter;
      scanf("%c", &letter);
      phrases[i] = (char*) realloc(phrases[i], sizeof(char)*size+1);
      size++;
    }
    phrases[i][size-1] = '\0';
  }

  return true;
}

void process()
{

}

void draw()
{
  for (int i = 0; i < num_tests; i++)
  {
    printf("%s\n", phrases[i]);
  }
}

main()
{
  while (read()) {
    process();
    draw();
  }
}
