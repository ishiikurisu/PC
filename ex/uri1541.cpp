#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;

main()
{
	int m1, m2, pm;

	cout << fixed << setprecision(0);
	cin >> m1;
	while (m1 > 0)
	{
		cin >> m2 >> pm;
		cout << sqrt((m1*m2*100)/pm) << endl;
		cin >> m1;
	}
}
