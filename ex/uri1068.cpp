#include <cstdio>
using namespace std;

main()
{
  char input[1000];
  bool result;
  int index;
  int cunt;
  int length;

  while ((length = scanf("%s", &input)) != EOF)
  {
    // process data
    result = true;
    index = 0;
    cunt = 0;

    while (result && (index < length))
    {
      if (input[index] == '(') cunt++;
      else if (input[index] == ')') cunt--;

      if (cunt < 0) result = false;
      index++;
    }

    if (cunt != 0) result = false;

    // write data
    if (result) //output = "correct";
      printf("correct\n");
    else //output = "incorrect";
      printf("incorrect\n");
    //printf("%s\n", output);
  }
}
