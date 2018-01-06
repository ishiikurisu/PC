#include <iostream>
using namespace std;

int feyn(int n)
{
	if (n == 1)
		return 1;
	else
		return feyn(n-1) + n*n;
}

main()
{
	int side;

	cin >> side;
	while (side > 0)
	{
		cout << feyn(side) << endl;
		cin >> side;
	}
}
