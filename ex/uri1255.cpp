#include <iostream>
#include <sstream>
using namespace std;
const int nl = 'z' - 'a' + 1;

int* init(int* array, int array_size)
{
  for (int i = 0; i < array_size; ++i)
    array[i] = 0;

  return array;
}

bool isLetter(char letter)
{
  if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'))
    return true;
  else
    return false;
}

char transform(char letter) {
  char diff;

  if (letter >= 'a' && letter <= 'z')
    diff = letter - 'a';
  else
    diff = letter - 'A';

  return diff;
}

main()
{
  int nc;
  int bs;
  string inlet;
  int outlet[nl];
  char letter;

  getline(cin, inlet);
  stringstream(inlet) >> nc;
  for (int c = 0; c < nc; c++)
  {
    getline(cin, inlet);
    init(outlet, nl);
    bs = 0;

    for (int l = 0; l <= inlet.length(); ++l)
    {
      letter = inlet[l];
      if (isLetter(letter))
      {
        letter = transform(letter);
        ++outlet[letter];
        if (outlet[letter] >= bs)
          bs = outlet[letter];
      }
    }

    for (int i = 0; i < nl; ++i)
      if (outlet[i] == bs)
        cout << char('a' + i);

    cout << endl;
  }
}
