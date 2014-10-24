#include <iostream>
using namespace std;

main()
{
	int n;
	int sum;
	cin >> n;
	while (n != 0)
	{
		if (n % 2 != 0) ++n;
		sum = n;
		for (int i = 0; i < 4; ++i)
		{
			n += 2;
			sum += n;
		}
		cout << sum << endl;
		cin >> n;
	}
}
