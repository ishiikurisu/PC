#include <iostream>
#include <bitset>
#include <string.h>
#define ALP_SIZ 26
#define NMB_MLS 3
using namespace std;

main()
{
  int nc;
  int i, j;
  char letter;
  string food;
  bool cheat_alert;
  bitset<ALP_SIZ> meal[NMB_MLS];

  cin >> nc;
  getline(cin, food);
  for (int c = 0; c < nc; c++)
  {
    /* READ DATA */
    for (i = 0; i < NMB_MLS; ++i)
    {
      getline(cin, food);
      meal[i].reset();

      for (j = 0; j < food.length(); ++j)
        meal[i].set(food[j] - 'A', true);

      // cout << meal[i] << endl;
    }


    /* PROCESS DATA */
    cheat_alert = false;

    for (i = 0; i < ALP_SIZ && !cheat_alert; ++i)
      for (j = 1; j < NMB_MLS && !cheat_alert; ++j)
        if (meal[j].test(i) == true && meal[0].test(i) == true)
          meal[0].set(i, false);
        else if (meal[j].test(i) == true && meal[0].test(i) == false)
          cheat_alert = true;

    /* WRITE DATA */
    if (cheat_alert == true)
      cout << "CHEATER";
    else for (i = 0; i < ALP_SIZ; ++i)
      if (meal[0][i] == true)
      {
        letter = 'A' + i;
        cout << letter;
      }
    cout << endl;
  }
}
