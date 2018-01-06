#include <iostream>
using namespace std;

main()
{
  string dollar;
  int cents;
  int cunt;

  while (cin >> dollar >> cents)
  {
    cout << "$";
    cunt = 4 - (dollar.length() % 3);
    for (int n = 0; n < dollar.length(); ++n, ++cunt)
    {
      cout << dollar[n];
      if (cunt % 3 == 0 && cunt != 0 && n != dollar.length() - 1)
        cout << ",";
    }
    cout << ".";
    if (cents < 10) cout << "0";
    cout << cents << endl;
  }
}
