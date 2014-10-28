#include <iostream>
using namespace std;

main()
{
  const long limit = 1000000000000;
  unsigned long inlet;
  unsigned long outlet;

  while (cin >> inlet)
  {
    outlet = 10;

    while (inlet % outlet != 0 && outlet < limit)
    {
      if (outlet % 2 == 0)
        ++outlet;
      else
        outlet += 9;
    }

    if (outlet > limit) cout << "-1" << endl;
    else cout << outlet << endl;
  }
}
