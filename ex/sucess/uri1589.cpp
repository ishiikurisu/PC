#include <iostream>
using namespace std;

main()
{
	int nc;
	int r1, r2;
	
	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> r1 >> r2;
		cout << r1 + r2 << endl;
	}
}
