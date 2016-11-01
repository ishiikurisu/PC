#include <iostream>
using namespace std;

int matrix[81][4];
int posses[120][5];
int nums[5];

void poss()
{
  int l = 0;

  while (l < 21)
    for (int a = 0; a < 3; ++a)
      for (int b = 0; b < 3; ++b)
        for (int c = 0; c < 3; ++c)
          for (int d = 0; d < 3; ++d)
          {
            matrix[l][0] = a;
            matrix[l][1] = b;
            matrix[l][2] = c;
            matrix[l][3] = d;
            ++l;
          }

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
    poss_num();
    flag = false;
    for (int i = 0; i < 81 && !flag; ++i)
    {
      sum = nums[0];
      int* line = matrix[i];
      for (int a = 0; a < 4; ++a)
      {
        switch (line[a])
        {
          case 0:
            sum += nums[a+1];
          break;

          case 1:
            sum -= nums[a+1];
          break;

          case 2:
            sum *= nums[a+1];
          break;
        }
      }

      if (sum == 23) flag = true;
    }

    if (flag == true) cout << "Possible";
    else cout << "Impossible";
    cout << endl;
  }
}
