#include <iostream>
using namespace std;

main()
{
  string inlet;
  bool open_i;
  bool open_b;

  while (getline(cin, inlet))
  {
    open_i = false;
    open_b = false;
    for (int c = 0; c < inlet.length(); c++)
    {
      if (inlet[c] == '_')
      {
        if (open_i == true)
        {
          cout << "</i>";
          open_i = false;
        }
        else
        {
          cout << "<i>";
          open_i = true;
        }
      }
      else if (inlet[c] == '*')
      {
        if (open_b == true)
        {
          cout << "</b>";
          open_b = false;
        }
        else
        {
          cout << "<b>";
          open_b = true;
        }
      }
      else
      {
        cout << inlet[c];
      }
    }
    cout << endl;
  }
}
