#include <iostream>
using namespace std;

main()
{
	int ducks;
	int rounds;
	
	while (cin >> ducks)
	{
		rounds = ducks / 3;
		if (ducks % 3 > 1) rounds += 2;

		cout << rounds << endl;
	}
}
