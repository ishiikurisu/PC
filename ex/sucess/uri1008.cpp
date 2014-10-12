#include <iostream>
#include <iomanip>
using namespace std;

main()
{
	cout << fixed << setprecision(2);
	int n, qtd;
	double sal;

	cin >> n >> qtd >> sal;
	cout << "NUMBER = " << n << endl;
	cout << "SALARY = U$ " << qtd*sal << endl;
}
