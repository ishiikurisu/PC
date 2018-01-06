#include <iostream>
#define NUM_RUL 10
#define NUM_DIS 40
#define NUM_DAY 50
using namespace std;

int present[NUM_DIS];
int rule[NUM_RUL];

void write()
{
  char letter;

  for (int d = 0; d < NUM_DIS; ++d)
  {
    switch (present[d])
    {
      case 1: letter = '.'; break;
      case 2: letter = 'x'; break;
      case 3: letter = 'W'; break;
      default: letter = ' ';
    }
    cout << letter;
  }

  cout << endl;
}

void update()
{
  int future[NUM_DIS];
  int sum, i;

  sum = present[0] + present[1];
  future[0] = rule[sum];
  for (i = 1; i < NUM_DIS - 1; ++i)
  {
    sum = present[i-1] + present[i] + present[i+1];
    future[i] = rule[sum];
  }
  sum = present[NUM_DIS-2] + present[NUM_DIS-1];
  future[NUM_DIS-1] = rule[sum];

  for (i = 0; i < NUM_DIS; ++i)
    present[i] = future[i];
}

main()
{
  int nc;
  int c, d, r;

  cin >> nc;
  for (c = 0; c < nc; c++)
  {
    for (r = 0; r < NUM_RUL; ++r)
      cin >> rule[r];

    for (r = 0; r < NUM_DIS; ++r)
      present[r] = 0;
    present[19] = 1;
    write();

    for (d = 0; d <= NUM_DAY; ++d)
    {
      update();
      write();
    }
    cout << endl;
  }
}
