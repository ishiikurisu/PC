#include <iostream>
using namespace std;

int people, step, result;

int josephus(int n, int k)
{
  int r = 0, i = 1;

  while (i <= n)
  {
    r = (r + k) % i;
    i++;
  }

  return ++r;
}

void read()
{
  cin >> people >> step;
}

void process()
{
  result = josephus(people, step);
}

void write(int number_case)
{
  cout << "Case " << number_case << ": " << result << endl;
}

main()
{
  int number_cases, c;

  cin >> number_cases;
  for (c = 1; c <= number_cases; c++)
  {
    read();
    process();
    write(c);
  }
}
