#include <iostream>
#define DIST (12.0)
using namespace std;

main()
{
  int D, VF, VG;
  float TF, TG;

  while (cin >> D >> VF >> VG)
  {
    TF = DIST/VF;
    TG = ((float)D)/(VG-VF);
    cout << TF << " " << TG << '\t';

    if (TG >= TF) cout << "S";
    else cout << "N";
    cout << endl;
  }
}
