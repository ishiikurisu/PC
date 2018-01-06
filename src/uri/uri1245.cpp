#include <iostream>
#include <vector>
using namespace std;

main()
{
  int nb;
  int np;
  int s;
  string f;
  bool flag;
  vector<int> fs;
  vector<bool> ff;

  while (cin >> nb)
  {
    np = 0;

    for (int b = 0; b < nb; ++b)
    {
      cin >> s >> f;
      fs.push_back(s);
      if (f.compare("D") == 0)
        ff.push_back(true);
      else
        ff.push_back(false);

      for (int i = 0; i < b; ++i)
      {
        flag = false;
        for (int j = i + 1; j <= b && !flag; ++j)
        {
          if (fs[i] == fs[j] && ff[i] != ff[j])
          {
            flag = true;
            fs[i] = fs[j] = 0;
            ff[i] = ff[j] = false;
            ++np;
          }
        }
      }
    }

    fs.clear();
    ff.clear();
    cout << np << endl;
  }
}

// gin wigmore - kill of the night
