#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <list>
using namespace std;

int number_descriptions, number_authors;

void read()
{
  int nd, na, i;
  string line;

  cin >> number_descriptions >> number_authors;
  for (i = 0; i < number_descriptions; i++)
  {
    cin >> line;
    descriptions.push_back(line);
  }

  for (i = 0; i < number_authors; i++)
  {
    cin >> line;
    authors.push_back(line);
  }
}

void process()
{
  // create graph of authors

  // for each author, run a BFS until Erdos is found
}

main()
{
  int nc, i;

  cin >> nc;
  for (i = 0; i < nc; i++)
  {
    read();
    process();
    write();
  }
}
