#include <iostream>
#include <sstream>
using namespace std;

string rotn(string inlet, int n) 
{
    string outlet;
    char letter;
 
    for (int c = 0; c < inlet.length(); c++)
    {
        letter = inlet[c];
        if ((letter >= 'a' && letter <= 'z') ||
            (inlet[c] >= 'A' && letter <= 'Z'))
        {
            if (letter > 'Z' - n && letter < 'a')
                letter = 'A' + letter + n - 1 - 'Z';
            else if (letter > 'z' - 13)
                letter = 'a' + letter + n - 1 - 'z';
            else
                letter += n;
        }
        outlet.append(&letter);
    }
    
    return outlet;
}

main()
{
	int nc;
	string inlet;
	string number;
	int n;

	cin >> nc;
	for (int c = 0; c < nc; ++c)
	{
		cin >> inlet >> n;
		// getline(cin, inlet);
		// getline(cin, number);
		// stringstream(number) >> n;
		cout << rotn(inlet, n) << endl;
	}
}
