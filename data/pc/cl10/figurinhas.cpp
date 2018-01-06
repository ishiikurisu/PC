#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int J, F;
vector<int> JFig, FFig;
vector<int> ask;
int grito = 0;

bool read()
{
  cin >> F >> J;

  if (J == 0 && F == 0) return false;

  for (int i = 0; i < F; i++)
  {
    int input;
    cin >> input;
    FFig.push_back(input);
  }

  for (int i = 0; i < J; i++)
  {
    int input;
    cin >> input;
    JFig.push_back(input);
  }

  return true;
}

void process()
{
  bool flag = false;
  sort(FFig.begin(), FFig.end());

  grito++;
  cout << "GRITO #" << grito << endl;
  for (int x = 0; x < J; x++) {

    for (int y = 0; y < F; y++) {
      flag = false;

      if (FFig.at(y) == JFig.at(x)) {
        cout << JFig.at(x) << " escalado na posicao " << y + 1 << endl;
        FFig[y] = 0;
        //cout FFig.get(y-1));
        flag = true;
        break;
      }
    }

    if (flag == false)
      cout << JFig.at(x) << " nao foi convocado" << endl;
  }

  JFig.clear();
  FFig.clear();
}

main()
{
  while (read()) process();
}
