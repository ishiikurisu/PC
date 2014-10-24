#include <iostream>
using namespace std;

main()
{
  int nc, i, j;
  string head, tail;
  bool flag;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> head >> tail;
    i = head.length() - 1;
    j = tail.length() - 1;
    flag = true;

    while (j >= 0 && flag)
    {
      if (head[i] != tail[j])
        flag = false;
      --i; --j;
    }

    if (flag == true)
      cout << "encaixa";
    else
      cout << "nao encaixa";
    cout << endl;
  }
}
