#include <iostream>
#include <vector>
using namespace std;

string inlet;
vector<string> outlet;

string form(string word, int pi, int ws)
{
  string new_word = word;

  if (word.length() == ws)
    outlet.push_back(word);
  else for (int i = pi; i < inlet.length(); ++i)
  {
    new_word.append(inlet.substr(i, 1));
    form(new_word, i + 1, ws);
  }
}

main()
{
  while (getline(cin, inlet))
  {
    for (int ws = 1; ws <= inlet.length(); ++ws)
      for (int fs = 0; fs < inlet.length(); ++fs)
        form("", fs, ws);

    for (int i = 0; i < outlet.size(); ++i)
      cout << outlet.at(i) << endl;

    cout << endl;
    outlet.clear();
  }
}
