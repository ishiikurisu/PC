#include <iostream>
using namespace std;

main()
{
	int n;
	
	cin >> n;
	int fib[n];
	for (int k = 0; k < n; ++k)
		if (k == 0) fib[k] = k;
		else if (k == 1) fib[k] = k;
		else fib[k] = fib[k-1] + fib[k-2];
	for (int j = 0; j < n - 1; ++j)
		cout << fib[j] << " ";
	cout << fib[n-1] << endl;
}
