#include <iostream>
#include <sstream>
using namespace std;

main()
{
	int nc;
	int length;
	string line;


	getline(cin, line);
	stringstream(line) >> nc;
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
