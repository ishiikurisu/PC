#include <iostream>
using namespace std;

int count(unsigned long low, unsigned long high)
{
  unsigned long f1 = 0, f2 = 1, temp;
  int c = 0;

  while (f2 < low)
  {
    temp = f2;
    f2 += f1;
    f1 = temp;
  }

  while (f2 < high)
  {
    temp = f2;
    f2 += f1;
    f1 = temp;
    c++;
  }

  return c;
}

main()
{
  unsigned long low, high;

  cin >> low >> high;
  while (low > 0 && high > 0)
  {
    cout << count(low, high) << endl;
    cin >> low >> high;
  }
}
