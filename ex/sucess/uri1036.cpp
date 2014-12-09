#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

main()
{
  double A, B, C, D;

  cout << fixed << setprecision(5);
  cin >> A >> B >> C;
  D = B * B - 4 * A * C;
  if (D < 0 || A == 0)
    cout << "Impossivel calcular";
  else
  {
    cout << "R1 = " << (-B + sqrt(D))/(2 * A) << endl;
    cout << "R2 = " << (-B - sqrt(D))/(2 * A);
  }

  cout << endl;
}
