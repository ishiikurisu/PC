#include <iostream>
using namespace std;

main()
{
	int nc;
	string inlet;
	int n;
  char letter;

	cin >> nc;
	for (int c = 0; c < nc; ++c)
	{
    cin >> inlet >> n;
    for (int i = 0; i < inlet.length(); ++i)
    {
      letter = inlet.at(i);

      if (letter - n < 'A')
        letter = 'Z' - 'A' + letter - n + 1;
      else
        letter -= n;

      cout << letter;
    }
		cout <<  endl;
	}
}
