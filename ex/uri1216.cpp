#include <iostream>
#include <iomanip>
using namespace std;

main()
{
	double d;
	double m = 0;
	int n = 0;
	string inlet;

	cout << fixed << setprecision(1);
	while (getline(cin, inlet))
	{
		cin >> d;
		m += d;
		n++;
	}

	cout << m << " " << n << endl;
	m /= n;
	cout << m << '\n';
}
