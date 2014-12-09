#include <iostream>
using namespace std;

void swap(int* x, int* y)
{
	*x ^= *y;
	*y ^= *x;
	*x ^= *y;
}

main()
{
	int low, high;
	cin >> low >> high;

	if (high < low)
		swap(&high, &low);
	for (int n = low; n < high; ++n)
		if (n % 5 == 2 || n % 5 == 3 || n % 5 == -2 || n % 5 == -3)
			cout << n << endl;
}
