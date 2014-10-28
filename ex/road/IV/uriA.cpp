#include <iostream>
#include <vector>
using namespace std;

main()
{
  int nt, nh, nl;
  int tl, th;
  int pl, ph;
  int bl;
  int i, j, k;
  int cc;
  vector<int> ll;
  vector<int> hh;

  while (cin >> nt >> nt)
  {
    bl = 0;
    nl = 0;

    for (k = 0; k < nt; ++k)
    {
      cin >> tl >> th;
      nl += tl;
      ll.push_back(tl);
      hh.push_back(th);
    }

    cc = 1 << nt;
    cout << "  " << cc << endl;
    for (i = 1; i < cc; ++i)
    {
      j = pl = ph = 0;
      while (i >> j != 0)
      {
        if ((i >> j) & 0x1)
        {
          pl += ll[j];
          ph += hh[j];
        }
        ++j;
      }

      if (pl > bl && ph <= th)
        bl = pl;
    }

    ll.clear();
    hh.clear();
    cout << (nl - bl) << endl;
  }
}
