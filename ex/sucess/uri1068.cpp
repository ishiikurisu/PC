#include <stdio.h>
#include <iostream>
using namespace std;

main()
{
  string inlet;
  bool outlet;
  int open;

  while (getline(cin, inlet))
  {
    // process data
    outlet = true;
    open = 0;

    for (int index = 0; index <= inlet.length() && outlet; ++index)
    {
      if (inlet[index] == '(') ++open;
      else if (inlet[index] == ')') --open;

      if (open < 0) outlet = false;
    }

    if (open != 0)
      outlet = false;

    // write data
    if (outlet)
      cout << "correct";
    else
      cout << "incorrect";
    cout << endl;
  }
}
