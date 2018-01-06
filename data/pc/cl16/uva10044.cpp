#include <iostream>
#include <vector>
#include <stdlib.h>
using namespace std;

int nw, np;
vector< vector<string> > rels;
vector<string> ppl;

void pass() {}

void read()
{
  string inlet;
  char* person = (char*) malloc(sizeof(char));
  char cc;
  bool comma;
  int c;
  int len;
  vector<string> cur;

  for (int w = 0; w < nw; ++w)
  {
    /* discover people */
    getline(cin, inlet);
    free(person);
    person = (char*) malloc(sizeof(char));
    comma = false;
    c = len = 0;
    cur.clear();

    while (inlet[c] != ':')
    {
      cc = inlet[c];

      if (c == ',' && comma == false)
      {
        comma = true;
        ++len;
        person = (char*) realloc(person, len);
        person[len-1] = c;
      }
      else if (c == ',' && comma == true)
      {
        comma = false;
        len = 0;
        ppl.push_back(string(person));
        cur.push_back(string(person));
        cin >> c;
      }
      else if (c == ':')
        pass();
      else
      {
        ++len;
        person = (char*) realloc(person, len);
        person[len-1] = c;
      }
    }

    /* relate people */
    for (string psn: cur)
    {
      comma = false;

    }

  }
}

main()
{
  int nc;

  cin >> nc;
  for (int c = 0; c < nc; c++)
  {
    cin >> nw >> np;
    rels.clear();
    ppl.clear();
    read();
    process();
    write();
  }
}
