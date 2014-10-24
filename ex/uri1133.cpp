#include <iostream>
using namespace std;

main()
{
	int low, high;
	cin >> low >> high;

	if (high < low)
	{
		int temp = high;
		high = low;
		low = temp;
	}
	for (int n = low; n < high; ++n)
		if (n % 5 == 2 || n % 5 == 3)
			cout << n << endl;
}
