#include <iostream>
#include <iomanip>
using namespace std;

main()
{
	double dt, vm;
	cout << fixed << setprecision(3);
	cin >> dt >> vm;
	cout << (vm*dt)/12 << endl;
}
