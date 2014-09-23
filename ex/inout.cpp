#include <iostream>
using namespace std;

main()
{
	int length;
	string word;
	bool flag = true;

	while (flag)
	{
		cin >> word >> endl;
		length = word.length();
		cout << length << endl;
		if (length == 0) flag = false;
	}
}
