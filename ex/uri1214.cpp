#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;

main()
{
  int nc, nt, nd;
  float grade, medium;
  vector<float> grades;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> nt;
    medium = nd = 0;

    for (int g = 0; g < nt; ++g)
    {
      cin >> grade;
      medium += grade;
      grades.push_back(grade);
    }

    medium /= nt;
    for (int g = 0; g < nt; ++g)
      if (grades.at(g) > medium) ++nd;

    printf("%.3f%\n", (100.0*nd)/nt);
    grades.clear();
  }
}
