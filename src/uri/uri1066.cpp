#include <iostream>
using namespace std;

main()
{
	int par = 0;
	int impar = 0;
	int pos = 0;
	int neg = 0;

	int val;

	for (int i = 0; i < 5; i++)
	{
		cin >> val;

		if (val > 0) pos++;
		else if (val < 0) neg++;
		if (val % 2) impar++;
		else par++;
	}

	cout << par << " valor(es) par(es)\n";
	cout << impar << " valor(es) impar(es)\n";
	cout << pos << " valor(es) positivo(s)\n";
	cout << neg << " valor(es) negativo(s)\n";
}
