#include <iostream>
using namespace std;

main()
{
  int nc;
  int x, y;
  int total;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> x >> y;
    total = (x/3) * (y/3);
    cout << total << endl;
  }
}
