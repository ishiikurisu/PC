#include <iostream>
#include <cmath>
using namespace std;

main()
{
	int nc, number, test;
	bool flag;

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> number;
		flag = true;
		test = 2;
		while (test < sqrt(number) && flag)
		{
			if (number % test == 0) flag = false;
			test++;
		}
		
		if (flag) cout << "Prime";
		else cout << "Not Prime";
		cout << endl;
	}
}
