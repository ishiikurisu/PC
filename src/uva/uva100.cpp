#include <iostream>
using namespace std;

int n1, n2;

int cycle_length(int n, int cc)
{
  if (n == 1)
    return cc + 1;
  else if (n % 2 == 0)
    return cycle_length(n/2, cc+1);
  else
    return cycle_length(n*3+1, cc+1);
}

main()
{
  int result;
  int biggest;

  while (cin >> n1 >> n2)
  {
    biggest = 0;

    for (int i = n1; i < n2; ++i)
    {
      /* calculate */
      result = cycle_length(i, 0);

      /* attribuitions */
      if (result > biggest)
        biggest = result;
    }

    cout << n1 << " " << n2 << " " << biggest << endl;
  }
}
