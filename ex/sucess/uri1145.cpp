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
		while (flag < line && numb <= limit)	
		{
			cout << numb;
			if (flag != line - 1) cout << " ";
			numb++;
			flag++;
		}
		cout << endl;
		flag = 0;
	}
}
