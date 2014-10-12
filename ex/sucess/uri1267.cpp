#include <iostream>
#include <stdlib.h>
using namespace std;

main()
{
  int na, nd, pp;
  int* people;
  bool flag;

  while (cin >> na >> nd)
  {
    people = (int*) malloc(sizeof(int) * na);
    for (int a = 0; a < na; ++a)
      people[a] = 0;
    for (int d = 0; d < nd; ++d)
      for (int p = 0; p < na; ++p)
      {
        cin >> pp;
        people[p] += pp;
      }

    flag = false;
    for (int i = 0; i < na && !flag; ++i)
      if (people[i] == na) flag = true;

    if (flag) cout << "yes";
    else cout << "no";
    cout << endl;
    free(people);
  }
}
