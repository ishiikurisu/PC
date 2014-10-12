#include <iostream>
using namespace std;

main()
{
  int D, VF, VG;
  float TF, TG;

  while (cin >> D >> VF >> VG)
  {
    TF = (VF)/12.0;
    TG = (VG-VF+0.0)/D;

    if (TG > TF) cout << "S";
    else cout << "N";
    cout << endl;
  }
}
