#include <iostream>
#include <math.h>
#define DIST (12.0)
using namespace std;

main()
{
  double D, VF, VG;
  double TF, TG;

  while (cin >> D >> VF >> VG)
  {
    TF =  DIST / VF;
    TG = sqrt(D*D + DIST*DIST) / VG;

    if (TF < TG)
      cout << "N";
    else
      cout << "S";
    cout << endl;
  }
}
