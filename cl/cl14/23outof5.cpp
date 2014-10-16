#include <iostream>
#include <algorithm>
using namespace std;

int matrix[81][4];
int posses[120][5];
int nums[5];

void poss()
{
  int a, b, c, d, e;
  int l = 0;
  int pss[] = {0, 1, 2, 3, 4};

  while (l < 21)
    for (a = 0; a < 3; ++a)
      for (b = 0; b < 3; ++b)
        for (c = 0; c < 3; ++c)
          for (d = 0; d < 3; ++d)
          {
            matrix[l][0] = a;
            matrix[l][1] = b;
            matrix[l][2] = c;
            matrix[l][3] = d;
            ++l;
          }

  l = 0;
  do
  {
    posses[l][0] = pss[0];
    posses[l][1] = pss[1];
    posses[l][2] = pss[2];
    posses[l][3] = pss[3];
    posses[l][4] = pss[4];
    ++l;
  }
  while(next_permutation(pss, pss + 5));
}

bool read()
{
  int zero = 0;

  for (int n = 0; n < 5; ++n)
  {
    cin >> nums[n];
    if (nums[n] == 0) ++zero;
  }

  if (zero == 5)
    return false;
  else
    return true;
}

main()
{
  bool flag;
  int sum;

  poss();
  while (read())
  {
    flag = false;
    for (int l = 0; l < 120; ++l)
    {
      for (int i = 0; i < 81 && !flag; ++i)
      {
        sum = nums[posses[l][0]];
        int* line = matrix[i];
        for (int a = 0; a < 4; ++a)
        {
          switch (line[a])
          {
            case 0:
              sum += nums[posses[l][a+1]];
            break;

            case 1:
              sum -= nums[posses[l][a+1]];
            break;

            case 2:
              sum *= nums[posses[l][a+1]];
            break;
          }
        }

        if (sum == 23) flag = true;
      }
    }

    if (flag == true) cout << "Possible";
    else cout << "Impossible";
    cout << endl;
  }
}
