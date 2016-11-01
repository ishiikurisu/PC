#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;

int num, tam, jog, jogador = 1;
vector<int> arm, espera;
int* pos;
int jogo = 1;

bool read()
{
  int i;
  //cout << "#" << jogo << endl;
  cin >> num >> tam;
  // cout << num << " " << tam << endl;
  if (num == 0 || tam == 0) return false;
  for (i = 0; i < 3; i++)
  {
    int input;
    cin >> input;
    arm.push_back(input);
  }

  cin >> jog;
  pos = (int*) malloc(sizeof(int)*num);
  for (i = 0; i < num; i++) {
    pos[i] = 0;
  }

  jogador = 1;
  vector<int>::iterator it;
  for (i = 0; i < jog; i++) {
    it = find(espera.begin(), espera.end(), jogador);

    if (it != espera.end()) {
      //jogador++;
      *it = 0;
    }
    else {
      int d1, d2;
      cin >> d1 >> d2;
      int sum = d1 + d2;
      pos[jogador-1] += sum;

      // cout << jogador << " " << pos[jogador-1] << endl;
      if (find(arm.begin(), arm.end(), pos[jogador-1]) != arm.end()) {
        // cout << "LOL" << endl;
        espera.push_back(jogador);
      }

      if (pos[jogador-1] > tam) {
        cout << jogador << endl;
        arm.clear();
        espera.clear();
        // cout << "  " << i << endl;
        for (int j = i; j < jog; j++) cin >> d1 >> d2;
        return true;
      }
    }

    jogador++;
    if (jogador > num) jogador = 1;
  }
}

main()
{
  while (read());
}
