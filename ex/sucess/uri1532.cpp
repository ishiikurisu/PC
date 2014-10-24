#include <iostream>
using namespace std;

main()
{
  int N, K;
  int n, i, l;
  int cunt;
  bool flag;

  cin >> K >> N;
  while (N != 0 && K != 0)
  {
    flag = false;

    for (l = N; l > 0; --l)
    {
      cunt = 0;

      for (n = l; n > 0; --n)
      {
        for (i = 0; i < n; ++i)
        {
          cunt += n;
          if (cunt == K)
          {
            flag = true;
            break;
          }
          else if (cunt > K)
            break;
        }
      }
    }

    if (flag == true) cout << "possivel";
    else cout << "impossivel";
    cout << endl;
    cin >> K >> N;
  }
}
