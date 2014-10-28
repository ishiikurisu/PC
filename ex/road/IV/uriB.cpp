#include <iostream>
#include <math.h>
using namespace std;
const unsigned long LIMIT = (unsigned long) pow(10, 12);

bool is_bin (unsigned long number)
{
  bool flag = true;

  while (number > 0 && flag == true)
  {
    if (!(number % 10 == 0 || number % 10 == 1))
      flag = false;
    else
      number /= 10;
    cout << number << " ";
  }

  return flag;
}

main()
{
  unsigned long inlet;
  unsigned long outlet;

  while (cin >> inlet)
  {
    outlet = inlet;

    while (!is_bin(outlet) && outlet <= LIMIT)
      outlet += inlet;

    if (outlet > LIMIT) cout << "-1";
    else cout << outlet;
    cout << endl;
  }
}
