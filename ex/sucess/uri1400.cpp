#include <iostream>
#include <cstdio>
#include <cstdlib>

int big, small;

int sequence(int i, int n, int m)
{
  if (small == 0)
    return m + i * big;
  else if (big == 0)
    return m + i * small;
  else if (i % 2 == 0)
    return m + (i/2) * big + (i/2) * small;
  else
    return m + (i/2+1) * big + (i/2) * small;
}

int indexOf(char* s, char c)
{
  int i = 0;
  int r = -1;

  while (s[i] != '\0' && r < 0)
  {
    if (s[i] == c) r = i;
    ++i;
  }

  return r;
}

bool should(int number)
{
  char* numb = (char*) malloc(sizeof(char)*7);
  sprintf(numb, "%d", number);
  bool result = (number % 7 == 0 || indexOf(numb, '7') > 0);
  free(numb);
  return result;
}

main()
{
  int n, m, k;
  int c, i, r;

  std::cin >> n >> m >> k;
  while (n != 0 && m != 0 && k != 0)
  {
    if (m > n || n < 2 || n > 100 || k > 100 || k < 1)
    {
      std::cout << -1 << "\n";
      main();
      break;
    }

    c = i = r = 0;
    big = 2 * (n - m);
    small = 2 * (m - 1);

    while (c < k)
    {
      r = sequence(i, n, m);
      // std::cout << result << " ";
      if (should(r)) c++;
      i++;
    }

    std::cout << r << std::endl;
    std::cin >> n >> m >> k;
  }
}
