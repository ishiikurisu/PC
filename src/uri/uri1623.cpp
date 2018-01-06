#include <iostream>
using namespace std;

int N, Q, T;
int result;

bool read()
{
  cin >> N >> Q;

  if (N == 0 || Q  == 0) return false;

  cin >> T;
  return true;
}

main()
{
  while (read())
  {
    result = (Q*T)/N;

    if (result < T) cout << result;
    else cout << "descartado";
    cout << endl;
  }
}
