#include <iostream>
#include <stdlib.h>
#include <list>
using namespace std;

int nb;
list* pile;

bool process(string action)
{
  string* 

  if (action.compare("quit") == 0)
    return false;



  return true;
}

main()
{
  string action;

  /* initialize list */
  cin >> nb;
  pile = (list*) malloc(sizeof(list)*nb);
  for (int i = 0; i < 10; ++i)
  {
    list<int> temp_list;
    temp_list.add(i+1);
    pile[i] = list(temp_list);
  }

  /* perform action */
  do
  {
    getline(cin, action);
  }
  while (process(action));

  write(nb, pile);
}
