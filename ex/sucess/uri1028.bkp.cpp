#include <iostream>
#include <list>
#include <vector>
using namespace std;

static list< vector<int> > par;
static list<int> stack;

bool read()
{
  int number_cases;
  bool flag = true;
  vector<int> card;
  int current_card;

  cin >> number_cases;
  if (number_cases == 0) {
    flag = false;
  }
  else {
    par.clear();
    for (int j = 0; j < number_cases; j++)
    {
      card.clear();
      for (int i = 0; i < 2; i++)
      {
        cin >> current_card;
        card.push_back(current_card);
      }
      par.push_back(card);
    }
  }

  return flag;
}

void process()
{
  list< vector<int> >::iterator it;
  int mdc, limit;

  for (it = par.begin(); it != par.end(); it++)
  {
    vector<int> vc = *it;
    limit = (vc.at(0) < vc.at(1))? vc.at(0): vc.at(1);

    mdc = 1;
    for (int i = 2; i <= limit; i++)
      if (vc.at(0) % i == 0 && vc.at(1) % i == 0)
        mdc = i;

    stack.push_back(mdc);
  }
}

void write()
{
  for (list<int>::iterator it = stack.begin(); it != stack.end(); it++)
    cout << *it << endl;

  stack.clear();
  par.clear();
}

main()
{
  read();
  process();
  write();
}
