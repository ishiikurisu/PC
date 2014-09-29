#include <iostream>
using namespace std;

main()
{
	int nc, result, n1, n2;
	char digits[4];

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> digits;

		n1 = digits[0] - 48;
		n2 = digits[2] - 48;
		if (n1 == n2) 
			result = n1 * n2;
		else if (digits[1] < 97) 
			result = n2 - n1;
		else 
			result = n2 + n1;

		cout << result << endl;
	}
}
