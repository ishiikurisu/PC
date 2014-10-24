#include <iostream>
#include <set>
using namespace std;

string inlet;
set<string> outlet;

void form(string word, int pi, int ws)
{
  string new_word;

  if (word.length() == ws)
    outlet.insert(word);
  else for (int i = pi; i < inlet.length(); ++i)
  {
    new_word = word + inlet[i];
    form(new_word, i + 1, ws);
  }
}

main()
{
  set<string>::iterator it;

  while (getline(cin, inlet))
  {
    for (int ws = 1; ws <= inlet.length(); ++ws)
      for (int fs = 0; fs < inlet.length(); ++fs)
        form("", fs, ws);

    for (it = outlet.begin(); it != outlet.end(); ++it)
      cout << (*it) << endl;

    cout << endl;
    outlet.clear();
  }
}
