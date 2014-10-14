#include <iostream>
#include <stdlib.h>
using namespace std;

main()
{
  int nbils, nppl, bil, ppl;
  int* bils;

  cin >> nbils >> nppl;
  while (nbils != 0 && nppl != 0)
  {
    bils = (int*) malloc(sizeof(int)*nbils);
    for (int a = 0; a < nbils; ++a)
      bils[a] = 0;
    ppl = 0;
    for (int b = 0; b < nppl; ++b)
    {
      cin >> bil;
      bils[bil-1]++;
    }
    for (int c = 0; c < nbils; ++c)
      if (bils[c] > 1)
        ++ppl;

    free(bils);
    cout << ppl << endl;
    cin >> nbils >> nppl;
  }
}
