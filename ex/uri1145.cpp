#include <iostream>
using namespace std;

main()
{
	int line;
	int limit;
	int numb = 1;
	int flag = 0;

	cin >> line >> limit;
	
	while (numb <= limit)
	{
		while (flag < line)	
		{
			cout << numb << " ";
			numb++;
			flag++;
		}
		cout << endl;
		flag = 0;
	}
	cout << endl;
}
