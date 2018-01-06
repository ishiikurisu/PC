#include <iostream>
#include <stdlib.h>
using namespace std;

int nd;
int dc;
int* dr;
int fr;
int** memo;

int best(int a, int b)
{ return (a > b)? a : b; }

int eval(int cd, int ad, int cr)
{
  int rc;

  if (cd == nd)
    rc = cr;
  else if (memo[cd][ad] >= 0)
    rc = memo[cd][ad];
  else for (int i = cd; i < nd; ++i) {
    rc = best(cr, best(eval(cd+1, ad, cr), eval(cd+1, ad+1, cr+dr[cd]-dc)));
    if (rc > memo[cd][ad]) memo[cd][ad] = rc;
  }

  return rc;
}

main()
{
  int m, n;

  while (cin >> nd)
  {
    /* read data */
    cin >> dc;
    dr = (int*) malloc(nd*sizeof(int));
    memo = (int**) malloc(nd*sizeof(int*));
    for (m = 0; m < nd; ++m)
    {
      cin >> dr[m];
      memo[m] = (int*) malloc(nd*sizeof(int));
      for (n = 0; n < nd; ++n) memo[m][n] = -1;
    }

    /* process data */
    fr = 0;
    for (m = 0; m < nd; ++m)
      fr = best(fr, eval(m, 0, 0));

    /* write data */
    cout << fr << endl;

    free(dr);
    free(memo);
  }
}
