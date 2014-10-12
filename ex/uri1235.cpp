#include <iostream>
using namespace std;

main()
{
	int nc;
	int length;
	string line;

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		getline(cin, line);
		length = line.length();
		for (int i = length/2-1; i >= 0; --i)
			cout << line[i];
		for (int i = length-1; i >= length/2; --i)
			cout << line[i];

		cout << '\n';
	}
}
