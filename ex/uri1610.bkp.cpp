#include <iostream>
#include <stdlib.h>
using namespace std;

bool result;
int docs;
int rels;
int past;
int future;
bool** ships;

void alert()
{
  cout << "!!!" << endl;
}

void inlet()
{
  int dom;
  int sub;

  cin >> docs >> rels;
  free(ships);
  ships = (bool**) malloc(docs*sizeof(bool*));
  for (int s = 0; s < docs; ++s)
  {
    ships[s] = (bool*) malloc(sizeof(bool)*docs);
    for (int i = 0; i < docs; ++i)
      ships[s][i] = false;
  }

  for (int r = 0; r < rels; ++r)
  {
    cin >> dom >> sub;
    ships[dom][sub] = true;
  }
}

void process()
{
  bool* path;
  int dom;
  int sub;
  int doc;
  int fil;
  int id;
  result = false;

  for (doc = 0; doc < docs && !result; ++doc)
  {
    path = (bool*) malloc(sizeof(bool)*docs);
    for (int i = 0; i < docs; ++i)
      path[i] = false;

    for (fil = 0; fil < docs; ++fil)
      if (ships[doc][fil]) path[fil] = true;

    for (id = 0; id < docs; ++id)
    {
      if (path[id] && id != doc) {
        dom = id;
        for (sub = 0; sub < docs; ++sub)
          if (ships[dom][sub] && !path[sub])
            path[sub] = true;
      }
    }

    if (path[doc])
      result = true;
    free(path);
  }
}

void outlet()
{
  if (result) cout << "SIM";
  else cout << "NAO";
  cout << endl;
}

main()
{
  int nc;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    inlet();
    process();
    outlet();
  }
}
