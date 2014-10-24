#include <iostream>
using namespace std;

main()
{
  int nc, limit, i;
  string w1, w2, big;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> w1 >> w2;
    if (w1.length() < w2.length())
    {
      limit = w1.length();
      big = w2;
    }
    else
    {
      limit = w2.length();
      big = w1;
    }

    for (i = 0; i < limit; ++i)
    {
      cout << w1[i];
      cout << w2[i];
    }
    for (; i < big.length(); ++i)
      cout << big[i];
    cout << endl;
  }
}
