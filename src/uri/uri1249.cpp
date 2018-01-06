#include <iostream>
#include <stdio.h>
using namespace std;

main()
{
  string inlet;
  char letter;

  while (getline(cin, inlet))
  {
    for (int c = 0; c < inlet.length(); c++)
    {
      letter = inlet[c];
      if ((letter >= 'a' && letter <= 'z') ||
        (inlet[c] >= 'A' && letter <= 'Z'))
      {
        if (letter > 'Z' - 13 && letter < 'a')
          letter = 'A' + letter + 12 - 'Z';
        else if (letter > 'z' - 13)
          letter = 'a' + letter + 12 - 'z';
        else
          letter += 13;
      }
      printf("%c", letter);
    }
    cout << endl;
  }
}
