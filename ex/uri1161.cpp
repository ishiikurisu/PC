#include <iostream>
#include <string>
#include <cstdio>
using namespace std;

string input;
int number[2];
int sum;

bool read()
{
  cin >> input;

  if (input.length() == 0)
    return false;
  else for (int i = 0; i < 2; i++)
    sscanf(input, "%d", &number[i]);

  return true;
}

int fat(int numb)
{
  int result = 1;

  if (numb <= 1)
    return result;
  else for (int i = numb; i > 1; i++)
    result *= i;

  return result;
}

void process()
{
  sum = fat(number[0]) + fat(number[1]);
}

void write()
{
  cout << sum;
}

main()
{
  while (read())
  {
    process();
    write();
  }
}
