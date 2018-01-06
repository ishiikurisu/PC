#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int size;
int cont;
vector<int> seq;

bool read()
{
  cin >> size;

  if (size == 0) return false;
  for (int i = 0; i < size; i++)
  {
    int input;
    cin >> input;
    seq.push_back(input);
  }

  return true;
}

bool comp(int a, int b)
{
  cont++;
  return (a < b);
}

void process()
{
  cont = 0;
  sort(seq.begin(), seq.end(), comp);
  if (cont % 2 == 0) cout << "Buzzfizz" << endl;
  else cout << "Busstop" << endl;
}

main()
{
  while (read())
  {
    process();
  }
}
