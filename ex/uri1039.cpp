#include <iostream>
using namespace std;

main()
{
  int R1, X1, Y1, R2, X2, Y2;

  while (cin >> R1 >> X1 >> Y1 >> R2 >> X2 >> Y2)
  {
      if (X1 + R1 >= X2 + R2 && Y1 + R1 >= Y2 + R2)
        cout << "RICO" << endl;
      else
        cout << "MORTO" << endl;
  }
}
