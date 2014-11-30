#include <iostream>
#include <string.h>
#include <string>
#include <algorithm>
using namespace std;

/*
input:
The first contains the number N of words to process. The next N
lines will contain a word to be processed.
*/

main()
{
  int nc;
  string inlet;
  char* outlet;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> inlet;

    sort(inlet.begin(), inlet.begin() + inlet.length());
    outlet = new char[inlet.length()+1];
    strcpy(outlet, inlet.c_str());
    do { cout << outlet << endl; }
    while (next_permutation(outlet, outlet + inlet.length()));
  }
}
