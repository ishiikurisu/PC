#include <iostream>
using namespace std;

int abs(int x)
{ return (x > 0)? x : -x; }

void swap(int* x, int* y)
{
	*x ^= *y;
	*y ^= *x;
	*x ^= *y;
}

void test(int n)
{
	if (n % 5 == 2 || n % 5 == 3)
		cout << n << endl;
}

main()
{
	int low, high;
	cin >> low >> high;

	if (high < low)
		swap(&high, &low);
	for (int n = low + 1; n < high; ++n)
		test(n);
}
