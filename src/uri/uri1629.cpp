#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

main()
{
  int nc, test_case;
  string test;

  cin >> nc;
  for (int i = 0; i < nc; ++i)
  {
    cin >> test_case;
    sprintf(test, "%b", test_case);
  }
}
